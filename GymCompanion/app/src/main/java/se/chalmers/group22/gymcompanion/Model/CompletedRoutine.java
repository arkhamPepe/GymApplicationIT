package se.chalmers.group22.gymcompanion.Model;

import java.util.List;

public class CompletedRoutine {
    private List<Exercise> completedExercises;
    private List<Exercise> failedExercises;
    private String comment;

    public CompletedRoutine(List<Exercise> completedExercises, List<Exercise> failedExercises, String comment){
        this.completedExercises = completedExercises;
        this.failedExercises = failedExercises;
        this.comment =  comment;
    }

}
