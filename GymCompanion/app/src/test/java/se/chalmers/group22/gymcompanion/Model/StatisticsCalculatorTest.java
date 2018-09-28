package se.chalmers.group22.gymcompanion.Model;

import org.junit.Test;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.StrengthExercise;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class StatisticsCalculatorTest {
    private User user;
    private Exercise exercise1;
    private Exercise exercise2;
    private List<Exercise> exercisesList1;
    private List<Exercise> exerciseList2;
    private CompletedRoutine completedRoutine1;
    private CompletedRoutine completedRoutine2;
    private StatisticsCalculator statisticsCalculator;

    public StatisticsCalculatorTest(){
        exercise1 = new StrengthExercise("C",2, MUSCLE_GROUP.BICEPS,"","",2,2);
        exercise2 = new StrengthExercise("C",2, MUSCLE_GROUP.BICEPS,"","",3,4);
        exercisesList1 = new ArrayList<>();
        exerciseList2 = new ArrayList<>();
        exercisesList1.add(exercise1);
        exerciseList2.add(exercise2);
        completedRoutine1 = new CompletedRoutine(exercisesList1,null,"",null);
        completedRoutine2 = new CompletedRoutine(exerciseList2,null,"",null);
        List<CompletedRoutine> completedRoutineList = new ArrayList<>();
        completedRoutineList.add(completedRoutine1);
        completedRoutineList.add(completedRoutine2);
        statisticsCalculator = new StatisticsCalculator(completedRoutineList);
        user =  new User(
                new ArrayList<User>(),
                new ArrayList<Routine>(),
                "Test",
                "Test Gym", 20, 75,
                true
        );
    }


    @Test
    public void getSpecificExerciseTest(){
        Exercise specificExercise = new StrengthExercise("C",2,MUSCLE_GROUP.BICEPS,"","",4,1);
        user.addCompletedRoutine(completedRoutine1);
        user.addCompletedRoutine(completedRoutine2);
        List<Exercise> specificExerciseList = statisticsCalculator.getSpecificExercise(exercise1);
        assertEquals(2, specificExerciseList.size());
    }



}