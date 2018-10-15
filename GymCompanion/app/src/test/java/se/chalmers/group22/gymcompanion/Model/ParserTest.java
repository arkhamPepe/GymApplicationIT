package se.chalmers.group22.gymcompanion.Model;

import android.util.Log;
import org.junit.Before;
import org.junit.Test;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.StrengthExercise;

import java.util.List;

import static org.junit.Assert.*;

public class ParserTest {

    private Parser parser;

    @Before
    public void init(){
        parser = new Parser();
    }

    @Test
    public void parseExercises() {
        List<StrengthExercise> parsedExercises = parser.parseExercises();
        StrengthExercise ex1 = parsedExercises.get(0);
        StrengthExercise ex2 = parsedExercises.get(1);
        assertEquals(2, parsedExercises.size());
    }
}