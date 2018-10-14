package se.chalmers.group22.gymcompanion.ViewModel;

import java.util.Map;

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

    public Map<String, String> getFinishedRoutineStats(){
        return getModel().getFinishedRoutineStats();
    }

}
