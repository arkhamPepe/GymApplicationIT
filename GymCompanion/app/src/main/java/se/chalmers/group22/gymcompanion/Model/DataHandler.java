package se.chalmers.group22.gymcompanion.Model;

import java.util.ArrayList;
import java.util.List;

public class DataHandler {

    private static DataHandler instance;

    public static DataHandler getInstance(){
        if(instance == null) {
            instance = new DataHandler();
        }
        return instance;
    }

    private List<Routine> routineList;
    private List<Exercise> exerciseList;

    DataHandler() {
        this.routineList = new ArrayList<>();
        this.exerciseList = new ArrayList<>();
    }

    public void getRoutines() {}

    public void getExercises() {}

}
