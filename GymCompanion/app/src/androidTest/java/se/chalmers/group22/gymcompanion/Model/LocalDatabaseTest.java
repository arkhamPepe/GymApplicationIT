package se.chalmers.group22.gymcompanion.Model;

import static org.junit.Assert.*;

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
    public void loadTotalExercises() {
        assertNotNull(db.loadTotalExercises());
    }

    @Test
    public void loadTotalRoutines(){
        assertNotNull(db.loadTotalRoutines());
    }

    @Test
    public void loadUser(){
        assertEquals("Unknown User", db.loadUser().getName());
    }
}