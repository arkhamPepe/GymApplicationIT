package se.chalmers.group22.gymcompanion.Enums;

/***
 * Title: MUSCLE_GROUP
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 19, 2018
 *
 * Purpose: an Enum for the various muscle groups the app holds. Each exercise has one/several muscle groups it "trains".
 *
 * Used by: BeginnerFilter.java, BrowseViewModel.java, CardioExercise.java, CardioExerciseTest.java,
 *          MyRoutinesViewModel.java, Isortable.java, StrengthExercise.java, Exercise.java, UserTest.java,
 *          GymCompanion.java, GymCompanionTest.java, Routine.java, RoutineTest.java, StatisticsCalculatorTest.java,
 *          GymCompanionSortAndFilterTest.java
 * Uses: -
 */

public enum MUSCLE_GROUP {
    CHEST,
    CALVES, // SWE: Vader
    HAMSTRINGS, // SWE: Bakre lår
    QUADS, // SWE: Främre lår
    TRICEPS,
    BICEPS,
    FOREARMS,
    TRAPS, // SWE: Nacken
    LATS, // SWE: Ryggmuskel på sidan av överkroppen under armarna
    LOWER_BACK,
    UPPER_BACK,
    GLUTES, // Butt
    SHOULDERS,
    ABS, // Sixpack
    FULL_BODY // Every muscle
}
