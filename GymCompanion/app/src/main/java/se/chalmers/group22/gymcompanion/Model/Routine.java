package se.chalmers.group22.gymcompanion.Model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Getter
public class Routine {

    private String description;
    private String name;
    private double difficulty;

    private List<Exercise> exercises;

    public Routine(){
        this.exercises = new ArrayList<>();
    }


}
