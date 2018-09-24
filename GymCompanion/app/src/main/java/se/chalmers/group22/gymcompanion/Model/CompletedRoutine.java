package se.chalmers.group22.gymcompanion.Model;

import java.util.List;

public class CompletedRoutine {
    private List<Exercise> completedExercises;
    private List<Exercise> failedExercises;

    public CompletedRoutine(List<Exercise> completedExercises, List<Exercise> failedExercises){
        this.completedExercises = completedExercises;
        this.failedExercises = failedExercises;
    }
}
