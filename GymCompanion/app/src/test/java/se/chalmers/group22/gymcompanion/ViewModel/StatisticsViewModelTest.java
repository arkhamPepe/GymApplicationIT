package se.chalmers.group22.gymcompanion.ViewModel;

import org.junit.Before;
import org.junit.Test;
import se.chalmers.group22.gymcompanion.Model.Routine;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class StatisticsViewModelTest {
    Routine r1;
    Routine r2;
    Calendar c;
    Map<Calendar, Routine> schedule;
    StatisticsViewModel statisticsViewModel;

    @Before
    public void setUp(){
        r1 = new Routine();
        r2 = new Routine();
        c = new GregorianCalendar();
        schedule = new HashMap<>();
        statisticsViewModel = new StatisticsViewModel();

        //schedule.put(new GregorianCalendar(), r1);
        schedule.put(new GregorianCalendar(), r2);
    }

    @Test
    public void getRoutineTest(){
        //assertTrue(statisticsViewModel.getRoutine(c));
    }
}
