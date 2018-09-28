package se.chalmers.group22.gymcompanion.Model;

import org.junit.Test;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Model.Exercises.StrengthExercise;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

public class UserTest {
    private User user = new User(new ArrayList<User>(),new ArrayList<Routine>(), "Test", "Test Gym", 20, 75, true);
    private Day d = new Day(Calendar.WEEK_OF_YEAR,Calendar.DAY_OF_WEEK);

    @Test
    public void startRoutineTest(){
        Routine routine = new Routine();
        user.startRoutine(routine,d);
        assertTrue(user.isRoutineActive());
    }

    @Test
    public void checkDayTest(){
        user.checkDay();
        assertFalse(user.isRoutineActive());

    }

    @Test
    public void endActiveRoutineTest(){
        user.endActiveRoutine();
        assertFalse(user.isRoutineActive());
    }

    @Test
    public void createRoutineTest(){
        user.createRoutine();
        assertFalse(user.getRoutines().isEmpty());
    }

    @Test
    public void addExerciseToRoutineTest(){
        Exercise bicee = new StrengthExercise("heavey", 4.2, MUSCLE_GROUP.BICEPS, "", "Tet", 4, 4);
        user.createRoutine();
        user.addExerciseToRoutine(bicee,user.getRoutines().get(0));
        assertEquals(user.getRoutines().get(0).getExercises().get(0),bicee);

    }

    @Test
    public void modifyRoutineDescriptionTest(){
        user.createRoutine();
        user.modifyRoutineDescription(user.getRoutines().get(0),"Pure yoy");
        assertEquals(user.getRoutines().get(0).getDescription(),"Pure yoy");

    }


}