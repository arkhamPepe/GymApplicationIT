package se.chalmers.group22.gymcompanion.Model;

import org.junit.Test;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Enums.INTENSITY;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.StrengthExercise;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class StatisticsCalculatorTest {
    private Schedule schedule;
    private Exercise exercise1;
    private Exercise exercise2;
    private List<Exercise> exercisesList1;
    private List<Exercise> exerciseList2;
    private Routine completedRoutine1;
    private Routine completedRoutine2;
    private StatisticsCalculator statisticsCalculator;

    public StatisticsCalculatorTest(){
        this.schedule = new Schedule();

        exercise1 = new StrengthExercise("C",2, MUSCLE_GROUP.BICEPS,"","",2,2,4, INTENSITY.HIGH);
        exercise2 = new StrengthExercise("C",2, MUSCLE_GROUP.BICEPS,"","",3,4,4, INTENSITY.MEDIUM);

        exercisesList1 = new ArrayList<>();
        exercisesList1.add(exercise1);

        exerciseList2 = new ArrayList<>();
        exerciseList2.add(exercise2);

        completedRoutine1 = new Routine("Routine 1", exercisesList1);
        completedRoutine2 = new Routine("Routine 2", exerciseList2);

        List<Routine> completedRoutineList = new ArrayList<>();
        completedRoutineList.add(completedRoutine1);
        completedRoutineList.add(completedRoutine2);

        schedule.addRoutine(completedRoutine1, Calendar.getInstance());

        Calendar anotherDay = Calendar.getInstance();
        anotherDay.set(Calendar.MONTH, 5);
        schedule.addRoutine(completedRoutine2, anotherDay);

        statisticsCalculator = new StatisticsCalculator(schedule);
    }


    @Test
    public void getSpecificExerciseTest(){
        Map<Calendar, Exercise> specificExerciseList = statisticsCalculator.getSpecificExercise(exercise1);
        assertEquals(2, specificExerciseList.size());
    }




}