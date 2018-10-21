package se.chalmers.group22.gymcompanion.Model.Strategies.SortingStrategy;

import se.chalmers.group22.gymcompanion.Model.Strategies.ISortable;

import java.util.List;

public interface SortingStrategy {

    <T extends ISortable> void sort(List<T> list);
}
