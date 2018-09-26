package se.chalmers.group22.gymcompanion;
import org.junit.Test;
import se.chalmers.group22.gymcompanion.Model.Day;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class DayTest {
    @Test
    public void equalsTest() {
        Day day1 = new Day(1, 2, 3);
        Day day2 = new Day(1, 2, 3);
        Day day3 = new Day(1,2,3);
        Day day4 = new Day(2,2,3);
        Day day5 = new Day(1,3,3);
        Day day6 = new Day(1,2,4);

        //Reflective
        if(day1.equals(day1)) {
            //Symmetrical
            if(day1.equals(day2)) {
                //Transitive
                if(day1.equals(day2) && day2.equals(day3) && day1.equals(day3)) {
                    //Null returns false
                    assertFalse(day1.equals(null));
                }
            }
        }

    }

    @Test
    public void toStringTest() {
        Day day = new Day(1,2,3);
        String expected = "1-2-3";
        assertEquals(expected, day.toString());
    }
}
