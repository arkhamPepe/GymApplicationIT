package se.chalmers.group22.gymcompanion.Model.Exercises;

import se.chalmers.group22.gymcompanion.Model.Exercise;

public class StrengthExercise extends Exercise {
    private int repetitions;
    private int sets;

    public StrengthExercise(int repetitions, int sets){
        super();
        this.repetitions = repetitions;
        this.sets = sets;
    }
}
