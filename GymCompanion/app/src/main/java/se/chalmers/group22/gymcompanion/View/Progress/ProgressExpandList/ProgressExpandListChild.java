// Title    :  ProgressExpandListChild
// Authors  :  Alexander Bergsten, Marcus Svensson, Erik Bock, Augustas Eidikis, Daniel Olsson
// Created  :  October 14, 2018
//
// Purpose  :  Class that contains the information necessary for the child elements in ProgressExpandListAdapter
//----------------------------------------------------------------------------------------------

package se.chalmers.group22.gymcompanion.View.Progress.ProgressExpandList;

public class ProgressExpandListChild {

    private int reps;
    private double weight;

    public int getReps() {
        return reps;
    }
    public void setReps(int reps) {
        this.reps = reps;
    }
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

}
