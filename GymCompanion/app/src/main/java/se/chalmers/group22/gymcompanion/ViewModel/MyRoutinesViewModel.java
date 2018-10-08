package se.chalmers.group22.gymcompanion.ViewModel;

import android.arch.lifecycle.ViewModel;
import se.chalmers.group22.gymcompanion.Model.DataHandler;

public class MyRoutinesViewModel extends ViewModel {
    private DataHandler dataHandler;

    public MyRoutinesViewModel(){
        dataHandler = DataHandler.getInstance();
    }
}
