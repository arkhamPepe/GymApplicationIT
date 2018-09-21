package se.chalmers.group22.gymcompanion.Model;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void startRoutineTest(){
        User user = new User(null, null, null, 0, 0, true);
        user.startRoutine();
        assertTrue(user.isRoutineActive());
    }

    @Test
    public void getRoutineTest(){
        User user = new User(null, null, null, 0, 0, true);
    }

    @Test
    public void selectRoutineTest(){
        User user = new User(null, null, null, 0, 0, true);
    }

}