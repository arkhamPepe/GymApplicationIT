package se.chalmers.group22.gymcompanion.Model.Workout.Exercises;

import org.junit.Before;
import org.junit.Test;
import se.chalmers.group22.gymcompanion.Enums.INTENSITY;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StrengthExerciseTest {

    private StrengthExercise strengthExercise;
    private List<MUSCLE_GROUP> muscleGroups;
    private List<Integer> reps;
    private List<Double> kilograms;
    private INTENSITY intensity;

    @Before
    public void init() {
        this.muscleGroups = new ArrayList<>();
        this.reps = new ArrayList<>();
        this.kilograms = new ArrayList<>();
        this.intensity = INTENSITY.MEDIUM;
        this.strengthExercise = new StrengthExercise(
                "Exercise 1",
                2.3,
                muscleGroups,
                "A simple exercise",
                null,
                reps,
                3,
                kilograms,
                intensity
        );
    }

    @Test
    public void containsMuscleGroupTest() {
        assertFalse(strengthExercise.containsMuscleGroup(MUSCLE_GROUP.QUADS));

        muscleGroups.add(MUSCLE_GROUP.BICEPS);
        muscleGroups.add(MUSCLE_GROUP.QUADS);
        muscleGroups.add(MUSCLE_GROUP.LOWER_BACK);

        assertTrue(strengthExercise.containsMuscleGroup(MUSCLE_GROUP.QUADS));
        assertFalse(strengthExercise.containsMuscleGroup(MUSCLE_GROUP.GLUTES));
    }

    @Test
    public void isCompletedTest() {
        assertFalse(strengthExercise.isCompleted());
        strengthExercise.toggleCompletion(true);
        assertTrue(strengthExercise.isCompleted());
    }

    @Test
    public void getKilogramsTest(){
        assertEquals(0, strengthExercise.getKilograms().size());

        kilograms.add(5.0);
        kilograms.add(5.1);
        kilograms.add(17.6);

        assertEquals(3, strengthExercise.getKilograms().size());
        assertEquals(17.6, strengthExercise.getKilograms().get(2), 0.01);
    }

    @Test
    public void getIntensityTest(){
        assertEquals(INTENSITY.MEDIUM, strengthExercise.getIntensity());
    }

    @Test
    public void getSetsTest(){
        assertEquals(3, strengthExercise.getSets());
    }

    @Test
    public void getRepsTest(){
        assertEquals(0, strengthExercise.getRepetitions().size());
    }
}