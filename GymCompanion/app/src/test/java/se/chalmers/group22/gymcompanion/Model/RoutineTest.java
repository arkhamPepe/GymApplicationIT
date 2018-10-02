package se.chalmers.group22.gymcompanion.Model;

import org.junit.Before;
import org.junit.Test;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Enums.INTENSITY;
import se.chalmers.group22.gymcompanion.Model.Exercises.CardioExercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.StrengthExercise;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RoutineTest {
    private INTENSITY intensity;
    private List<MUSCLE_GROUP> muscleGroups = new ArrayList<>();
    private List<MUSCLE_GROUP> muscleGroups2 = new ArrayList<>();
    private List<Integer> repetitions = new ArrayList<>();
    private Exercise ex1;
    private Exercise ex2;
    private Routine routine;


    @Before
    public void init(){
        muscleGroups.add(MUSCLE_GROUP.ABS);
        muscleGroups2.add(MUSCLE_GROUP.QUADS);
        ex1 = new StrengthExercise(
                "Exercise 1",
                3.2,
                muscleGroups,
                "A StrengthExercise for the abs",
                null,
                repetitions,
                3
        );

        ex2 = new CardioExercise(
                "Exercise 2",
                4.5,
                muscleGroups2,
                "A CardioExercise",
                null,
                intensity,
                20
        );
        routine = new Routine();
    }

    @Test
    public void addExerciseTest() {
        routine.addExercise(ex1);
        assertEquals(ex1, routine.getExercises().get(0));

        routine.addExercise(ex2);
        assertEquals(ex2, routine.getExercises().get(1));
    }

    @Test
    public void getAverageDifficultyTest() {
        routine.addExercise(ex1);
        assertEquals(3.2, routine.getAverageDifficulty(), 0.01);

        routine.addExercise(ex2);
        assertEquals(3.85, routine.getAverageDifficulty(), 0.05);

        routine.addExercise(ex1);
        assertEquals(3.63, routine.getAverageDifficulty(), 0.05);
    }

    @Test
    public void getDescriptionTest() {
        routine.setDescription("A Routine made for testing");
        assertEquals("A Routine made for testing", routine.getDescription());

        routine.setDescription("A new description");
        assertEquals("A new description", routine.getDescription());
    }

    @Test
    public void containsMuscleGroupTest() {
        routine = new Routine(muscleGroups, 2.1);
        assertTrue(routine.containsMuscleGroup(MUSCLE_GROUP.ABS));

        routine = new Routine(muscleGroups2, 3.2);
        assertTrue(routine.containsMuscleGroup(MUSCLE_GROUP.QUADS));
    }
}