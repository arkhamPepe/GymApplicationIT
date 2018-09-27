package se.chalmers.group22.gymcompanion.Model;

import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;

import java.util.List;

public abstract class Exercise implements IHasMuscleGroup {
    private String name;
    private double difficulty;
    private List<MUSCLE_GROUP> muscleGroups;

    //Might need a Guide class later
    private String description;
    private String videoguide;

    public Exercise(String name, double difficulty,List<MUSCLE_GROUP> muscleGroups, String description, String videoguide){
        this.name = name;
        this.difficulty = difficulty;
        this.muscleGroups = muscleGroups;
        this.description = description;
        this.videoguide = videoguide;
    }

    public Exercise(){}

    public boolean containsMuscleGroup(MUSCLE_GROUP mg){
        return muscleGroups.contains(mg);
    }
}
