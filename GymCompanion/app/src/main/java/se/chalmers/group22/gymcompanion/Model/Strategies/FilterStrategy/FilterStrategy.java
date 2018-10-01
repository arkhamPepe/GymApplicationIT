package se.chalmers.group22.gymcompanion.Model.Strategies.FilterStrategy;

import se.chalmers.group22.gymcompanion.Model.ISortable;

import java.util.List;

public interface FilterStrategy {

    <T extends ISortable> List<T> filter(List<T> toBeFiltered);
}
