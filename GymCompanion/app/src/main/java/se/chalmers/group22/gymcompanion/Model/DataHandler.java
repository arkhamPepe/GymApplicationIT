package se.chalmers.group22.gymcompanion.Model;

import android.provider.ContactsContract;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;
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

    public List<ISortable> getRoutinesAndExercises(){
        List<ISortable> newList = new ArrayList<>();
        for (Routine r: DataHandler.getInstance().getRoutines()) {
            newList.add(r);
        }
        for (Exercise e: DataHandler.getInstance().getExercises()) {
            newList.add(e);
        }
        return newList;
    }

    public List<ISortable> search(String search, String sort){
        if (search.equals("")) {
            return DataHandler.getInstance().getRoutinesAndExercises();
        }

        List<ISortable> newList = new ArrayList<>();
        for (ISortable re: DataHandler.getInstance().getRoutinesAndExercises()) {
            if(search.equals(re.getName())){
                newList.add(re);
            }
        }
        return newList;
    }

}
