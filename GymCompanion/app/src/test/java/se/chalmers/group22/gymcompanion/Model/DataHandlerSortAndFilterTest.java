package se.chalmers.group22.gymcompanion.Model;


import org.junit.Before;
import org.junit.Test;
import se.chalmers.group22.gymcompanion.Model.Exercises.StrengthExercise;
import se.chalmers.group22.gymcompanion.Model.Strategies.SortingStrategy.AscendingAlphabetic;
import se.chalmers.group22.gymcompanion.Model.Strategies.SortingStrategy.AscendingDifficulty;
import se.chalmers.group22.gymcompanion.Model.Strategies.SortingStrategy.DescendingAlphabetic;
import se.chalmers.group22.gymcompanion.Model.Strategies.SortingStrategy.DescendingDifficulty;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DataHandlerSortAndFilterTest {

    private Routine r1, r2, r3;
    private Exercise e1, e2, e3;
    private List<Routine> routines;
    private List<Exercise> exercises;

    @Before
    public void setUp(){
        r1 = new Routine("a", 1);
        r2 = new Routine("b", 2);
        r3 = new Routine("c", 3);

        routines = new ArrayList<>();
        routines.add(r1);
        routines.add(r2);
        routines.add(r3);

        e1 = new StrengthExercise("a",1);
        e2 = new StrengthExercise("b", 2);
        e3 = new StrengthExercise("c", 3);

        exercises = new ArrayList<>();
        exercises.add(e1);
        exercises.add(e2);
        exercises.add(e3);
    }

    @Test
    public void sortRoutinesAlphabeticAscTest(){
        List<Routine> expected = new ArrayList<>();
        expected.add(r1);
        expected.add(r2);
        expected.add(r3);

        DataHandler.getInstance().sort(routines, new AscendingAlphabetic());

        assertEquals(routines, expected);
    }

    @Test
    public void sortRoutinesAlphabeticDescTest(){
        List<Routine> expected = new ArrayList<>();
        expected.add(r3);
        expected.add(r2);
        expected.add(r1);

        DataHandler.getInstance().sort(routines, new DescendingAlphabetic());

        assertEquals(routines, expected);
    }

    @Test
    public void sortExercisesAlphabeticAscTest(){
        List<Exercise> expected = new ArrayList<>();
        expected.add(e1);
        expected.add(e2);
        expected.add(e3);

        DataHandler.getInstance().sort(exercises, new AscendingAlphabetic());

        assertEquals(exercises, expected);
    }

    @Test
    public void sortExercisesAlphabeticDescTest(){
        List<Exercise> expected = new ArrayList<>();
        expected.add(e3);
        expected.add(e2);
        expected.add(e1);

        DataHandler.getInstance().sort(exercises, new DescendingAlphabetic());

        assertEquals(exercises, expected);
    }

    @Test
    public void sortRoutinesDifficultyAscTest(){
        List<Routine> expected = new ArrayList<>();
        expected.add(r1);
        expected.add(r2);
        expected.add(r3);

        DataHandler.getInstance().sort(routines, new AscendingDifficulty());

        assertEquals(routines, expected);
    }

    @Test
    public void sortRoutinesDifficultyDescTest(){
        List<Routine> expected = new ArrayList<>();
        expected.add(r3);
        expected.add(r2);
        expected.add(r1);

        DataHandler.getInstance().sort(routines, new DescendingDifficulty());

        assertEquals(routines, expected);
    }

    @Test
    public void sortExercisesDifficultyAscTest(){
        List<Exercise> expected = new ArrayList<>();
        expected.add(e1);
        expected.add(e2);
        expected.add(e3);

        DataHandler.getInstance().sort(exercises, new AscendingDifficulty());

        assertEquals(exercises, expected);
    }

    @Test
    public void sortExercisesDifficultyDescTest(){
        List<Exercise> expected = new ArrayList<>();
        expected.add(e3);
        expected.add(e2);
        expected.add(e1);

        DataHandler.getInstance().sort(exercises, new DescendingDifficulty());

        assertEquals(exercises, expected);
    }
}
