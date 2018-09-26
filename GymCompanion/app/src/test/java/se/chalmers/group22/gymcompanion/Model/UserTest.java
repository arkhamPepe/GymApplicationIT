package se.chalmers.group22.gymcompanion.Model;

import org.junit.Test;
import se.chalmers.group22.gymcompanion.Model.Exercises.StrengthExercise;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserTest {
    private User user = new User(new ArrayList<User>(),new ArrayList<Routine>(), "Test", "Test Gym", 20, 75, true);

    @Test
    public void startRoutineTest(){
        Routine routine = new Routine();
        user.startRoutine(routine);
        assertTrue(user.isRoutineActive());
    }

    @Test
    public void checkDayTest(){
        user.checkDay();


    }

    @Test
    public void endActiveRoutineTest(){
        user.endActiveRoutine();
        assertFalse(user.isRoutineActive());
    }

}