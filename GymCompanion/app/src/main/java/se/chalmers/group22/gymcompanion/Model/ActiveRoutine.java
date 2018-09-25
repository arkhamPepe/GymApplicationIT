package se.chalmers.group22.gymcompanion.Model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ActiveRoutine {

    @Getter
    private List<Exercise> completedExercises;

    @Getter
    private List<Exercise> routineExercises;

    @Getter
    private String comment;


    public ActiveRoutine(Routine routine){
        this.completedExercises = new ArrayList<>();
        this.routineExercises = routine.getExercises();
        this.comment = "";
    }

    public void completeExercise(Exercise exercise){
        completedExercises.add(exercise);
        routineExercises.remove(exercise);
    }

    public void finishRoutine(){
        CompletedRoutine completedRoutine = new CompletedRoutine(completedExercises,routineExercises, comment);
    }

    public void addComment(String comment){
           this.comment = comment;
    }
}
