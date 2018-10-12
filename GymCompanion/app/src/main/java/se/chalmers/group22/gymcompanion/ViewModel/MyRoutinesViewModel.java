package se.chalmers.group22.gymcompanion.ViewModel;

import android.arch.lifecycle.ViewModel;
import se.chalmers.group22.gymcompanion.Model.DataHandler;
import se.chalmers.group22.gymcompanion.Model.Routine;

import java.util.List;

public class MyRoutinesViewModel extends BaseViewModel {
    private DataHandler dataHandler;

    public MyRoutinesViewModel(){
        dataHandler = DataHandler.getInstance();
    }

    public List<Routine> getUserRoutines(){
        return dataHandler.getUserRoutines();
    }
}
