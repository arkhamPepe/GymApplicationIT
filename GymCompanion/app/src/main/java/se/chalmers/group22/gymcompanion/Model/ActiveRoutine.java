package se.chalmers.group22.gymcompanion.Model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ActiveRoutine {

    @Getter
    private List<Exercise> completedExercises;

    @Getter
    private List<Exercise> routineExercises;



    public ActiveRoutine(){
        this.completedExercises = new ArrayList<>();
    }


    public void start(Routine routine){
        this.routineExercises = routine.getExercises();
    }

    public void completeExercise(Exercise exercise){
        completedExercises.add(exercise);
        routineExercises.remove(exercise);
    }

    public void finishRoutine(){
        CompletedRoutine completedRoutine = new CompletedRoutine(completedExercises,routineExercises);
    }

    public void addComment(String comment){
        
    }
}
