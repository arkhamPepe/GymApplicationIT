package se.chalmers.group22.gymcompanion.Model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CompletedRoutineTest{
    private List<Exercise>  completedList = new ArrayList<>();
    private List<Exercise> failedList = new ArrayList<>();
    private String comment = "Yeehaw";

    @Test
    public void CompletedRoutineConstructorTest(){
        CompletedRoutine completedRoutine = new CompletedRoutine(completedList,failedList,comment);
        assertEquals(comment,completedRoutine.getComment());
    }



}