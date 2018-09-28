package se.chalmers.group22.gymcompanion.Model.Exercises;

import lombok.Getter;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;

import java.util.Objects;

public abstract class Exercise {
    @Getter
    final private String name;
    @Getter
    final private double difficulty;
    @Getter
    final private MUSCLE_GROUP muscle_group;

    //Might need a Guide class later
    private String description;
    private String videoguide;

    public Exercise(String name, double difficulty,MUSCLE_GROUP muscle_group, String description, String videoguide){
        this.name = name;
        this.difficulty = difficulty;
        this.muscle_group = muscle_group;
        this.description = description;
        this.videoguide = videoguide;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exercise exercise = (Exercise) o;
        return Objects.equals(name, exercise.name);
    }

}
