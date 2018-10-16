package se.chalmers.group22.gymcompanion.Model;

import com.google.gson.*;
import lombok.Getter;
import se.chalmers.group22.gymcompanion.Model.Exercises.CardioExercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.StrengthExercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Parser {

    private List<Exercise> exercises;
    private List<Routine> routines;

    // Must be called before any getters are used
    public void parseJson(){
        exercises = parseExercises();
        routines = parseRoutines();
    }

    private List<StrengthExercise> parseStrengthExercises() {
        return parseExerciseHelper("strength_exercises.json", StrengthExercise.class);
    }

    private List<CardioExercise> parseCardioExercises(){
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

    private List<Exercise> parseExercises(){
        List<Exercise> exerciseList = new ArrayList<>();
        exerciseList.addAll(parseStrengthExercises());
        exerciseList.addAll(parseCardioExercises());
        return exerciseList;
    }

    private List<Routine> parseRoutines(){
        List<Exercise> totalExercises = exercises;

        List<Routine> routines = new ArrayList<>();
        String stringJSON = readFile("routines.json");
        Gson gson = new Gson();
        JsonElement jElement = new JsonParser().parse(stringJSON);
        JsonArray jArray = jElement.getAsJsonArray();

        for(int i = 0; i < jArray.size(); i++){
            JsonObject jObject = jArray.get(i).getAsJsonObject();
            List<Exercise> routineExercises = new ArrayList<>();
            JsonArray exerciseList = jObject.getAsJsonArray("exercises");

            for(int j = 0; j < exerciseList.size(); j++){
                String exerciseName = exerciseList.get(j).getAsString();
                Exercise match = totalExercises.get(indexForTotalExerciseList(exerciseName, totalExercises));
                routineExercises.add(match);
            }

            Routine r = new Routine(jObject.get("name").getAsString(), routineExercises);
            routines.add(r);
        }
        return routines;
    }

    private int indexForTotalExerciseList(String name, List<Exercise> totalExercises){
        int i = 0;
        for(Exercise exercise : totalExercises){
            if(exercise.getName().equals(name)){
                return i;
            }
            i++;
        }
        return -1;
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
