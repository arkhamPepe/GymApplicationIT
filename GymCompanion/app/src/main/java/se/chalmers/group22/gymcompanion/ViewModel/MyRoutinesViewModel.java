package se.chalmers.group22.gymcompanion.ViewModel;

import lombok.Getter;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Observable;
import se.chalmers.group22.gymcompanion.Model.Observer;
import se.chalmers.group22.gymcompanion.Model.Routine;

import java.nio.channels.Channel;
import java.util.ArrayList;
import java.util.List;

public class MyRoutinesViewModel extends BaseViewModel implements Observable {

    @Getter
    private int selectedRoutineIndex;
    private int selectedExerciseIndex;
    private int selectedMGIndex;

    private List<Observer> observers = new ArrayList<>();
    private List<MUSCLE_GROUP> muscleGroups = new ArrayList<>();

    public MyRoutinesViewModel(){
        initMuscleGroups();
    }

    public void createRoutine(){
        getModel().createRoutine();
    }

    /*public void addExercise(){
        getModel().addExercise(,routines.get(selectedRoutineIndex));

    }*/

    public List getMuscleGroups(){
        List<String> muscles = new ArrayList<>();
        for(MUSCLE_GROUP mg : muscleGroups){
            muscles.add(mg.toString().replace("_", " "));
        }
        return muscles;
    }

    /* TODO FIX CODE DUPLICATION */
    private void initMuscleGroups(){
        for(MUSCLE_GROUP mg : MUSCLE_GROUP.values()) {
            muscleGroups.add(mg);
        }
    }

    public void setSelectedMGIndex(int index){
        selectedMGIndex = index;
        notifyObservers();
    }

    public String getSelectedMuscleGroup(){
        return muscleGroups.get(selectedMGIndex).toString();
    }

    public String getSelectedRoutineExerciseAmount(){
        if (!checkIfEmptyRoutineList()){
            return Integer.toString(getModel().getUser().getRoutines().get(selectedRoutineIndex).getExercises().size());
        }
        return "";
    }

    public List<Routine> getRoutines(){
        if (!checkIfEmptyRoutineList()) {
            return getModel().getUser().getRoutines();
        }
        return new ArrayList<>();
    }

    public void setSelectedRoutineIndex(int position){
        selectedRoutineIndex = position;
    }

    public void setSelectedExerciseIndex(int position){
        selectedExerciseIndex = position;
    }

    public String getSelectedRoutineName(){
        if (!checkIfEmptyRoutineList()){
             return  getModel().getUser().getRoutines().get(selectedRoutineIndex).getName();
        }
        return "";
    }

    public List<Exercise> getExercises(){
        if (!checkIfEmptyExerciseList()){
            return getModel().getUser().getRoutines().get(selectedRoutineIndex).getExercises();
        }
        return new ArrayList<>();
    }

    public void setActiveRoutine(){
        if (!checkIfEmptyRoutineList()){
            getModel().setActiveRoutine(getModel().getUser().getRoutines().get(selectedRoutineIndex));

        }
    }

    public String getExerciseName(){
        if (!checkIfEmptyExerciseList()) {
            return getModel().getUser().getRoutines().get(selectedRoutineIndex).getExercises().get(selectedExerciseIndex).getName();
        }
        return "";
    }

    public String getExerciseGuide(){
        return getModel().getUser().getRoutines().get(selectedRoutineIndex).getExercises().get(selectedExerciseIndex).getVideoguide();
    }

    public String getExerciseDescription(){
        if(!checkIfEmptyExerciseList()){
            return getModel().getUser().getRoutines().get(selectedRoutineIndex).getExercises().get(selectedExerciseIndex).getDescription();

        }
        return "";
    }

    private boolean checkIfEmptyRoutineList(){
        return getModel().getUser().getRoutines().isEmpty();
    }

    private boolean checkIfEmptyExerciseList(){
        if (!checkIfEmptyRoutineList()) {
            return getModel().getUser().getRoutines().get(selectedRoutineIndex).getExercises().isEmpty();
        }
        return true;
    }



    @Override
    public void notifyObservers() {
        for (Observer o : observers){
            o.update();
        }
    }

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }
}
