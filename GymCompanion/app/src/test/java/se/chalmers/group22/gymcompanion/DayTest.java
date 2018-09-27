package se.chalmers.group22.gymcompanion;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import se.chalmers.group22.gymcompanion.Model.Day;

import static org.junit.Assert.*;

public class DayTest {
    Day x = new Day(1,2,3);
    Day y = new Day(1,2,3);
    Day z = new Day(1,2,3);

    @Test
    public void equalsTestAgainstNull() {
        assertFalse(x.equals(null));
    }

    @Test
    public void equalsTestIsReflexive() {
        assertTrue(x.equals(x));
    }

    @Test
    public void equalsTestIsSymmetric() {
        assertTrue(x.equals(y) && y.equals(x));
    }

    @Test
    public void equalsTestIsTransitive() {
        boolean cause1 = x.equals(y) && y.equals(z);
        assertEquals(cause1, x.equals(z));
    }

    @Test
    public void toStringTest() {
        Day day = new Day(1,2,3);
        String expected = "1-2-3";
        assertEquals(expected, day.toString());
    }
}
