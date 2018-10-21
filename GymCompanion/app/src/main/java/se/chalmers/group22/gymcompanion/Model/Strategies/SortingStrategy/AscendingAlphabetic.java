package se.chalmers.group22.gymcompanion.Model.Strategies.SortingStrategy;

import se.chalmers.group22.gymcompanion.Model.Strategies.ISortable;

import java.util.Comparator;
import java.util.List;

public class AscendingAlphabetic implements SortingStrategy {

    @Override
    public <T extends ISortable> void sort(List<T> list){
        list.sort(Comparator.comparing(ISortable::getName));
    }
}
