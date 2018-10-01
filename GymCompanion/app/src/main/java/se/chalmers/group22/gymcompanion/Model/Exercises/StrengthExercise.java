package se.chalmers.group22.gymcompanion.Model.Exercises;

import lombok.Getter;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;

import java.util.List;
import java.io.Serializable;

public class StrengthExercise extends Exercise implements Serializable {
    @Getter
    private int repetitions;
    @Getter
    private int sets;

    public StrengthExercise(String name, double difficulty, List<MUSCLE_GROUP> muscleGroups, String description, String videoguide, int repetitions, int sets) {
        super(name, difficulty, muscleGroups, description, videoguide);
        this.repetitions = repetitions;

    }

    // FOR TESTING
    public StrengthExercise(String name, double difficulty){
        super(name, difficulty);
    }

    // FOR TESTING
    public StrengthExercise(List<MUSCLE_GROUP> muscleGroups, double difficulty){
        super(muscleGroups, difficulty);
    }

}
