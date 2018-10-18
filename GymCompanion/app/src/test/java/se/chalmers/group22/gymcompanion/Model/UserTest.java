package se.chalmers.group22.gymcompanion.Model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.chalmers.group22.gymcompanion.Enums.INTENSITY;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Model.Exercises.CardioExercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

public class UserTest {
    private INTENSITY intensity = INTENSITY.MEDIUM;
    private List<User> friends;
    private List<Routine> routines;
    private List<Exercise> exercises;
    private Exercise exercise;
    private List<MUSCLE_GROUP> muscle_groups;
    private Routine r1;

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
        exercises = new ArrayList<>();
        muscle_groups = new ArrayList<>();

        userName = "Test User";
        gym = "My House";
        age = 15;
        weight = 420;
        isBeginner = false;

        calendar = Calendar.getInstance();
        exercise = new CardioExercise("MasterPull",3.4,muscle_groups,"","",intensity,40);
        exercises.add(exercise);
        r1 = new Routine("Master Routine", exercises);
        user = new User(friends,routines,userName,gym,age,weight,isBeginner);
    }

    @Test
    public void createRoutineTest(){
        user.createRoutine();
        assertFalse(routines.isEmpty());
    }

    @Test
    public void addExerciseToRoutineTest(){
        user.addExerciseToRoutine(exercise,user.getRoutines().get(0));
        assertFalse(user.getRoutines().get(0).getExercises().isEmpty());

    }

    @Test
    public void modifyRoutineDescriptionTest(){

        user.modifyRoutineDescription(user.getRoutines().get(0),"Wahoo!");
        assertTrue(user.getRoutines().get(0).getDescription().equals("Wahoo!"));
    }

    @Test
    public void finishRoutineTest(){
        user.finishRoutine(r1);
        assertEquals(1, user.getCompletedRoutines().size());
    }

    @Test
    public void getFinishedRoutineTest(){
        user.finishRoutine(r1);
        assertEquals(r1, user.getFinishedRoutine());
    }

    @Test
    public void getRoutinesTest(){
        assertNotNull(user.getRoutines());
        assertEquals(1, user.getRoutines().size());
    }

    @Test
    public void addRoutineToScheduleTest(){
        Calendar date = Calendar.getInstance();
        user.scheduleAddRoutine(r1, date);
        assertEquals(r1, user.getScheduleRoutineFromDay(date));
        assertEquals(r1.getName(), user.getScheduledRoutineName());
    }

    @Test
    public void getGymTest(){
        assertEquals("My House", user.getGym());
    }

    @Test
    public void getNameTest(){
        assertEquals("Test User", user.getName());
    }

    @Test
    public void getAgeTest(){
        assertEquals(15, user.getAge());
    }

    @Test
    public void isBeginnerTest(){
        assertFalse(user.isBeginner());
    }

    @Test
    public void getTodayTest(){
        Calendar date = Calendar.getInstance();
        int todayDate = date.get(Calendar.DAY_OF_MONTH);
        assertEquals(todayDate, user.getDayToday());
    }

    @Test
    public void getRoutineNameOnDateTest(){
        Calendar date = Calendar.getInstance();
        int dateYear = date.get(Calendar.YEAR);
        int dateMonth = date.get(Calendar.MONTH);
        int dateDay = date.get(Calendar.DAY_OF_MONTH);
        user.scheduleAddRoutine(r1, date);
        assertEquals(r1.getName(), user.getRoutineNameOnDate(dateYear, dateMonth, dateDay));
    }

    @Test
    public void getYearTodayTest(){
        Calendar date = Calendar.getInstance();
        int dateYear = date.get(Calendar.YEAR);
        assertEquals(dateYear, user.getYearToday());
    }

    @Test
    public void getMonthTodayTest(){
        Calendar date = Calendar.getInstance();
        int dateMonth = date.get(Calendar.MONTH);
        assertEquals(dateMonth, user.getMonthToday());
    }

    @Test
    public void removeRoutineTest(){
        int n = user.getRoutines().size();
        user.addRoutine(r1);
        user.removeRoutine(r1);
        assertEquals(n, user.getRoutines().size());
    }
}