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
    public void loadTotalExercises() {
        assertNotNull(db.loadTotalExercises());
    }

    @Test
    public void loadTotalRoutines(){
        assertNotNull(db.loadTotalRoutines());
    }

}