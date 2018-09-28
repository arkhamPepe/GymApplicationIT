package se.chalmers.group22.gymcompanion.Model;


import java.util.ArrayList;
import java.util.List;

public class StatisticsCalculator {
    private List<CompletedRoutine> completedRoutines;

    public StatisticsCalculator(List<CompletedRoutine> completedRoutines){
       this.completedRoutines = completedRoutines;
    }

    public List<Exercise> getSpecificExercise(Exercise specificExercise){
        List<Exercise> specificExerciseList = new ArrayList<>();
        for (CompletedRoutine cr: completedRoutines){
            for (Exercise exercise: cr.getCompletedExercises() ){
                if (specificExercise.equals(exercise)){
                    specificExerciseList.add(exercise);
                }
            }
        }
        return specificExerciseList;
    }




}
