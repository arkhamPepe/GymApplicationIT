package se.chalmers.group22.gymcompanion.ViewModel;

import android.arch.lifecycle.ViewModel;
import se.chalmers.group22.gymcompanion.Model.DataHandler;

public class MainViewModel extends ViewModel {

    public String getScheduledRoutineName(){
        return DataHandler.getInstance().getScheduledRoutine();
    }

}
