package se.chalmers.group22.gymcompanion.Model.Exercises;

import lombok.AccessLevel;
import lombok.Getter;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Enums.INTENSITY;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

@Getter
public class StrengthExercise extends Exercise implements Serializable {

    @Getter(AccessLevel.NONE)
    private List<Integer> repetitions;

    private int sets;

    @Getter(AccessLevel.NONE)
    private List<Double> kilograms;

    private INTENSITY intensity;

    public StrengthExercise(String name, double difficulty, List<MUSCLE_GROUP> muscleGroups, String description, String videoguide, List<Integer> repetitions, int sets) {
        super(name, difficulty, muscleGroups, description, videoguide);
        this.repetitions = repetitions;
    }
    public StrengthExercise(String name, double difficulty, List<MUSCLE_GROUP> muscleGroups, String description, String videoguide, List<Integer> repetitions, int sets, List<Double> kilograms, INTENSITY intensity) {
        super(name, difficulty, muscleGroups, description, videoguide, intensity);
        this.repetitions = repetitions;
        this.sets = sets;
        this.kilograms = kilograms;
        this.intensity = intensity;
    }

    // FOR TESTING
    public StrengthExercise(String name, double difficulty){
        super(name, difficulty);
    }

    // FOR TESTING
    public StrengthExercise(List<MUSCLE_GROUP> muscleGroups, double difficulty){
        super(muscleGroups, difficulty);
    }


    // Defensive copy
    public List<Integer> getRepetitions() {
        return new ArrayList<>(repetitions);
    }

    // Defensive copy
    public List<Double> getKilograms() {
        return new ArrayList<>(kilograms);
    }
}
