package se.chalmers.group22.gymcompanion.Model;

import org.junit.Before;
import org.junit.Test;
import se.chalmers.group22.gymcompanion.Enums.INTENSITY;
import se.chalmers.group22.gymcompanion.Model.Exercises.CardioExercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.StrengthExercise;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    private Parser parser;

    @Before
    public void init(){
        parser = new Parser();
    }

    @Test
    public void parseStrengthExercises() {
        List<StrengthExercise> parsedExercises = parser.parseStrengthExercises();
        StrengthExercise ex1 = parsedExercises.get(0);
        assertEquals(2, parsedExercises.size());
        assertEquals("Bench Press", ex1.getName());
        assertEquals(3, ex1.getSets());
    }

    @Test
    public void parseCardioExercises(){
        List<CardioExercise> parseExercises = parser.parseCardioExercises();
        CardioExercise ce1 = parseExercises.get(0);
        assertEquals(1, parseExercises.size());
        assertEquals("Running Boi", ce1.getName());
        assertEquals(INTENSITY.MEDIUM, ce1.getIntensity());
    }

    @Test
    public void parseRoutines(){
        List<Routine> parseRoutines = parser.parseRoutines();
        Routine r1 = parseRoutines.get(0);
        assertEquals(2, r1.getExercises().size());
    }
}