package se.chalmers.group22.gymcompanion.Model.Strategies.FilterStrategy;

import lombok.Getter;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Model.ISortable;

import java.util.*;

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
