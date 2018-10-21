package se.chalmers.group22.gymcompanion.Model.Strategies.FilterStrategy;

import se.chalmers.group22.gymcompanion.Model.ISortable;

import java.util.*;

/***
 * Title: MixedFilter
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 19, 2018
 *
 * Purpose: Adds 10 random exercises/rountines and shuffles them.
 */
public class MixedFilter implements FilterStrategy {



    private static final Random RANDOM = new Random();

    //Filters the list with a mix of routines/exercises (Completely Random)
    public <T extends ISortable> List<T> filter(List<T> oldList){
        List<T> newList = new ArrayList<>(oldList);

        while(newList.size() > 10){
            newList.remove(RANDOM.nextInt(newList.size()));
        }

        return newList;
    }
}
