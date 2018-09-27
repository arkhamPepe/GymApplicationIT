package se.chalmers.group22.gymcompanion.Model;

import org.junit.Test;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Model.Exercises.StrengthExercise;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class ActiveRoutineTest {

    private ActiveRoutine activeRoutine;
    private Routine routine = new Routine();
    Day d = new Day(Calendar.WEEK_OF_YEAR,Calendar.DAY_OF_WEEK);

    @Test
    public void completeExerciseTest() {
        Exercise se = new StrengthExercise(
                "Strength Exercise Deluxe",
                3.2,
                MUSCLE_GROUP.CHEST,
                "A StrengthExercise for the chest",
                "http://youtube.com",
                10,
                3
        );
        routine.getExercises().add(se);
        activeRoutine = new ActiveRoutine(routine,d);
        activeRoutine.completeExercise(se);
        assertEquals(se, activeRoutine.getCompletedExercises().get(0));
    }

    @Test
    public void addCommentTest(){
        activeRoutine = new ActiveRoutine(routine,d);
        String comm = "Test comment";
        activeRoutine.addComment(comm);
        assertEquals(comm, activeRoutine.getComment());
    }

    @Test
    public void finishRoutineTest(){
        //TODO finish the test
    }
}