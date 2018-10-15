package se.chalmers.group22.gymcompanion.ViewModel;

import android.arch.lifecycle.ViewModel;
import se.chalmers.group22.gymcompanion.Model.DataHandler;
import se.chalmers.group22.gymcompanion.Model.Routine;

import java.util.ArrayList;
import java.util.List;

public class MyRoutinesViewModel extends BaseViewModel {

    private int selectedRoutineIndex;
    List<Routine> routines = new ArrayList<>();

    public MyRoutinesViewModel(){
        routines.add(new Routine("Routine1"));
        routines.add(new Routine("YA TEET"));
    }

    /*public List<Routine> getUserRoutines(){

    }*/

    public void createRoutine(){
        getModel().createRoutine();
    }

    public void addExercise(){
        //getModel().addExercise();
    }

    public String setRoutineName(){
        return null;
    }

    public String setAmountOfExercises(){
        return null;
    }

    public List<Routine> getRoutines(){
        return routines;
    }

    public void setPosition(int position){
        selectedRoutineIndex = position;
    }

    public String getSelectedRoutineName(){
        return  routines.get(selectedRoutineIndex).getName();
    }
}
