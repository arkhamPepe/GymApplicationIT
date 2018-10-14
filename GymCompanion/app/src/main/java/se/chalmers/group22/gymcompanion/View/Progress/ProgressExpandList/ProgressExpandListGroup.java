package se.chalmers.group22.gymcompanion.View.Progress.ProgressExpandList;

import se.chalmers.group22.gymcompanion.View.Progress.ProgressExpandList.ProgressExpandListChild;

import java.util.ArrayList;

public class ProgressExpandListGroup {

    private String Name;
    private ArrayList<ProgressExpandListChild> Items;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public ArrayList<ProgressExpandListChild> getItems() {
        return Items;
    }

    public void setItems(ArrayList<ProgressExpandListChild> Items) {
        this.Items = Items;
    }

}
