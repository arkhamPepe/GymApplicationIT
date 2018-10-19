package se.chalmers.group22.gymcompanion.Model.Exercises;

import lombok.AccessLevel;
import lombok.Getter;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Enums.INTENSITY;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/***
        * Title: StrengthExercise
        *
        * @author Alexander Bergsten
        * @author Marcus Svensson
        * @author Erik Bock
        * @author Augustas Eidikis
        * @author Daniel Olsson
        *
        * Created: October 19, 2018
        *
        * Purpose: a subclass that contains more precise attributes and methods concerning etrenght exercises
        */

@Getter
public class StrengthExercise extends Exercise implements Serializable {

    @Getter(AccessLevel.NONE)
    private List<Integer> repetitions;

    private int sets;

    @Getter(AccessLevel.NONE)
    private List<Double> kilograms;

    public StrengthExercise(String name, double difficulty, List<MUSCLE_GROUP> muscleGroups, String description, String videoguide, List<Integer> repetitions, int sets) {
        super(name, difficulty, muscleGroups, description, videoguide);
        this.repetitions = repetitions;
    }
    public StrengthExercise(String name, double difficulty, List<MUSCLE_GROUP> muscleGroups, String description, String videoguide, List<Integer> repetitions, int sets, List<Double> kilograms, INTENSITY intensity) {
        super(name, difficulty, muscleGroups, description, videoguide, intensity);
        this.repetitions = repetitions;
        this.sets = sets;
        this.kilograms = kilograms;
    }

    // FOR TESTING
    public StrengthExercise(String name, int sets, List<Integer> reps, List<Double> kilograms){
        super(name);
        this.sets = sets;
        this.repetitions = reps;
        this.kilograms = kilograms;
    }

    // FOR TESTING
    public StrengthExercise(String name, double difficulty) {
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
