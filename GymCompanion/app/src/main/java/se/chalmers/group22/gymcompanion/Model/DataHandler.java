package se.chalmers.group22.gymcompanion.Model;

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

    public void sort(List<Routine> list, SORT_MODE mode){
        switch(mode){
            case ALPHABETIC_ASC:
                list.sort(Comparator.comparing(Routine::getName));
                break;
            case ALPHABETIC_DESC:
                list.sort(Comparator.comparing(Routine::getName));
                Collections.reverse(list);
                break;
            case DIFFICULTY_ASC:
                list.sort(Comparator.comparingDouble(Routine::getDifficulty));
            case DIFFICULTY_DESC:
                list.sort(Comparator.comparingDouble(Routine::getDifficulty));
                Collections.reverse(list);
                break;

        }
    }

}
