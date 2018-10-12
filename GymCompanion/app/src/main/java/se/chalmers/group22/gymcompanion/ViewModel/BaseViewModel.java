package se.chalmers.group22.gymcompanion.ViewModel;

import se.chalmers.group22.gymcompanion.Model.GymCompanion;

public abstract class BaseViewModel {
    private static GymCompanion model;

    public BaseViewModel(){

    }

    public static GymCompanion getModel() {
        return model;
    }

    public static void setModel(GymCompanion model) {
        BaseViewModel.model = model;
    }
}
