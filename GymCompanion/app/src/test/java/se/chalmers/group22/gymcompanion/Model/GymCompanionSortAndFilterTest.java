package se.chalmers.group22.gymcompanion.Model;


import org.junit.Before;
import org.junit.Test;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Model.Workout.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Workout.Exercises.StrengthExercise;
import se.chalmers.group22.gymcompanion.Model.Strategies.FilterStrategy.BeginnerFilter;
import se.chalmers.group22.gymcompanion.Model.Strategies.FilterStrategy.MixedFilter;
import se.chalmers.group22.gymcompanion.Model.Strategies.SortingStrategy.AscendingAlphabetic;
import se.chalmers.group22.gymcompanion.Model.Strategies.SortingStrategy.AscendingDifficulty;
import se.chalmers.group22.gymcompanion.Model.Strategies.SortingStrategy.DescendingAlphabetic;
import se.chalmers.group22.gymcompanion.Model.Strategies.SortingStrategy.DescendingDifficulty;
import se.chalmers.group22.gymcompanion.Model.Workout.Routine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

public class GymCompanionSortAndFilterTest {

    private GymCompanion gymCompanion = new GymCompanion();

    private Routine r1 = new Routine("a", 1);
    private Routine r2 = new Routine("b", 2);
    private Routine r3 = new Routine("c", 3);
    private Exercise e1 = new StrengthExercise("a",1);
    private Exercise e2 = new StrengthExercise("b", 2);
    private Exercise e3 = new StrengthExercise("c", 3);
    private List<Routine> routines;
    private List<Exercise> exercises;
    private List<Routine> muscleRoutines;
    private List<Exercise> muscleExercises;

    @Before
    public void setUp(){
        routines = new ArrayList<>();
        routines.add(r3);
        routines.add(r1);
        routines.add(r2);

        exercises = new ArrayList<>();
        exercises.add(e3);
        exercises.add(e1);
        exercises.add(e2);
    }

    @Test
    public void sortRoutinesAlphabeticAscTest(){
        List<Routine> expected = new ArrayList<>();
        expected.add(r1);
        expected.add(r2);
        expected.add(r3);

        gymCompanion.sort(routines, new AscendingAlphabetic());

        assertEquals(routines, expected);
    }

    @Test
    public void sortRoutinesAlphabeticDescTest(){
        List<Routine> expected = new ArrayList<>();
        expected.add(r3);
        expected.add(r2);
        expected.add(r1);

        gymCompanion.sort(routines, new DescendingAlphabetic());

        assertEquals(routines, expected);
    }

    @Test
    public void sortExercisesAlphabeticAscTest(){
        List<Exercise> expected = new ArrayList<>();
        expected.add(e1);
        expected.add(e2);
        expected.add(e3);

        gymCompanion.sort(exercises, new AscendingAlphabetic());

        assertEquals(exercises, expected);
    }

    @Test
    public void sortExercisesAlphabeticDescTest(){
        List<Exercise> expected = new ArrayList<>();
        expected.add(e3);
        expected.add(e2);
        expected.add(e1);

        gymCompanion.sort(exercises, new DescendingAlphabetic());

        assertEquals(exercises, expected);
    }

    @Test
    public void sortRoutinesDifficultyAscTest(){
        List<Routine> expected = new ArrayList<>();
        expected.add(r1);
        expected.add(r2);
        expected.add(r3);

        gymCompanion.sort(routines, new AscendingDifficulty());

        assertEquals(routines, expected);
    }

    @Test
    public void sortRoutinesDifficultyDescTest(){
        List<Routine> expected = new ArrayList<>();
        expected.add(r3);
        expected.add(r2);
        expected.add(r1);

        gymCompanion.sort(routines, new DescendingDifficulty());

        assertEquals(routines, expected);
    }

    @Test
    public void sortExercisesDifficultyAscTest(){
        List<Exercise> expected = new ArrayList<>();
        expected.add(e1);
        expected.add(e2);
        expected.add(e3);

        gymCompanion.sort(exercises, new AscendingDifficulty());

        assertEquals(exercises, expected);
    }

    @Test
    public void sortExercisesDifficultyDescTest(){
        List<Exercise> expected = new ArrayList<>();
        expected.add(e3);
        expected.add(e2);
        expected.add(e1);

        gymCompanion.sort(exercises, new DescendingDifficulty());

        assertEquals(exercises, expected);
    }

    @Test
    public void filterRoutinesBeginner(){
        List<MUSCLE_GROUP> muscles;
        muscleRoutines = new ArrayList<>();
        List<Routine> expected = new ArrayList<>();

        // Fills expected list and the list that is to be checked with easy exercises
        for (MUSCLE_GROUP mg : MUSCLE_GROUP.values()){
            muscles = new ArrayList<>();
            muscles.add(mg);

            Routine routine = new Routine(muscles, 1.0);
            expected.add(routine);
            muscleRoutines.add(routine);
        }

        // Fills the list to be checked with harder exercises
        for (MUSCLE_GROUP mg : MUSCLE_GROUP.values()){
            muscles = new ArrayList<>();
            muscles.add(mg);

            Routine routine = new Routine(muscles, 2.0);
            muscleRoutines.add(routine);
        }

        // Filters the list down to the easiest routine from every muscle group.
        muscleRoutines = gymCompanion.filter(muscleRoutines, new BeginnerFilter());
        assertEquals(new HashSet<>(muscleRoutines), new HashSet<>(expected));
    }

    @Test
    public void filterExercisesBeginner(){
        List<MUSCLE_GROUP> muscles;
        muscleExercises = new ArrayList<>();
        List<Exercise> expected = new ArrayList<>();

        // Fills the list to be checked with harder exercises
        for (MUSCLE_GROUP mg : MUSCLE_GROUP.values()){
            muscles = new ArrayList<>();
            muscles.add(mg);

            Exercise exercise = new StrengthExercise(muscles, 2.0);
            muscleExercises.add(exercise);
        }

        // Fills expected list and the list that is to be checked with easy exercises
        for (MUSCLE_GROUP mg : MUSCLE_GROUP.values()){
            muscles = new ArrayList<>();
            muscles.add(mg);

            Exercise exercise = new StrengthExercise(muscles, 1.0);
            expected.add(exercise);
            muscleExercises.add(exercise);
        }


        // Filters the list down to the easiest routine from every muscle group.
        muscleExercises = gymCompanion.filter(muscleExercises, new BeginnerFilter());
        assertEquals(new HashSet<>(muscleExercises), new HashSet<>(expected));
    }

    @Test
    public void filterRoutinesMixed(){
        muscleRoutines = new ArrayList<>();

        for(int i = 0;i<15;i++){
            Routine r = new Routine();
            muscleRoutines.add(r);
        }

        List<Routine> list = gymCompanion.filter(muscleRoutines, new MixedFilter());

        assertEquals(10,list.size());
    }

    @Test
    public void filterExercisesMixed(){
        muscleExercises = new ArrayList<>();

        for(int i = 0;i<15;i++){
            Exercise e = new StrengthExercise("a",1);
            muscleExercises.add(e);
        }

        List<Exercise> list = gymCompanion.filter(muscleExercises, new MixedFilter());

        assertEquals(10,list.size());
    }
}
