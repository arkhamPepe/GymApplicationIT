package se.chalmers.group22.gymcompanion.Model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.StrengthExercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public List<Exercise> parseExercises() {
        List<Exercise> exerciseList = new ArrayList<>();
        String stringJSON = readFile("exercises.json");

        JSONObject jsonObject;
        JSONArray exerciseListJSON;
        JSONObject exerciseObject;

        ObjectMapper mapper = new ObjectMapper();
        Exercise exercise;


        try {
            jsonObject = new JSONObject(stringJSON);
            exerciseListJSON = jsonObject.getJSONArray("exercises");
            for(int i = 0; i < exerciseListJSON.length(); i++){
                exerciseObject = exerciseListJSON.getJSONObject(i);
                exercise = mapper.readValue(exerciseObject.toString(), StrengthExercise.class);
                exerciseList.add(exercise);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return exerciseList;
    }

    private static String readFile(String filePath)
    {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null)
            {
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
