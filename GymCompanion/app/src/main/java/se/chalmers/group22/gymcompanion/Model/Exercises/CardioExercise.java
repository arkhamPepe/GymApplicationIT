package se.chalmers.group22.gymcompanion.Model.Exercises;

import lombok.Getter;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Model.Exercise;

import java.util.List;

public class CardioExercise extends TimedExercise {

    public CardioExercise(String name, double difficulty, List<MUSCLE_GROUP> muscleGroups, String description, String videoguide, int timespent) {
        super(name, difficulty, muscleGroups, description, videoguide, timespent);
    }
}
