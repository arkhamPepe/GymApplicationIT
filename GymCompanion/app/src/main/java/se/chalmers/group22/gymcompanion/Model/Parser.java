package se.chalmers.group22.gymcompanion.Model;

import com.google.gson.*;
import lombok.Getter;
import se.chalmers.group22.gymcompanion.Model.Exercises.CardioExercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.StrengthExercise;
import se.chalmers.group22.gymcompanion.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
        return parseExerciseHelper(R.raw.strength_exercises, StrengthExercise.class);
    }

    private List<CardioExercise> parseCardioExercises(){
        return parseExerciseHelper(R.raw.cardio_exercises, CardioExercise.class);
    }

    private <T extends Exercise> List<T> parseExerciseHelper(int resourceID, Class<T> className){
        List<T> exercises = new ArrayList<>();
        String stringJSON = readFile(resourceID);
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
        String stringJSON = readFile(R.raw.routines);

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

    private String readFile(int resourceID)
    {
        InputStream resourceReader = GymCompanionContext.getContext().
                                    getResources().openRawResource(resourceID);

        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(resourceReader)))
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
