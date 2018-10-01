package se.chalmers.group22.gymcompanion.Model;

import org.junit.Before;
import org.junit.Test;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;

import java.util.ArrayList;
import java.util.List;

public class StatisticsCalculatorTest {
    User user;

    private String userName;
    private String gym;
    private int age;
    private int weight;
    private boolean isBeginner;

    private List<Exercise> exercises;
    private List<Routine> routines;


    @Before
    public void init(){
        userName = "BOOOOOOOOOOOOOCK";
        gym = "Welcome to my mine";
        age = 12;
        weight = 2;
        isBeginner = false;

        exercises = new ArrayList<>();
        routines = new ArrayList<>();

        user = new User(null,routines,userName,gym,age,weight,isBeginner);
    }

    @Test
    public void getSpecificExerciseTest(){
    }

}