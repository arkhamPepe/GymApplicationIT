package se.chalmers.group22.gymcompanion.Model.Exercises;

import lombok.Getter;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Model.Exercise;

public abstract class TimedExercise extends Exercise {
    @Getter
    private int timespent;

    public TimedExercise(String name, double difficulty, MUSCLE_GROUP muscle_group, String description, String videoguide, int timespent) {
        super(name, difficulty, muscle_group, description, videoguide);
        this.timespent = timespent;
    }
}