package se.chalmers.group22.gymcompanion.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Routine {

    @Getter
    @Setter
    private String description;

    @Getter
    private List<Exercise> exercises;

    public Routine(){
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise){
        exercises.add(exercise);
    }

    public double getAverageDifficulty(){
        double sum = 0;
        for(Exercise exercise : exercises){

        }
        return sum / exercises.size();
    }
}
