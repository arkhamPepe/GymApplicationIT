package se.chalmers.group22.gymcompanion.Model;


import org.junit.Before;
import org.junit.Test;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.StrengthExercise;
import se.chalmers.group22.gymcompanion.Model.Strategies.FilterStrategy.BeginnerFilter;
import se.chalmers.group22.gymcompanion.Model.Strategies.FilterStrategy.RecommendedFilter;
import se.chalmers.group22.gymcompanion.Model.Strategies.SortingStrategy.AscendingAlphabetic;
import se.chalmers.group22.gymcompanion.Model.Strategies.SortingStrategy.AscendingDifficulty;
import se.chalmers.group22.gymcompanion.Model.Strategies.SortingStrategy.DescendingAlphabetic;
import se.chalmers.group22.gymcompanion.Model.Strategies.SortingStrategy.DescendingDifficulty;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

public class DataHandlerSortAndFilterTest {

    private Routine r1 = new Routine("a", 1);
    private Routine r2 = new Routine("b", 2);
    private Routine r3 = new Routine("c", 3);
    private Exercise e1 = new StrengthExercise("a",1);
    private Exercise e2 = new StrengthExercise("b", 2);
    private Exercise e3 = new StrengthExercise("c", 3);
    private List<Routine> routines;
    private List<Exercise> exercises;
    private List<Routine> muscleRoutines;
    private List<Exercise> muscleExercises;

    @Before
    public void setUp(){
        routines = new ArrayList<>();
        routines.add(r3);
        routines.add(r1);
        routines.add(r2);

        exercises = new ArrayList<>();
        exercises.add(e3);
        exercises.add(e1);
        exercises.add(e2);
    }

    @Test
    public void sortRoutinesAlphabeticAscTest(){
        List<Routine> expected = new ArrayList<>();
        expected.add(r1);
        expected.add(r2);
        expected.add(r3);

        DataHandler.getInstance().sort(routines, new AscendingAlphabetic());

        assertEquals(routines, expected);
    }

    @Test
    public void sortRoutinesAlphabeticDescTest(){
        List<Routine> expected = new ArrayList<>();
        expected.add(r3);
        expected.add(r2);
        expected.add(r1);

        DataHandler.getInstance().sort(routines, new DescendingAlphabetic());

        assertEquals(routines, expected);
    }

    @Test
    public void sortExercisesAlphabeticAscTest(){
        List<Exercise> expected = new ArrayList<>();
        expected.add(e1);
        expected.add(e2);
        expected.add(e3);

        DataHandler.getInstance().sort(exercises, new AscendingAlphabetic());

        assertEquals(exercises, expected);
    }

    @Test
    public void sortExercisesAlphabeticDescTest(){
        List<Exercise> expected = new ArrayList<>();
        expected.add(e3);
        expected.add(e2);
        expected.add(e1);

        DataHandler.getInstance().sort(exercises, new DescendingAlphabetic());

        assertEquals(exercises, expected);
    }

    @Test
    public void sortRoutinesDifficultyAscTest(){
        List<Routine> expected = new ArrayList<>();
        expected.add(r1);
        expected.add(r2);
        expected.add(r3);

        DataHandler.getInstance().sort(routines, new AscendingDifficulty());

        assertEquals(routines, expected);
    }

    @Test
    public void sortRoutinesDifficultyDescTest(){
        List<Routine> expected = new ArrayList<>();
        expected.add(r3);
        expected.add(r2);
        expected.add(r1);

        DataHandler.getInstance().sort(routines, new DescendingDifficulty());

        assertEquals(routines, expected);
    }

    @Test
    public void sortExercisesDifficultyAscTest(){
        List<Exercise> expected = new ArrayList<>();
        expected.add(e1);
        expected.add(e2);
        expected.add(e3);

        DataHandler.getInstance().sort(exercises, new AscendingDifficulty());

        assertEquals(exercises, expected);
    }

    @Test
    public void sortExercisesDifficultyDescTest(){
        List<Exercise> expected = new ArrayList<>();
        expected.add(e3);
        expected.add(e2);
        expected.add(e1);

        DataHandler.getInstance().sort(exercises, new DescendingDifficulty());

        assertEquals(exercises, expected);
    }

