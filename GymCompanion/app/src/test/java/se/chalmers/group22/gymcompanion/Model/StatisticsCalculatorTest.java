package se.chalmers.group22.gymcompanion.Model;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StatisticsCalculatorTest {
    private User user = new User(new ArrayList<User>(),new ArrayList<Routine>(), "Test", "Test Gym", 20, 75, true);
    private StatisticsCalculator statisticsCalculator = new StatisticsCalculator(user);

    @Test
    public void getSpecificExerciseTest(){

    }


}