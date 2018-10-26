package se.chalmers.group22.gymcompanion.Model;

import org.junit.Before;
import org.junit.Test;
import se.chalmers.group22.gymcompanion.Enums.INTENSITY;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Model.User.User;
import se.chalmers.group22.gymcompanion.Model.Workout.Exercises.CardioExercise;
import se.chalmers.group22.gymcompanion.Model.Workout.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Workout.Routine;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

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
        assertEquals("Wahoo!", user.getRoutines().get(0).getDescription());
    }

    @Test
    public void finishRoutineTest(){
        user.finishRoutine(r1);
        assertEquals(1, user.getCompletedRoutines().size());
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
        user.removeRoutine(0);
        assertEquals(n, user.getRoutines().size());
    }

    @Test
    public void getWeightTest(){
        assertEquals(420, user.getWeight());
    }

    @Test
    public void addFriendTest(){
        User f1 = new User("Friend", "Friend Gym", 15, 421, false);
        user.addFriend(f1);
        assertEquals(f1, user.getFriends().get(0));
        assertEquals(1, user.getFriends().size());
    }

    @Test
    public void removeFriendTest(){
        User f1 = new User("Friend", "Friend Gym", 15, 421, false);
        user.addFriend(f1);
        user.removeFriend(f1);
        assertEquals(0, user.getFriends().size());
    }

    @Test
    public void getFavouriteExerciseNameTest(){
        assertEquals("No Favourite", user.getFavouriteExerciseName());
        for (Exercise e : r1.getExercises()){
            e.toggleCompletion(true);
        }
        user.finishRoutine(r1);
        assertEquals("MasterPull", user.getFavouriteExerciseName());
    }

    @Test
    public void getFavouriteRoutineNameTest(){
        assertEquals("No Favourite", user.getFavouriteRoutineName());
        user.finishRoutine(r1);
        assertEquals("Master Routine", user.getFavouriteRoutineName());
    }

    @Test
    public void getBiggestCompletedRoutineTest(){
        assertEquals("No Routines Completed", user.getBiggestCompletedRoutineName());
        user.finishRoutine(r1);
        assertEquals("Master Routine", user.getBiggestCompletedRoutineName());
    }

    @Test
    public void getTotalAmountOfCompletedExercisesTest(){
        assertEquals(0, user.getTotalAmountOfCompletedExercises());
        for (Exercise e : r1.getExercises()){
            e.toggleCompletion(true);
        }
        user.finishRoutine(r1);
        assertEquals(1, user.getTotalAmountOfCompletedExercises());
    }

    @Test
    public void getTotalAmountOfCompletedRoutinesTest(){
        assertEquals(0, user.getTotalAmountOfCompletedRoutines());
        user.finishRoutine(r1);
        assertEquals(1, user.getTotalAmountOfCompletedRoutines());
    }
}