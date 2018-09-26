package se.chalmers.group22.gymcompanion.Model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Routine {

    private String description;

    @Getter
    private List<Exercise> exercises;

    public Routine(){
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise){
        exercises.add(exercise);
    }


}
