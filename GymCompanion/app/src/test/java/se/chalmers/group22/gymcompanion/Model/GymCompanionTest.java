package se.chalmers.group22.gymcompanion.Model;

import org.junit.Before;
import org.junit.Test;
import se.chalmers.group22.gymcompanion.Enums.INTENSITY;
import se.chalmers.group22.gymcompanion.Model.Exercises.CardioExercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;

import java.util.ArrayList;
import java.util.Calendar;

import static org.junit.Assert.*;

public class GymCompanionTest {

    private GymCompanion gymCompanion;
    private User user;
    private Routine r1;
    private Calendar d;

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
        d = Calendar.getInstance();
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

    @Test
    public void getRoutineTest(){
        assertEquals(0, gymCompanion.getRoutines().size());
        user.addRoutine(r1);
        assertEquals(1, gymCompanion.getRoutines().size());
    }

    @Test
    public void startRoutineTest(){
        gymCompanion.startRoutine(r1);
        assertEquals(r1, gymCompanion.getActiveRoutine());
    }

    @Test
    public void activeExerciseTest(){
        gymCompanion.startRoutine(r1);
        gymCompanion.setActiveExerciseInActiveRoutine(0);
        assertEquals("Sprinter", gymCompanion.getActiveExerciseName());
    }

    @Test
    public void getAmountOfExercisesInActiveRoutineTest(){
        gymCompanion.startRoutine(r1);
        assertEquals(1, gymCompanion.getAmountOfExercisesInActiveRoutine());
    }

    @Test
    public void getActiveExerciseTest(){
        gymCompanion.startRoutine(r1);
        gymCompanion.setActiveExerciseInActiveRoutine(0);
        Exercise expected = r1.getExercises().get(0);
        assertEquals(expected, gymCompanion.getActiveExercise());
    }

    @Test
    public void getActiveRoutineTest(){
        gymCompanion.startRoutine(r1);
        assertEquals(r1, gymCompanion.getActiveRoutine());
    }

    @Test
    public void getScheduleRoutineName(){
        user.getSchedule().addRoutine(r1, d);
        assertEquals("Routine 1", gymCompanion.getScheduledRoutineName());
    }

    @Test
    public void getYearTodayTest(){
        assertEquals(d.get(Calendar.YEAR), gymCompanion.getYearToday());
    }

    @Test
    public void getMonthTodayTest(){
        assertEquals(d.get(Calendar.MONTH), gymCompanion.getMonthToday());
    }

    @Test
    public void getDayTodayTest(){
        assertEquals(d.get(Calendar.DAY_OF_MONTH), gymCompanion.getDayToday());
    }

    @Test
    public void scheduleRoutineTest(){
        user.addRoutine(r1);
        gymCompanion.scheduleRoutine(d, "Routine 1");
        assertEquals("Routine 1", gymCompanion.getScheduledRoutineName());
    }
    
}