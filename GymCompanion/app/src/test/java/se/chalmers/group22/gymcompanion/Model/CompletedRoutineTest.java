package se.chalmers.group22.gymcompanion.Model;

import org.junit.Test;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

public class CompletedRoutineTest{
    private List<Exercise>  completedList = new ArrayList<>();
    private List<Exercise> failedList = new ArrayList<>();
    private String comment = "Yeehaw";
    Day d = new Day(Calendar.WEEK_OF_YEAR,Calendar.DAY_OF_WEEK);

    @Test
    public void CompletedRoutineConstructorTest(){
        CompletedRoutine completedRoutine = new CompletedRoutine(completedList,failedList,comment,d);
        assertEquals(comment,completedRoutine.getComment());
    }



}