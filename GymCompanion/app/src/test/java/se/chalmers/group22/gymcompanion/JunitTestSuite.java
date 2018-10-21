package se.chalmers.group22.gymcompanion;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import se.chalmers.group22.gymcompanion.Model.*;
import se.chalmers.group22.gymcompanion.Model.Workout.Exercises.CardioExerciseTest;
import se.chalmers.group22.gymcompanion.Model.Workout.Exercises.StrengthExerciseTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        CardioExerciseTest.class,
        StrengthExerciseTest.class,
        GymCompanionTest.class,
        GymCompanionSearchTest.class,
        GymCompanionSortAndFilterTest.class,
        RoutineTest.class,
        //StatisticsCalculatorTest.class,
        UserTest.class,
        ScheduleTest.class,
})

public class JunitTestSuite {
}
