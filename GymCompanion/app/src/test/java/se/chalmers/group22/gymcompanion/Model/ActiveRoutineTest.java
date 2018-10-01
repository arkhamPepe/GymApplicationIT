package se.chalmers.group22.gymcompanion.Model;

import org.junit.Test;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.StrengthExercise;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ActiveRoutineTest {


    private Routine routine = new Routine();
    private Day d = new Day(Calendar.WEEK_OF_YEAR,Calendar.DAY_OF_WEEK);
    private ActiveRoutine activeRoutine = new ActiveRoutine(routine,d);

    @Test
    public void completeExerciseTest() {
        List<MUSCLE_GROUP> muscleGroups = new ArrayList<>();
        muscleGroups.add(MUSCLE_GROUP.CHEST);
        Exercise se = new StrengthExercise(
                "Strength Exercise Deluxe",
                3.2,
                muscleGroups,
                "A StrengthExercise for the chest",
                "http://youtube.com",
                10,
                3
        );
        routine.getExercises().add(se);
        activeRoutine.completeExercise(se);
        assertEquals(se, activeRoutine.getCompletedExercises().get(0));
    }

    @Test
    public void addCommentTest(){
        String comm = "Test comment";
        activeRoutine.addComment(comm);
        assertEquals(comm, activeRoutine.getComment());
    }

    @Test
    public void finishRoutineTest(){
        CompletedRoutine completedRoutine;
        completedRoutine = activeRoutine.finishRoutine();
        assertEquals(completedRoutine.getDay(),activeRoutine.getDay());
        //TODO finish the test
    }
}