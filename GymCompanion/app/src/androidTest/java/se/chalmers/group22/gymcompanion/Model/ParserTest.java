package se.chalmers.group22.gymcompanion.Model;

import android.util.Log;
import org.junit.Before;
import org.junit.Test;
import se.chalmers.group22.gymcompanion.Model.DataStorage.Parser;
import se.chalmers.group22.gymcompanion.Model.Workout.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Workout.Routine;

import java.util.List;

import static org.junit.Assert.*;

public class ParserTest {
    private Parser parser;

    @Before
    public void init(){
        parser = new Parser();
        parser.parseJson();
    }

    @Test
    public void parseExercises(){
        List<Exercise> exercises = parser.getExercises();
        Exercise e1 = exercises.get(0);
        Log.d("ParserTest", e1.getDescription());
        assertEquals("Bench Press", e1.getName());
        assertEquals("A very stronk exercise", e1.getDescription());
    }

    @Test
    public void parseRoutines(){
        List<Routine> parseRoutines = parser.getRoutines();
        Routine r1 = parseRoutines.get(0);
        assertEquals("Big Arms Workout", r1.getName());
        assertEquals("Bench Press", r1.getExercises().get(0).getName());
    }
}