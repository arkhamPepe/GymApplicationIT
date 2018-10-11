package se.chalmers.group22.gymcompanion;

import org.junit.Before;
import org.junit.Test;
import se.chalmers.group22.gymcompanion.Model.LocalDatabase;
import se.chalmers.group22.gymcompanion.Model.User;

import static org.junit.Assert.*;

public class LocalDatabaseTest {

    private LocalDatabase localDatabase;
    private User user;

    @Before
    public void init(){
        localDatabase = LocalDatabase.getInstance();
        user  = new User("Test User", "Test Gym", 13, 12, true);
    }

    @Test
    public void loadUser() {
        localDatabase.saveUser(user);
        assertEquals(user.getAge(), localDatabase.loadUser().getAge());
    }
}