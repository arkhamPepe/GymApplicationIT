package se.chalmers.group22.gymcompanion.Model.Exercises;

import lombok.Getter;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Model.Exercise;

import java.util.List;

public abstract class TimedExercise extends Exercise {
    @Getter
    private int timespent;

    public TimedExercise(String name, double difficulty, List<MUSCLE_GROUP> muscleGroup, String description, String videoguide, int timespent) {
        super(name, difficulty, muscleGroup, description, videoguide);
        this.timespent = timespent;
    }
}
