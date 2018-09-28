package se.chalmers.group22.gymcompanion.Model;


import java.util.ArrayList;
import java.util.List;

public class StatisticsCalculator {
    private User user;

    public StatisticsCalculator(User user){
       this.user = user;
    }

    public List<Exercise> getSpecificExercise(Exercise specificExercise){
        List<Exercise> specificExerciseList = new ArrayList<>();
        for (CompletedRoutine completedRoutine: user.getCompletedRoutines()){
            for (Exercise exercise: completedRoutine.getCompletedExercises() ){
                if (specificExercise.equals(exercise)){
                    specificExerciseList.add(exercise);
                }
            }
        }
        return specificExerciseList;
    }
}
