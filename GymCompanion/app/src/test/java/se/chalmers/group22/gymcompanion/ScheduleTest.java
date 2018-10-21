package se.chalmers.group22.gymcompanion;

import org.junit.Before;
import org.junit.Test;
import se.chalmers.group22.gymcompanion.Model.Workout.Routine;
import se.chalmers.group22.gymcompanion.Model.Schedule.Schedule;


import java.util.ArrayList;
import java.util.Calendar;

import static org.junit.Assert.*;

public class ScheduleTest {

    private Schedule s;
    private Routine r;
    private Calendar d;

    @Before
    public void init(){
        s = new Schedule();
        r = new Routine("Routine S", new ArrayList<>());
        d = Calendar.getInstance();
    }

    @Test
    public void addRoutineTest() {

        s.addRoutine(r, d);

        assertEquals(r,s.getRoutineFromDay(d));

    }

    @Test
    public void removeRoutineTest() {
        s.addRoutine(r, d);

        if (s.getRoutineFromDay(d).equals(r)){
            s.removeRoutine(d);
            assertNull(s.getRoutineFromDay(d));
        }else{
            fail();
        }

    }

    @Test
    public void getRoutineTest() {
        Routine temp;
        s.addRoutine(r, d);
        temp = s.getRoutineFromDay(d);

        assertEquals(r, temp);
    }

    @Test
    public void dateHasRoutineTest(){
        assertFalse(s.dateHasRoutine(d));

        s.addRoutine(r, d);
        assertTrue(s.dateHasRoutine(d));
    }

    @Test
    public void getScheduleTest(){
        assertEquals(0, s.getSchedule().size());
        s.addRoutine(r, d);
        assertEquals(1, s.getSchedule().size());
    }

    @Test
    public void getDateTextTest(){
        assertEquals("2018-10-19", s.getDateText(2018, 9, 19));
    }

    @Test
    public void getRoutineNameFromDateTest(){
        assertEquals("No Scheduled Routine", s.getRoutineNameFromDate(d));
        s.addRoutine(r, d);
        assertEquals("Routine S", s.getRoutineNameFromDate(d));
    }

    @Test
    public void getScheduleKeySetTest(){
        assertEquals(0, s.getScheduleKeySet().size());
        s.addRoutine(r, d);
        assertEquals(1, s.getScheduleKeySet().size());
        assertTrue(s.getScheduleKeySet().contains(d));
    }

    @Test
    public void getDayOfYearTodayTest(){
        assertEquals(d.get(Calendar.DAY_OF_YEAR), s.getDayOfYearToday());
    }

    @Test
    public void getTextNoRoutineScheduledTest(){
        assertEquals("No Scheduled Routine", s.getTextNoRoutineScheduled());
    }
}
