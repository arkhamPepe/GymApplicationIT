package se.chalmers.group22.gymcompanion.Model.Strategies.FilterStrategy;

import se.chalmers.group22.gymcompanion.Model.ISortable;

import java.util.List;

/***
 * Title: FilterStrategy
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 19, 2018
 *
 * Purpose: A common interface for all filters so that the strategy pattern can be implemented.
 */

public interface FilterStrategy {

    <T extends ISortable> List<T> filter(List<T> toBeFiltered);
}
