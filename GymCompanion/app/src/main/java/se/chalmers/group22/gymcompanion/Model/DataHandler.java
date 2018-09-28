package se.chalmers.group22.gymcompanion.Model;

import se.chalmers.group22.gymcompanion.Model.Strategies.FilterStrategy.FilterStrategy;
import se.chalmers.group22.gymcompanion.Model.Strategies.SortingStrategy.SortingStrategy;

import java.util.ArrayList;
import java.util.List;

public class DataHandler {

    private static DataHandler instance = new DataHandler();

    public static DataHandler getInstance(){
        if(instance == null) {
            instance = new DataHandler();
        }
        return instance;
    }

    private List<Routine> routineList;
    private List<Exercise> exerciseList;

    private DataHandler() {
        this.routineList = new ArrayList<>();
        this.exerciseList = new ArrayList<>();
    }

    public List<Routine> getRoutines() {
        return null;
    }

    public List<Exercise> getExercises() {
        return null;
    }

    public void sort(List<? extends ISortable> list, SortingStrategy strat){
        strat.sort(list);
    }

    public <T extends ISortable> List<T> filter(List<T> toBeFiltered, FilterStrategy filter){
        List<T> newList = new ArrayList<>(toBeFiltered);
        return filter.filter(newList);
    }
}
