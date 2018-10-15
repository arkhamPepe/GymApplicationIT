package se.chalmers.group22.gymcompanion.ViewModel;

import android.arch.lifecycle.ViewModel;
import se.chalmers.group22.gymcompanion.Model.DataHandler;
import se.chalmers.group22.gymcompanion.Model.Routine;

import java.util.List;

public class MyRoutinesViewModel extends BaseViewModel {

    public MyRoutinesViewModel(){
    }

    /*public List<Routine> getUserRoutines(){
        //return getModel().createRooutine();
    }*/

    public void createRoutine(){
        getModel().createRoutine();
    }

    public void addExercise(){
        //getModel().addExercise();
    }


}
