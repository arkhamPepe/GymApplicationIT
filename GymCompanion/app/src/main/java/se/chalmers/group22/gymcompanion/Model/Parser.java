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
        return parseExerciseHelper("strength_exercises.json", StrengthExercise.class);
    }

    public List<CardioExercise> parseCardioExercises(){
        return parseExerciseHelper("cardio_exercises.json", CardioExercise.class);
    }

    private <T extends Exercise> List<T> parseExerciseHelper(String fileName, Class<T> className){
        List<T> exercises = new ArrayList<>();
        String stringJSON = readFile(fileName);
        Gson gson = new Gson();
        JsonElement jElement = new JsonParser().parse(stringJSON);
        JsonArray jArray = jElement.getAsJsonArray();
        for(int i = 0; i < jArray.size(); i++){
            JsonObject jObject = jArray.get(i).getAsJsonObject();
            T ce = gson.fromJson(jObject, className);
            exercises.add(ce);
        }
        return exercises;
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
