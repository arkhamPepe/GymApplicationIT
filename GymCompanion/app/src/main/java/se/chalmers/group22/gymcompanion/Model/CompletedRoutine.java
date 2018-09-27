package se.chalmers.group22.gymcompanion.Model;

import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
public class CompletedRoutine {
    @Getter
    private List<Exercise> completedExercises;
    private List<Exercise> failedExercises;
    private String comment;

    @Getter
    private Day day;

    public CompletedRoutine(List<Exercise> completedExercises, List<Exercise> failedExercises, String comment, Day day){
        this.completedExercises = completedExercises;
        this.failedExercises = failedExercises;
        this.comment =  comment;
        this.day = day;

    }

}
