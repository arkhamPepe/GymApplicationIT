package se.chalmers.group22.gymcompanion.Model;


import org.junit.Test;
import se.chalmers.group22.gymcompanion.Model.Exercises.StrengthExercise;
import se.chalmers.group22.gymcompanion.Model.Strategies.SortingStrategy.AscendingAlphabetic;
import se.chalmers.group22.gymcompanion.Model.Strategies.SortingStrategy.DescendingAlphabetic;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DataHandlerTest {

    @Test
    public void sortRoutinesAlphabeticAscTest(){
        Routine a = new Routine("a");
        Routine b = new Routine("b");
        Routine c = new Routine("c");

        List<Routine> routines = new ArrayList<>();
        routines.add(c);
        routines.add(a);
        routines.add(b);

        List<Routine> expected = new ArrayList<>();
        expected.add(a);
        expected.add(b);
        expected.add(c);

        DataHandler.getInstance().sort(routines, new AscendingAlphabetic());

        assertEquals(routines, expected);
    }

    @Test
    public void sortRoutinesAlphabeticDescTest(){
        Routine a = new Routine("a");
        Routine b = new Routine("b");
        Routine c = new Routine("c");

        List<Routine> routines = new ArrayList<>();
        routines.add(c);
        routines.add(a);
        routines.add(b);

        List<Routine> expected = new ArrayList<>();
        expected.add(c);
        expected.add(b);
        expected.add(a);

        DataHandler.getInstance().sort(routines, new DescendingAlphabetic());

        assertEquals(routines, expected);
    }

    @Test
    public void sortExercisesAlphabeticAscTest(){
        Exercise a = new StrengthExercise("a");
        Exercise b = new StrengthExercise("b");
        Exercise c = new StrengthExercise("c");

        List<Exercise> exercises = new ArrayList<>();
        exercises.add(c);
        exercises.add(a);
        exercises.add(b);

        List<Exercise> expected = new ArrayList<>();
        expected.add(a);
        expected.add(b);
        expected.add(c);

        DataHandler.getInstance().sort(exercises, new AscendingAlphabetic());

        assertEquals(exercises, expected);
    }

    @Test
    public void sortExercisesAlphabeticDescTest(){
        Exercise a = new StrengthExercise("a");
        Exercise b = new StrengthExercise("b");
        Exercise c = new StrengthExercise("c");

        List<Exercise> exercises = new ArrayList<>();
        exercises.add(c);
        exercises.add(a);
        exercises.add(b);

        List<Exercise> expected = new ArrayList<>();
        expected.add(c);
        expected.add(b);
        expected.add(a);

        DataHandler.getInstance().sort(exercises, new DescendingAlphabetic());

        assertEquals(exercises, expected);
    }
}
