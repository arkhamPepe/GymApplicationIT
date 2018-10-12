package se.chalmers.group22.gymcompanion.ViewModel;

import android.arch.lifecycle.ViewModel;
import se.chalmers.group22.gymcompanion.Model.GymCompanion;

public abstract class BaseViewModel extends ViewModel {
    private final static GymCompanion model = new GymCompanion();

    public BaseViewModel(){

    }

    public static GymCompanion getModel() {
        return model;
    }
}
