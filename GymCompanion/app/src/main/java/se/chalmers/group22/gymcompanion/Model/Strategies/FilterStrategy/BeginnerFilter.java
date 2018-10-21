package se.chalmers.group22.gymcompanion.Model.Strategies.FilterStrategy;

import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Model.Strategies.ISortable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/***
 * Title: BeginnerFiler
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 19, 2018
 *
 * Purpose: Filters the easiests exercises/routines in the local storage.
 */

public class BeginnerFilter implements FilterStrategy {

    @Override
    public <T extends ISortable> List<T> filter(List<T> oldList){
        oldList.sort(Comparator.comparingDouble(ISortable::getDifficulty));
        List<T> newList = new ArrayList<>();

        for(MUSCLE_GROUP mg : MUSCLE_GROUP.values()) {
            for (T re: oldList) {
                if(re.containsMuscleGroup(mg) && !newList.contains(re)){
                    newList.add(re);
                    break;
                }
            }
        }
        return newList;
    }
}
