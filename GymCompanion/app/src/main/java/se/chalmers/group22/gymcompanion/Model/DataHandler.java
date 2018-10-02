package se.chalmers.group22.gymcompanion.Model;

import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Strategies.FilterStrategy.FilterStrategy;
import se.chalmers.group22.gymcompanion.Model.Strategies.SortingStrategy.SortingStrategy;

import java.util.*;

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
    private Map<Calendar, Routine> routineSchedule;

    private DataHandler() {
        this.routineList = new ArrayList<>();
        this.exerciseList = new ArrayList<>();
        this.routineSchedule = new HashMap<>();
    }

    public List<Routine> getRoutines() {
        return null;
    }

    public List<Exercise> getExercises() {
        return null;
    }

    public Map<Calendar, Routine> getSchedule() {
        return new HashMap<>(routineSchedule);
    }

    public void sort(List<? extends ISortable> list, SortingStrategy strat){
        strat.sort(list);
    }

    public <T extends ISortable> List<T> filter(List<T> toBeFiltered, FilterStrategy filter){
        List<T> newList = new ArrayList<>(toBeFiltered);
        return filter.filter(newList);
    }

    public <T extends ISortable> List<T> filter(List<T> toBeFiltered, List<MUSCLE_GROUP> muscleGroups) {
        List<T> newList = new ArrayList<>(toBeFiltered);

        for (MUSCLE_GROUP mg : muscleGroups){
            for (T re : toBeFiltered) {
                if (re.containsMuscleGroup(mg) && !newList.contains(re)) {
                    newList.add(re);
                }
            }
        }
        return newList;
    }

}
