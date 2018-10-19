package se.chalmers.group22.gymcompanion.View.Progress.ProgressExpandList;

import java.util.ArrayList;
import java.util.List;

/***
 * Title: ProgressExpandListGroup
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 14, 2018
 *
 * Purpose: Class that contains the information necessary for the parent elements in ProgressExpandListAdapter.
 * Also contains the child elements connected to the parent.
 */

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
