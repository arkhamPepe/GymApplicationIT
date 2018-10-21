package se.chalmers.group22.gymcompanion.Model.Workout.Exercises;

import org.junit.Before;
import org.junit.Test;
import se.chalmers.group22.gymcompanion.Enums.INTENSITY;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CardioExerciseTest {
    private INTENSITY intensity;
    private CardioExercise cardioExercise;
    private List<MUSCLE_GROUP> muscleGroups;

    @Before
    public void init(){
        intensity = INTENSITY.MEDIUM;

        this.muscleGroups = new ArrayList<>();
        this.cardioExercise = new CardioExercise(
                "Cardio Exercise 1",
                1.7,
                muscleGroups,
                "Run",
                null,intensity,
                15
        );
    }

    @Test
    public void containsMuscleGroup() {
        assertFalse(cardioExercise.containsMuscleGroup(MUSCLE_GROUP.UPPER_BACK));
        muscleGroups.add(MUSCLE_GROUP.HAMSTRINGS);

        assertTrue(cardioExercise.containsMuscleGroup(MUSCLE_GROUP.HAMSTRINGS));
        assertFalse(cardioExercise.containsMuscleGroup(MUSCLE_GROUP.UPPER_BACK));
    }

    @Test
    public void isCompleted() {
        assertFalse(cardioExercise.isCompleted());
        cardioExercise.toggleCompletion(true);
        assertTrue(cardioExercise.isCompleted());
    }

    @Test
    public void getTimespentTest() {
        assertEquals(15, cardioExercise.getTimespent());
    }

    @Test
    public void getDescriptionTest(){
        assertEquals("Run", cardioExercise.getDescription());
    }
}