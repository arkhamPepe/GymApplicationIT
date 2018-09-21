package se.chalmers.group22.gymcompanion.Model;

public abstract class Exercise {
    private String name;
    private double difficulty;
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

    public Exercise(){}
}
