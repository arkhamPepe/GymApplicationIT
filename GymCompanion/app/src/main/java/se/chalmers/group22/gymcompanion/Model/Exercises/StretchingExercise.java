package se.chalmers.group22.gymcompanion.Model.Exercises;

import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;

public class StretchingExercise extends TimedExercise {

    public StretchingExercise(String name, double difficulty, MUSCLE_GROUP muscle_group, String description, String videoguide, int timespent) {
        super(name, difficulty, muscle_group, description, videoguide, timespent);
    }
}
