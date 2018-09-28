package se.chalmers.group22.gymcompanion.Model.Exercises;

import lombok.Getter;
import se.chalmers.group22.gymcompanion.Enums.INTENSITY;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;

public abstract class TimedExercise extends Exercise {
    @Getter
    private int timespent;

    public TimedExercise(String name, double difficulty, MUSCLE_GROUP muscle_group, String description, String videoguide, INTENSITY intensity, int timespent) {
        super(name, difficulty, muscle_group, description, videoguide,intensity );
        this.timespent = timespent;
    }
}
