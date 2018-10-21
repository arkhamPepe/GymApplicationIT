package se.chalmers.group22.gymcompanion.Model.Strategies.SortingStrategy;

import se.chalmers.group22.gymcompanion.Model.ISortable;

import java.util.List;

/***
 * Title: SortingStrategy
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 19, 2018
 *
 * Purpose: An interface for sorting exercises and routines.
 * Used by: AscendingAlphabetic.java, DescendingAlphabetic.java,
 *          AscendingDifficulty.java, DescendingDifficulty.java, BrowseViewModel.java, GymCompanion.java
 * Uses: ISortable.java
 */
public interface SortingStrategy {

    <T extends ISortable> void sort(List<T> list);
}
