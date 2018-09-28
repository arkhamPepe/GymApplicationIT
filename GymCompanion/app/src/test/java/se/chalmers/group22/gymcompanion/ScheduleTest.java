package se.chalmers.group22.gymcompanion;

import org.junit.Before;
import org.junit.Test;
import se.chalmers.group22.gymcompanion.Model.Day;
import se.chalmers.group22.gymcompanion.Model.Routine;
import se.chalmers.group22.gymcompanion.Model.Schedule;


import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ScheduleTest {

    @Test
    public void addRoutineTest() {
        Schedule s = new Schedule();
        Routine r = new Routine();
        Calendar d = Calendar.getInstance();

        s.addRoutine(r, d);

        assertEquals(r,s.getRoutine(d));

    }

    @Test
    public void removeRoutineTest() {
        Schedule s = new Schedule();
        Routine r = new Routine();
        Calendar d = Calendar.getInstance();

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
        Calendar d = Calendar.getInstance();

        Routine temp;

        s.addRoutine(r, d);

        temp = s.getRoutine(d);

        assertEquals(r, temp);
    }
}
