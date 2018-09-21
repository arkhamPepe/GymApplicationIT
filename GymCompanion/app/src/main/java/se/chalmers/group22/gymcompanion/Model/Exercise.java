package se.chalmers.group22.gymcompanion.Model;

public abstract class Exercise {
    private String name;
    private int repetitions;
    private int sets;
    private double difficulty;


    //Might need a Guide class later
    private String description;
    private String videoguide;

    public Exercise(String name, int repetitions, int sets, double difficulty, String description, String videoguide){
        this.name = name;
        this.repetitions = repetitions;
        this.sets = sets;
        this.difficulty = difficulty;
        this.description = description;
        this.videoguide = videoguide;
    }
}
