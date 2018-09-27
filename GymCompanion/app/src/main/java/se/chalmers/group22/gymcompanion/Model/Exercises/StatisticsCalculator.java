package se.chalmers.group22.gymcompanion.Model.Exercises;

import se.chalmers.group22.gymcompanion.Model.CompletedRoutine;
import se.chalmers.group22.gymcompanion.Model.Exercise;
import se.chalmers.group22.gymcompanion.Model.User;

import java.util.ArrayList;
import java.util.List;

public class StatisticsCalculator {
    User user;

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
