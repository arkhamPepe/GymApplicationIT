package se.chalmers.group22.gymcompanion.Model.Exercises;

import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;

import java.io.Serializable;
import java.util.List;

public class CardioExercise extends TimedExercise implements Serializable {

    public CardioExercise(String name, double difficulty, List<MUSCLE_GROUP> muscle_groups, String description, String videoguide, int timespent) {
        super(name, difficulty, muscle_groups, description, videoguide, timespent);
    }
}
