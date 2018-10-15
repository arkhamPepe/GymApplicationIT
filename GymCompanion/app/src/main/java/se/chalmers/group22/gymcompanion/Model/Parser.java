package se.chalmers.group22.gymcompanion.Model;

import com.google.gson.*;
import se.chalmers.group22.gymcompanion.Model.Exercises.CardioExercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.StrengthExercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
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

    public List<Routine> parseRoutines(){
        List<Exercise> totalExercises = new ArrayList<>();
        totalExercises.addAll(parseCardioExercises());
        totalExercises.addAll(parseStrengthExercises());

        List<Routine> routines = new ArrayList<>();
        String stringJSON = readFile("routines.json");

        JsonElement jElement = new JsonParser().parse(stringJSON);
        JsonArray jsonRoutineArray = jElement.getAsJsonArray();

        for(int i = 0; i < jsonRoutineArray.size(); i++){
            JsonObject jsonRoutine = jsonRoutineArray.get(i).getAsJsonObject();
            JsonArray exerciseList = jsonRoutine.getAsJsonArray("exercises");

            String routineName = jsonRoutine.get("name").getAsString();
            List<Exercise> routineExercises = getMatchingExercisesInTotal(exerciseList, totalExercises);

            Routine r = new Routine(routineName, routineExercises);
            routines.add(r);
        }
        return routines;
    }

    private List<Exercise> getMatchingExercisesInTotal(JsonArray exerciseList, List<Exercise> totalExercises){
        List<Exercise> matchingExercises = new ArrayList<>();
        for(int i = 0; i < exerciseList.size(); i++){
            String exerciseName = exerciseList.get(i).getAsString();
            Exercise match = getExerciseWithMatchingName(exerciseName, totalExercises);
            matchingExercises.add(match);
        }
        return matchingExercises;
    }

    private Exercise getExerciseWithMatchingName(String name, List<Exercise> totalExercises){
        for(Exercise exercise : totalExercises){
            if(exercise.getName().equals(name)){
                return exercise;
            }
        }
        return null;
    }

    private String readFile(String filePath)
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
