package se.chalmers.group22.gymcompanion;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import se.chalmers.group22.gymcompanion.Model.*;
import se.chalmers.group22.gymcompanion.Model.Exercises.CardioExerciseTest;
import se.chalmers.group22.gymcompanion.Model.Exercises.StrengthExerciseTest;
import se.chalmers.group22.gymcompanion.ViewModel.StatisticsViewModelTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        CardioExerciseTest.class,
        StrengthExerciseTest.class,
        DataHandlerSearchTest.class,
        DataHandlerSortAndFilterTest.class,
        RoutineTest.class,
        StatisticsCalculatorTest.class,
        UserTest.class,
        ScheduleTest.class,
        StatisticsViewModelTest.class
})

public class JunitTestSuite {
}
