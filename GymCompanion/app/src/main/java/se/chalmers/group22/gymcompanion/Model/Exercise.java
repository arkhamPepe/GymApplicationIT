package se.chalmers.group22.gymcompanion.Model;

import lombok.Getter;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;



import java.util.List;

@Getter
public abstract class Exercise implements ISortable {


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

    //For testing
    public Exercise(String name, double difficulty){
        this.name = name;
        this.difficulty = difficulty;
    }

    //FOR TESTING
    public Exercise(List<MUSCLE_GROUP> muscleGroups, double difficulty){
        this.muscleGroups = muscleGroups;
        this.difficulty = difficulty;
    }

    public Exercise(){}

    public boolean containsMuscleGroup(MUSCLE_GROUP mg){
        return muscleGroups.contains(mg);
    }

}
