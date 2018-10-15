package se.chalmers.group22.gymcompanion.Model;

import com.google.gson.*;
import se.chalmers.group22.gymcompanion.Model.Exercises.CardioExercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.StrengthExercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public List<StrengthExercise> parseStrengthExercises() {
        List<StrengthExercise> exercises = new ArrayList<>();
        String stringJSON = readFile("strength_exercises.json");
        Gson gson = new Gson();
        JsonElement jElement = new JsonParser().parse(stringJSON);
        JsonArray jArray = jElement.getAsJsonArray();
        for(int i = 0; i < jArray.size(); i++){
            JsonObject jObject = jArray.get(i).getAsJsonObject();
            StrengthExercise se = gson.fromJson(jObject, StrengthExercise.class);
            exercises.add(se);
        }
        return exercises;
    }

    public List<CardioExercise> parseCardioExercises(){
        List<CardioExercise> exercises = new ArrayList<>();
        return null;
    }

    private static String readFile(String filePath)
    {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null)
            {
                sCurrentLine = sCurrentLine.replace('"','\"').trim();
                contentBuilder.append(sCurrentLine);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }
}
