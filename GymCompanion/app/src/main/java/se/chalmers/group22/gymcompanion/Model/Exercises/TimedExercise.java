package se.chalmers.group22.gymcompanion.Model.Exercises;

import lombok.Getter;
import se.chalmers.group22.gymcompanion.Enums.INTENSITY;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;


import java.io.Serializable;
import java.util.List;

public abstract class TimedExercise extends Exercise implements Serializable{
    @Getter
    private int timespent;


    public TimedExercise(String name, double difficulty, List<MUSCLE_GROUP> muscleGroups, String description, String videoguide, int timespent) {
        super(name, difficulty, muscleGroups, description, videoguide);
    }

    public TimedExercise(String name, double difficulty, List<MUSCLE_GROUP> muscleGroups, String description, String videoguide, INTENSITY intensity, int timespent) {
        super(name, difficulty, muscleGroups, description, videoguide,intensity);
        this.timespent = timespent;
    }
}
