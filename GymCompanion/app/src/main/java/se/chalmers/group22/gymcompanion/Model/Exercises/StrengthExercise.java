package se.chalmers.group22.gymcompanion.Model.Exercises;

import lombok.Getter;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Enums.STRENGTH_INTENSITY;

public class StrengthExercise extends Exercise {
    @Getter
    private int repetitions;
    @Getter
    private int sets;
    @Getter
    private double kilograms;
    @Getter
    private STRENGTH_INTENSITY intensity;


    public StrengthExercise(String name, double difficulty, MUSCLE_GROUP muscle_group, String description, String videoguide, int repetitions, int sets, double kilograms, STRENGTH_INTENSITY intensity) {
        super(name, difficulty, muscle_group, description, videoguide);
        this.repetitions = repetitions;
        this.sets = sets;
        this.kilograms = kilograms;
        this.intensity = intensity;
    }
}
