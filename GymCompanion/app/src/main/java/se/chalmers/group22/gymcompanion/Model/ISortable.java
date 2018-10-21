package se.chalmers.group22.gymcompanion.Model;

import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;

/***
 * Title: ISortable
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: September 27, 2018
 *
 * Purpose: Interface for defining sortable objects used in search and filtering algorithms.
 * Used by: BeginnerFilter.java, AscendingAlphabetic.java,
 *      AscendingDifficulty.java, DescendingAlphabetic.java, DescendingDifficulty.java,
 *      GymCompanion.java, GymCompanionSearchTest.java, MixedFilter.java,
 *      FilterStrategy.java, Routine.java, Exercise.java
 * Uses: MUSCLE_GROUP.java
 */

public interface ISortable {

    boolean containsMuscleGroup(MUSCLE_GROUP mg);

    String getName();

    double getDifficulty();
}
