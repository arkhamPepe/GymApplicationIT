package se.chalmers.group22.gymcompanion.Model;

import org.junit.Test;
import se.chalmers.group22.gymcompanion.Model.Exercises.CardioExercise;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class UserTest {
    private List<User> friends = new ArrayList<>();
    private List<Routine> routines = new ArrayList<>();
    private String userName = "Bock Ridenmakkok";
    private String gym = "My House";
    private int age = 15;
    private int weight = 69;
    private boolean isBeginner = false;

    private User user = new User(friends,routines,userName,gym,age,weight,isBeginner);

    @Test
    public void startRoutineTest(){

    }

    @Test
    public void checkDayTest(){


    }

    @Test
    public void endActiveRoutineTest(){

    }

    @Test
    public void createRoutineTest(){

    }

    @Test
    public void addExerciseToRoutineTest(){


    }

    @Test
    public void modifyRoutineDescriptionTest(){

    }


}