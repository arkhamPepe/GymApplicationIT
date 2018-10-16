package se.chalmers.group22.gymcompanion.Model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LocalDatabaseTest {

    private LocalDatabase db;

    @Before
    public void init(){
        db = LocalDatabase.getInstance();
    }

    @Test
    public void saveUser(){
        User user = new User("TestUser", "Gymzera", 26, 75, true);
        db.saveUser(user);
        User loadedUser = db.loadUser();
        assertEquals(loadedUser.getName(), user.getName());
    }

    @Test
    public void loadTotalExercises() {
        assertEquals(3, db.loadTotalExercises().size());
    }

    @Test
    public void loadTotalRoutines() {
    }
}