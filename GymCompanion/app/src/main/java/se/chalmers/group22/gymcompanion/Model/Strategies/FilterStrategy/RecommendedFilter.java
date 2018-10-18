package se.chalmers.group22.gymcompanion.Model.Strategies.FilterStrategy;

import lombok.Getter;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Model.ISortable;

import java.util.*;

public class RecommendedFilter implements FilterStrategy {

    @Getter
    private final String name = "Mix";

    private static final List<MUSCLE_GROUP> VALUES =
            Collections.unmodifiableList(Arrays.asList(MUSCLE_GROUP.values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();


    //Filters the list with "Recommended" routines/exercises for a muscle group (Completely Random)
    public <T extends ISortable> List<T> filter(List<T> oldList){
        List<T> newList = new ArrayList<>();

        MUSCLE_GROUP mg = VALUES.get(RANDOM.nextInt(SIZE));

        for(T re : oldList){
            if(re.containsMuscleGroup(mg)){
                newList.add(re);
            }
        }

        while(newList.size() > 5){
            newList.remove(RANDOM.nextInt(newList.size()));
        }

        return newList;
    }
}
