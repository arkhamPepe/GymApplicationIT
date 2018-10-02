package se.chalmers.group22.gymcompanion.Model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.StrengthExercise;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertFalse;

public class StatisticsCalculatorTest {
    User user;

    private String userName;
    private String gym;
    private int age;
    private int weight;
    private boolean isBeginner;

    private List<Integer> repetitions;
    private int sets;
    private List<MUSCLE_GROUP> muscleGroup;

    private Exercise exercise;
    private List<Routine> routines;
    private Routine routine;
    private Calendar calendar;


    @Before
    public void init(){
        userName = "BOOOOOOOOOOOOOCK";
        gym = "Welcome to my mine";
        age = 12;
        weight = 2;
        isBeginner = false;

        exercise = new StrengthExercise("Lift",3.5,muscleGroup,"","",repetitions,sets);
        routine = new Routine();
        routines = new ArrayList<>();
        routines.add(routine);

        calendar = Calendar.getInstance();
        user = new User(null,routines,userName,gym,age,weight,isBeginner);
        user.addExerciseToRoutine(exercise,routines.get(0));
        user.getSchedule().addRoutine(routines.get(0),calendar);
    }

    @Test
    public void getSpecificExerciseTest(){
        Map<Calendar,Exercise> specificExercises;
        assertFalse(user.getStatCalc().getSpecificExercise(exercise).isEmpty());
    }

}