package se.chalmers.group22.gymcompanion.Model;

import org.junit.Test;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Enums.STRENGTH_INTENSITY;
import se.chalmers.group22.gymcompanion.Model.Exercises.CardioExercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.StrengthExercise;

import static org.junit.Assert.*;

public class RoutineTest {

    @Test
    public void addExerciseTest() {
        Routine routine = new Routine();
        Exercise exercise = new StrengthExercise(
            "Exercise 1",
            3.2,
            MUSCLE_GROUP.ABS,
            "A StrengthExercise for the abs",
            null,
            10,
            3,50,STRENGTH_INTENSITY.LOW
        );
        routine.addExercise(exercise);
        assertEquals(exercise, routine.getExercises().get(0));
    }

    @Test
    public void getAverageDifficultyTest() {
        Routine routine = new Routine();
        Exercise ex1 = new StrengthExercise(
            "Exercise 1",
            3.2,
            MUSCLE_GROUP.ABS,
            "A StrengthExercise for the abs",
            null,
            10,
            3, 100, STRENGTH_INTENSITY.HIGH
        );
        Exercise ex2 =  new CardioExercise(
            "Exercise 2",
                4.5,
                MUSCLE_GROUP.QUADS,
                "A CardioExercise",
                null,
                20
        );
        routine.addExercise(ex1);
        routine.addExercise(ex2);
        assertEquals(3.9, routine.getAverageDifficulty(), 0.01);
        routine.addExercise(ex2);
        assertEquals(4.1, routine.getAverageDifficulty(), 0.01);
    }

    @Test
    public void getDescriptionTest() {
        Routine routine = new Routine();
        routine.setDescription("A Routine made for testing");
        assertEquals("A Routine made for testing", routine.getDescription());
        routine.setDescription("A new description");
        assertEquals("A new description", routine.getDescription());
    }
}