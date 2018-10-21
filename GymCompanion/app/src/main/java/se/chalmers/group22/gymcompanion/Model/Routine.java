package se.chalmers.group22.gymcompanion.Model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/***
 * Title: Routine
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: September 21, 2018
 *
 * Purpose: Class for handling routine data.
 */

@Getter
@Setter
public class Routine implements ISortable, Serializable {

    private String description;
    private String name;
    private double difficulty;
    private String comment;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private List<MUSCLE_GROUP> muscleGroups;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private List<Exercise> exercises = new ArrayList<>();

    public Routine(String name, double difficulty){
        this(name);
        this.difficulty = difficulty;
    }

    // FOR TESTING
    public Routine(List<MUSCLE_GROUP> muscleGroups, double difficulty){
        this.muscleGroups = muscleGroups;
        this.difficulty = difficulty;
    }

    public Routine(String name){
        this();
        this.name = name;
    }

    public Routine(){
        this.exercises = new ArrayList<>();
        this.description = "";
        this.name = "New Routine";
        this.comment = "";
    }

    public Routine(String name, List<Exercise> exercises){
        this.exercises = exercises;
        this.name = name;
        this.description = "";
        this.comment = "";
        this.muscleGroups = new ArrayList<>();
        initMuscleGroupList();
        initDifficulty();
    }

    public Routine(Routine routine){
        this.exercises = routine.getExercisesCopy();
        this.name = routine.getName();
        this.description = routine.getDescription();
        this.comment = routine.getComment();
        this.muscleGroups = new ArrayList<>();
        initMuscleGroupList();
        initDifficulty();
    }

    private void initMuscleGroupList(){
        for(Exercise e : this.exercises){
            for(MUSCLE_GROUP mg : e.getMuscleGroups()){
                if(!muscleGroups.contains(mg)){
                    muscleGroups.add(mg);
                }
            }
        }
    }

    private void initDifficulty(){
        double sum = 0;
        for(Exercise e : exercises){
            sum += e.getDifficulty();
        }
        difficulty = sum / exercises.size();
        difficulty = (double) Math.round(difficulty * 10) / 10;
    }

    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }

    public void removeExercise(Exercise exercise){
        exercises.remove(exercise);
    }

    // Defensive copy
    public List<MUSCLE_GROUP> getMuscleGroups() {
        return new ArrayList<>(muscleGroups);
    }

    // Defensive copy
    public List<Exercise> getExercises() {

        return new ArrayList<>(exercises);
    }

    public List<Exercise> getExercisesCopy() {
        List<Exercise> eList = new ArrayList<>();

        for (Exercise e : exercises) {
            eList.add(e.clone());
        }

        return eList;
    }

    public void setCompletionOfExerciseWithIndex(int index, boolean completed){
        exercises.get(index).toggleCompletion(completed);
    }

    public boolean containsMuscleGroup(MUSCLE_GROUP mg){
        return muscleGroups.contains(mg);
    }

    public double getAverageDifficulty(){
        double sum = 0;
        for(Exercise exercise : exercises){
            sum += exercise.getDifficulty();
        }
        double average = sum / exercises.size();
        return (double) Math.round(average * 10) / 10;
    }

    public int getCompletedExercises(){
        int sum = 0;
        for(Exercise ex : exercises){
            if(ex.isCompleted()){
                sum++;
            }
        }
        return sum;
    }
}
