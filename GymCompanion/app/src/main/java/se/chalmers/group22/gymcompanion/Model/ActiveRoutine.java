package se.chalmers.group22.gymcompanion.Model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ActiveRoutine {

    @Getter
    private List<Exercise> completedExercises;

    @Getter
    private List<Exercise> routineExercises;


    private static ActiveRoutine activeRoutine;
    private ActiveRoutine(){
        this.completedExercises = new ArrayList<>();
    }

    public static ActiveRoutine getInstance(){
        if(activeRoutine == null)
            activeRoutine = new ActiveRoutine();

        return activeRoutine;
    }

    public void start(Routine routine){
        this.routineExercises = routine.getExercises();
    }

    public void completeExercise(Exercise exercise){
        completedExercises.add(exercise);
    }
}
