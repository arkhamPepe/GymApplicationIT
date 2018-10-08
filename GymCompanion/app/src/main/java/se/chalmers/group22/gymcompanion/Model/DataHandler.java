package se.chalmers.group22.gymcompanion.Model;

import android.widget.ListView;
import lombok.Getter;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Strategies.FilterStrategy.FilterStrategy;
import se.chalmers.group22.gymcompanion.Model.Strategies.SortingStrategy.SortingStrategy;

import java.util.*;

@Getter
public class DataHandler {

    private static DataHandler instance = new DataHandler();

    public static DataHandler getInstance(){
        if(instance == null) {
            instance = new DataHandler();
        }
        return instance;
    }

    private User user;
    private LocalDatabase localDatabase;
    private List<Routine> routineList;
    private List<Exercise> exerciseList;
    private Map<Calendar, Routine> routineSchedule;

    private DataHandler() {
        this.localDatabase = LocalDatabase.getInstance();
        this.routineList = new ArrayList<>();
        this.exerciseList = new ArrayList<>();
        this.routineSchedule = new HashMap<>();
        user = localDatabase.loadUser();
    }


    public List<Routine> getRoutines() {
        return new ArrayList<>(routineList);
    }

    public List<Exercise> getExercises() {
        return new ArrayList<>(exerciseList);
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

    public List<ISortable> getRoutinesAndExercises(){
        List<ISortable> newList = new ArrayList<>();

        newList.addAll(getRoutines());
        newList.addAll(getExercises());

        return newList;
    }

    public List<ISortable> search(String search){
        if (search.equals("")) {
            return getRoutinesAndExercises();
        }

        List<ISortable> newList = new ArrayList<>();

        for (ISortable re: getRoutinesAndExercises()) {
            if(search.toLowerCase().equals(re.getName().toLowerCase())){
                newList.add(re);
            }
        }

        for (ISortable re: getRoutinesAndExercises()) {
            if(!newList.contains(re) && re.getName().toLowerCase().startsWith(search.toLowerCase())){
                newList.add(re);
            }
        }

        for (ISortable re: getRoutinesAndExercises()) {
            if(!newList.contains(re) && re.getName().toLowerCase().contains(search.toLowerCase())){
                newList.add(re);
            }
        }
        return newList;
    }

    public void createRoutine(){
        user.createRoutine();
    }

    public List<Routine> getUserRoutines(){
        return user.getRoutines();
    }

}
