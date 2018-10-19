package se.chalmers.group22.gymcompanion.Model;

import org.junit.Before;
import org.junit.Test;
import se.chalmers.group22.gymcompanion.Enums.INTENSITY;
import se.chalmers.group22.gymcompanion.Model.Exercises.CardioExercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

public class GymCompanionTest {

    private GymCompanion gymCompanion;
    private User user;
    private Routine r1;

    @Before
    public void init(){
        gymCompanion = new GymCompanion();
        user  = new User("Gym User", "The Gym", 1, 2, false);
        gymCompanion.setUser(user);
        r1 = new Routine("Routine 1", new ArrayList<>());
        CardioExercise ce = new CardioExercise(
                "Sprinter",
                6.7,
                new ArrayList<>(),
                "Jogging for fun",
                "",
                INTENSITY.LOW,
                30
        );
        r1.addExercise(ce);
    }

    @Test
    public void getFinishedRoutineTest(){
        assertNull(gymCompanion.getFinishedRoutine());
    }

    @Test
    public void createRoutineTest(){
        assertEquals(0, gymCompanion.getRoutines().size());
        gymCompanion.createRoutine();
        assertEquals(1,gymCompanion.getRoutines().size());
    }

    @Test
    public void getRoutineDifficulty(){
        assertEquals(6.7, gymCompanion.getRoutineDifficulty(r1), 0.01);
    }

    @Test
    public void getTotalAmountOfCompletedRoutines(){
        assertEquals(0, gymCompanion.getTotalAmountOfCompletedRoutines());
        user.finishRoutine(r1);
        assertEquals(1, gymCompanion.getTotalAmountOfCompletedRoutines());
    }

    @Test
    public void getTotalAmountOfCompletedExercises(){
        assertEquals(0, gymCompanion.getTotalAmountOfCompletedExercises());
        user.finishRoutine(r1);
        assertEquals(1, gymCompanion.getTotalAmountOfCompletedExercises());
    }
}