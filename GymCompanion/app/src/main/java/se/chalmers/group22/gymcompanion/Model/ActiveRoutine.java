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
    @Getter
    private Day day;


    public ActiveRoutine(Routine routine, Day d){
        this.completedExercises = new ArrayList<>();
        this.routineExercises = routine.getExercises();
        this.comment = "";
        this.day = d;
    }

    public void completeExercise(Exercise exercise){
        completedExercises.add(exercise);
        routineExercises.remove(exercise);
    }

    public CompletedRoutine finishRoutine(){
        return new CompletedRoutine(completedExercises,routineExercises, comment, day);
        //TODO save data
    }


    public void addComment(String comment){
           this.comment = comment;
    }
}
