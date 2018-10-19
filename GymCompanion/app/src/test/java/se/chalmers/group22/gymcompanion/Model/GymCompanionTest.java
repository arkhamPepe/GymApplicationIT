package se.chalmers.group22.gymcompanion.Model;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import se.chalmers.group22.gymcompanion.Enums.INTENSITY;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Model.Exercises.CardioExercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Strategies.FilterStrategy.BeginnerFilter;
import se.chalmers.group22.gymcompanion.Model.Strategies.SortingStrategy.AscendingAlphabetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

public class GymCompanionTest {

    private GymCompanion gymCompanion;
    private User user;
    private Routine r1;
    private Routine scheduledRoutine;
    private CardioExercise ce;
    private List<MUSCLE_GROUP> muscleGroups;
    private Calendar d;

    @Before
    public void init(){
        gymCompanion = new GymCompanion();
        user  = new User("Gym User", "The Gym", 1, 2, false);
        gymCompanion.setUser(user);
        r1 = new Routine("Routine 1", new ArrayList<>());
        muscleGroups = new ArrayList<>();
        muscleGroups.add(MUSCLE_GROUP.FULL_BODY);
        ce = new CardioExercise(
                "Sprinter",
                4.1,
                muscleGroups,
                "Jogging for fun",
                "",
                INTENSITY.LOW,
                30
        );
        r1.addExercise(ce);
        user.addRoutine(r1);
        d = Calendar.getInstance();
        gymCompanion.scheduleRoutine(d,r1.getName());
        scheduledRoutine = gymCompanion.getRoutineFromDay(d);
    }

    @Test
    public void getFinishedRoutineTest(){
        assertNull(gymCompanion.getFinishedRoutine());
    }

    @Test
    public void createRoutineTest(){
        assertEquals(1, gymCompanion.getUserRoutines().size());
        gymCompanion.createRoutine();
        assertEquals(2,gymCompanion.getUserRoutines().size());
    }

    @Test
    public void getRoutineDifficulty(){
        assertEquals(4.1, gymCompanion.getRoutineDifficulty(r1), 0.01);
    }

    @Test
    public void getTotalAmountOfCompletedRoutines(){
        assertEquals(0, gymCompanion.getTotalAmountOfCompletedRoutines());
        user.finishRoutine(r1);
        assertEquals(1, gymCompanion.getTotalAmountOfCompletedRoutines());
    }

    @Test
    public void getTotalAmountOfCompletedExercises(){
        assertEquals(0, gymCompanion.getTotalAmountOfCompletedExercises());
        user.finishRoutine(r1);
        assertEquals(1, gymCompanion.getTotalAmountOfCompletedExercises());
    }

    @Test
    public void getRoutineTest(){
        assertEquals(1, gymCompanion.getUserRoutines().size());
        user.addRoutine(r1);
        assertEquals(2, gymCompanion.getUserRoutines().size());
    }

    @Test
    public void startRoutineTest(){
        gymCompanion.startRoutine();
        assertEquals(scheduledRoutine, gymCompanion.getActiveRoutine());
    }

    @Test
    public void activeExerciseTest(){
        gymCompanion.startRoutine();
        gymCompanion.setActiveExerciseInActiveRoutine(0);
        assertEquals("Sprinter", gymCompanion.getActiveExerciseName());
    }

    @Test
    public void getAmountOfExercisesInActiveRoutineTest(){
        gymCompanion.startRoutine();
        assertEquals(1, gymCompanion.getAmountOfExercisesInActiveRoutine());
    }

    @Test
    public void getActiveExerciseTest(){
        gymCompanion.startRoutine();
        gymCompanion.setActiveExerciseInActiveRoutine(0);
        Exercise expected = r1.getExercises().get(0);
        assertEquals(expected, gymCompanion.getActiveExercise());
    }

    @Test
    public void getActiveRoutineTest(){
        gymCompanion.startRoutine();
        assertEquals(scheduledRoutine, gymCompanion.getActiveRoutine());
    }

    @Test
    public void getScheduleRoutineName(){
        user.getSchedule().addRoutine(r1, d);
        assertEquals("Routine 1", gymCompanion.getScheduledRoutineName());
    }

    @Test
    public void getYearTodayTest(){
        assertEquals(d.get(Calendar.YEAR), gymCompanion.getYearToday());
    }

    @Test
    public void getMonthTodayTest(){
        assertEquals(d.get(Calendar.MONTH), gymCompanion.getMonthToday());
    }

    @Test
    public void getDayTodayTest(){
        assertEquals(d.get(Calendar.DAY_OF_MONTH), gymCompanion.getDayToday());
    }

    @Test
    public void scheduleRoutineTest(){
        user.addRoutine(r1);
        gymCompanion.scheduleRoutine(d, "Routine 1");
        assertEquals("Routine 1", gymCompanion.getScheduledRoutineName());
    }

    @Test
    public void filterMuscleGroupsTest(){
        List<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(ce);

        List<MUSCLE_GROUP> muscleGroupList = new ArrayList<>();
        muscleGroupList.add(MUSCLE_GROUP.FULL_BODY);

        List<Exercise> filteredList = gymCompanion.filter(exerciseList, muscleGroupList);
        assertEquals(1, filteredList.size());
    }

    @Test
    public void searchRoutineTest(){
        List<Routine> totalRoutines = new ArrayList<>();
        totalRoutines.add(r1);

        List<Exercise> exercises = new ArrayList<>();
        exercises.add(ce);

        Routine r2 = new Routine("Routine 2", exercises);
        totalRoutines.add(r2);
        gymCompanion.setRoutineList(totalRoutines);
        List<Routine> routineSearch = gymCompanion.searchRoutine("Routine 2");
        assertEquals(r2, routineSearch.get(0));
    }

    @Test
    public void searchExerciseTest(){
        List<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(ce);
        gymCompanion.setExerciseList(exerciseList);
        List<Exercise> searchExercise = gymCompanion.searchExercise("Sprinter");
        assertEquals(ce, searchExercise.get(0));
    }

    @Test
    public void sortTest(){
        Routine r2 = new Routine("A Routine 2", new ArrayList<>());
        List<Routine> routines = new ArrayList<>();
        routines.add(r1);
        routines.add(r2);

        gymCompanion.sort(routines, new AscendingAlphabetic());
        assertEquals(r2, routines.get(0));
    }

}