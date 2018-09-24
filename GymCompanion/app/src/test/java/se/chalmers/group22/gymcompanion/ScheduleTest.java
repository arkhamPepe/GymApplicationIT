package se.chalmers.group22.gymcompanion;

import org.junit.Before;
import org.junit.Test;
import se.chalmers.group22.gymcompanion.Model.Day;
import se.chalmers.group22.gymcompanion.Model.Routine;
import se.chalmers.group22.gymcompanion.Model.Schedule;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ScheduleTest {

    @Test
    public void addRoutineTest() {
        Schedule s = new Schedule();
        Routine r = new Routine();
        Day d = new Day(32,5);

        s.addRoutine(r, d);

        assertEquals(r,s.getRoutine(d));

    }

    @Test
    public void removeRoutineTest() {
        Schedule s = new Schedule();
        Routine r = new Routine();
        Day d = new Day(32,5);

        s.addRoutine(r, d);

        if (s.getRoutine(d).equals(r)){
            s.removeRoutine(d);
            assertNull(s.getRoutine(d));
        }else{
            fail();
        }

    }

    @Test
    public void getRoutineTest() {
        Schedule s = new Schedule();
        Routine r = new Routine();
        Day d = new Day(32,5);

        Routine temp;

        s.addRoutine(r, d);

        temp = s.getRoutine(d);

        assertEquals(r, temp);
    }
}
