package se.chalmers.group22.gymcompanion.ViewModel;

import se.chalmers.group22.gymcompanion.Model.GymCompanion;

public abstract class BaseViewModel {
    private static GymCompanion model;

    public BaseViewModel(GymCompanion model){
        BaseViewModel.model = model;
    }

    public static GymCompanion getModel() {
        return model;
    }
}
