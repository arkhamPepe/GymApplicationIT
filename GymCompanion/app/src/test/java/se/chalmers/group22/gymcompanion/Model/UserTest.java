package se.chalmers.group22.gymcompanion.Model;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void startRoutineTest(){
        User user = new User(null, null, null, 0, 0, true);
        Routine routine = new Routine();
        user.startRoutine(routine);
        assertTrue(user.isRoutineActive());
    }

    @Test
    public void checkDayTest(){
        User user = new User(null, null, null, 0, 0, true);
        /*TODO add a shcedule and test it, should be false
        user.checkDay();

    }

}