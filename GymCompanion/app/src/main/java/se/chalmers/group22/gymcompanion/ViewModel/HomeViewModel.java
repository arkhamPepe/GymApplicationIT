package se.chalmers.group22.gymcompanion.ViewModel;

import java.util.List;

public class HomeViewModel extends BaseViewModel {

    public HomeViewModel(){
    }

    public String getScheduledRoutineName(){
        return "Hej";
    }

    public String getTodaysRoutineName(){
        return getModel().getTodaysRoutineName();
    }

    public void startRoutine(){
        getModel().startRoutine();
    }

}
