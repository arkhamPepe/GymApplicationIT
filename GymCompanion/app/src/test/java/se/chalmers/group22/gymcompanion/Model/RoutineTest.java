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
    private List<MUSCLE_GROUP> muscleGroups = new ArrayList<>();
    private List<MUSCLE_GROUP> muscleGroups2 = new ArrayList<>();
    private List<Integer> repetitions = new ArrayList<>();
    private Exercise exercise = new StrengthExercise(
            "Exercise 1",
            3.2,
            muscleGroups,
            "A StrengthExercise for the abs",
            null,
            repetitions,
            3
    );
    private Exercise ex2 =  new CardioExercise(
            "Exercise 2",
            4.5,
            muscleGroups2,
            "A CardioExercise",
            null,
            20
    );



    @Before
    public void init(){
        muscleGroups.add(MUSCLE_GROUP.ABS);
        muscleGroups2.add(MUSCLE_GROUP.QUADS);
    }

    @Test
    public void addExerciseTest() {
        Routine routine = new Routine();
        routine.addExercise(exercise);
        assertEquals(exercise, routine.getExercises().get(0));
    }

    @Test
    public void getAverageDifficultyTest() {

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