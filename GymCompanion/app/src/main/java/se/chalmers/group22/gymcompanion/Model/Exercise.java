package se.chalmers.group22.gymcompanion.Model;

import lombok.Getter;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;

public abstract class Exercise {
    private String name;
    @Getter
    private double difficulty;
    @Getter
    private MUSCLE_GROUP muscle_group;

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

}
