package se.chalmers.group22.gymcompanion.Model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Model.Exercises.CardioExercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class UserTest {
    private List<User> friends;
    private List<Routine> routines;
    private Exercise exercise;
    private List<MUSCLE_GROUP> muscle_groups;

    private String userName;
    private String gym;
    private int age;
    private int weight;
    private boolean isBeginner;

    private Calendar calendar;
    private User user;

    @Before
    public void init(){
        friends = new ArrayList<>();
        routines = new ArrayList<>();
        routines.add(new Routine());
        muscle_groups = new ArrayList<>();

        userName = "Bock Ridemakok";
        gym = "My House";
        age = 15;
        weight = 420;
        isBeginner = false;

        calendar = Calendar.getInstance();
        exercise = new CardioExercise("MasterPull",3.4,muscle_groups,"","",40);
        user = new User(friends,routines,userName,gym,age,weight,isBeginner);
    }

    @Test
    public void startRoutineTest(){
        user.startRoutine(user.getRoutines().get(0));
        Assert.assertTrue(user.isRoutineActive());
    }

    @Test
    public void checkDayTest(){
        user.checkDay();
        Assert.assertFalse(user.isRoutineActive());


    }

    @Test
    public void endActiveRoutineTest(){
        user.endActiveRoutine();
        Assert.assertEquals(null,user.getActiveRoutine());
    }

    @Test
    public void createRoutineTest(){
        user.createRoutine();
        Assert.assertFalse(routines.isEmpty());
    }

    @Test
    public void addExerciseToRoutineTest(){
        user.addExerciseToRoutine(exercise,user.getRoutines().get(0));
        Assert.assertFalse(user.getRoutines().get(0).getExercises().isEmpty());

    }

    @Test
    public void modifyRoutineDescriptionTest(){

        user.modifyRoutineDescription(user.getRoutines().get(0),"Wahoo!");
        Assert.assertTrue(user.getRoutines().get(0).getDescription().equals("Wahoo!"));
    }


}