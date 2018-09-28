package se.chalmers.group22.gymcompanion.Model.Exercises;

import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Model.Exercise;

import java.util.List;

public class StrengthExercise extends Exercise {
    private int repetitions;
    private int sets;

    public StrengthExercise(int repetitions, int sets){
        super();
        this.repetitions = repetitions;
        this.sets = sets;
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
