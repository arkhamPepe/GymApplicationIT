package se.chalmers.group22.gymcompanion.Model.Workout.Exercises;


import lombok.Getter;
import se.chalmers.group22.gymcompanion.Enums.INTENSITY;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;

import java.io.Serializable;
import java.util.List;

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
 * Purpose: (subclass to Exercise) Contains more precise attributes and methods concerning cardio exercises
 * Used by: GymCompanionTest.java, CardioExerciseTest.java, RoutineTest.java,
 *      UserTest.java, CardioExercise.java, Parser.java, MyRoutinesViewModel.java,
 *      GymCompanion.java
 * Uses: Exercise.java, INTENSITY.java
 */


public class CardioExercise extends Exercise implements Serializable {

    @Getter
    private int timespent;


    public CardioExercise(String name, double difficulty, List<MUSCLE_GROUP> muscleGroups, String description, String videoguide, INTENSITY intensity, int timespent) {
        super(name, difficulty, muscleGroups, description, videoguide, intensity);
        this.timespent = timespent;
    }


    public CardioExercise(CardioExercise exercise){
        super(exercise);
        this.timespent = exercise.getTimespent();
    }

    public CardioExercise clone() {
        return new CardioExercise(this);
    }

    public double calculateScore() {
        if (getIntensity() == INTENSITY.LOW) {
            return timespent * 0.25;
        } else if (getIntensity() == INTENSITY.MEDIUM) {
            return timespent * 0.5;
        } else {
            return timespent * 0.75;
        }
    }
}
