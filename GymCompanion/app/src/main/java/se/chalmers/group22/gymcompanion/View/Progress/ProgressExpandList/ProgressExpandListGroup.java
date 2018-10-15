package se.chalmers.group22.gymcompanion.View.Progress.ProgressExpandList;

import java.util.ArrayList;
import java.util.List;

public class ProgressExpandListGroup {

    private String exerciseName;

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    private String extraInfo;
    private ArrayList<ProgressExpandListChild> sets;

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public ArrayList<ProgressExpandListChild> getItems() {
        return sets;
    }

    public void setItems(ArrayList<ProgressExpandListChild> sets) {
        this.sets = (ArrayList<ProgressExpandListChild>) sets.clone();
    }

}