    @Test
    public void filterRoutinesBeginner(){
        List<MUSCLE_GROUP> muscles;
        muscleRoutines = new ArrayList<>();
        List<Routine> expected = new ArrayList<>();

        // Fills expected list and the list that is to be checked with easy exercises
        for (MUSCLE_GROUP mg : MUSCLE_GROUP.values()){
            muscles = new ArrayList<>();
            muscles.add(mg);

            Routine routine = new Routine(muscles, 1.0);
            expected.add(routine);
            muscleRoutines.add(routine);
        }

        // Fills the list to be checked with harder exercises
        for (MUSCLE_GROUP mg : MUSCLE_GROUP.values()){
            muscles = new ArrayList<>();
            muscles.add(mg);

            Routine routine = new Routine(muscles, 2.0);
            muscleRoutines.add(routine);
        }

        // Filters the list down to the easiest routine from every muscle group.
        muscleRoutines = DataHandler.getInstance().filter(muscleRoutines, new BeginnerFilter());
        assertEquals(new HashSet<>(muscleRoutines), new HashSet<>(expected));
    }

    @Test
    public void filterExercisesBeginner(){
        List<MUSCLE_GROUP> muscles;
        muscleExercises = new ArrayList<>();
        List<Exercise> expected = new ArrayList<>();

        // Fills the list to be checked with harder exercises
        for (MUSCLE_GROUP mg : MUSCLE_GROUP.values()){
            muscles = new ArrayList<>();
            muscles.add(mg);

            Exercise exercise = new StrengthExercise(muscles, 2.0);
            muscleExercises.add(exercise);
        }

        // Fills expected list and the list that is to be checked with easy exercises
        for (MUSCLE_GROUP mg : MUSCLE_GROUP.values()){
            muscles = new ArrayList<>();
            muscles.add(mg);

            Exercise exercise = new StrengthExercise(muscles, 1.0);
            expected.add(exercise);
            muscleExercises.add(exercise);
        }


        // Filters the list down to the easiest routine from every muscle group.
        muscleExercises = DataHandler.getInstance().filter(muscleExercises, new BeginnerFilter());
        assertEquals(new HashSet<>(muscleExercises), new HashSet<>(expected));
    }

    @Test
    public void filterRoutinesRecommended(){
        List<MUSCLE_GROUP> muscles;
        muscleRoutines = new ArrayList<>();

        // Fills the list with 5 routines from every Muscle Group
        for(int i = 0; i<5;i++) {
            for (MUSCLE_GROUP mg : MUSCLE_GROUP.values()) {
                muscles = new ArrayList<>();
                muscles.add(mg);

                Routine routine = new Routine(muscles, i);
                muscleRoutines.add(routine);
            }
        }
        //Filters the list
        muscleRoutines = DataHandler.getInstance().filter(muscleRoutines, new RecommendedFilter());
        assertTrue(filterRecommendedHelpMethod(muscleRoutines));
    }

    @Test
    public void filterExercisesRecommended(){
        List<MUSCLE_GROUP> muscles;
        muscleExercises = new ArrayList<>();

        // Fills the list with 5 exercises from every Muscle Group
        for(int i = 0; i<5;i++) {
            for (MUSCLE_GROUP mg : MUSCLE_GROUP.values()) {
                muscles = new ArrayList<>();
                muscles.add(mg);

                Exercise exercise = new StrengthExercise(muscles, i);
                muscleExercises.add(exercise);
            }
        }
        //Filters the list
        muscleExercises = DataHandler.getInstance().filter(muscleExercises, new RecommendedFilter());
        assertTrue(filterRecommendedHelpMethod(muscleExercises));
    }

    //Checks if the filtered list fulfills its purpose by checking if
    //the list size is 5 and all the routines/exercises contain the same Muscle Group
    private <T extends ISortable> boolean filterRecommendedHelpMethod(List<T> list){
        int count;

        if(5 == list.size()){
            for(MUSCLE_GROUP mg : MUSCLE_GROUP.values()){
                count = 0;
                for (T re: list) {
                    if (re.containsMuscleGroup(mg)) {
                        count++;
                    }
                    if(count == 5){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
