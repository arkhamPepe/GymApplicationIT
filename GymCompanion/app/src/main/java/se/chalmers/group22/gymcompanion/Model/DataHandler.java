package se.chalmers.group22.gymcompanion.Model;

import se.chalmers.group22.gymcompanion.Enums.FILTER_MODE;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Enums.SORT_MODE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

    public void sort(List<? extends ISortable> list, SORT_MODE mode){

        switch(mode){
            case ALPHABETIC_ASC:
                list.sort(Comparator.comparing(ISortable::getName));
                break;
            case ALPHABETIC_DESC:
                list.sort(Comparator.comparing(ISortable::getName));
                Collections.reverse(list);
                break;
            case DIFFICULTY_ASC:
                list.sort(Comparator.comparingDouble(ISortable::getDifficulty));
            case DIFFICULTY_DESC:
                list.sort(Comparator.comparingDouble(ISortable::getDifficulty));
                Collections.reverse(list);
                break;
            default:
                break;
        }
    }

    public <T extends ISortable> List<T> filter(List<T> toBeFiltered, FILTER_MODE mode){
        List<T> newList = new ArrayList<>(toBeFiltered);

        switch(mode){
            case BEGINNER:
                findBeginner(newList, toBeFiltered);
                break;
        }
        return newList;
    }


    private <T extends ISortable> void findBeginner(List<T> newlist, List<T> oldlist ){
        sort(oldlist, SORT_MODE.DIFFICULTY_ASC);

        for(MUSCLE_GROUP mg : MUSCLE_GROUP.values()) {
            for (T re: oldlist) {
                if(re.containsMuscleGroup(mg) && !newlist.contains(re)){
                    newlist.add(re);
                    break;
                }
            }
        }

    }
}
