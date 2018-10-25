package se.chalmers.group22.gymcompanion.ViewModel;

import lombok.Getter;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Model.Workout.Exercises.CardioExercise;
import se.chalmers.group22.gymcompanion.Model.Workout.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Workout.Exercises.StrengthExercise;
import se.chalmers.group22.gymcompanion.Model.Workout.Routine;

import java.util.ArrayList;
import java.util.List;
/***
 * Title: MyRoutinesViewModel
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 12, 2018
 *
 * Purpose: To handle the communication between the model and the view without without showing the model's underlying
 * representation to the view.
 */
public class MyRoutinesViewModel extends ObservableViewModel {

    @Getter
    private int selectedRoutineIndex;
    private int selectedExerciseIndex;
    private int selectedMGIndex;

    private List<MUSCLE_GROUP> muscleGroups = new ArrayList<>();

    public MyRoutinesViewModel(){
        initMuscleGroups();
    }

    public void removeExercise(String exerciseName){
        getModel().removeExerciseFromRoutine(selectedRoutineIndex,exerciseName);
        notifyObservers();
        saveUser();
    }
    public void removeSelectedRoutine(int position){
        getModel().removeRoutine(position);
        saveUser();
        notifyObservers();
    }

    public void createRoutine(){
        getModel().createRoutine();
        setSelectedRoutineIndex(getModel().getUser().getRoutines().size()-1);
        notifyObservers();
        saveUser();
    }

    public void addExercise(String exerciseName){
        getModel().addExerciseToRoutine(selectedRoutineIndex, exerciseName);
        saveUser();
    }

    public void setSelectedRoutineName(String name){
        getModel().setSelectedRoutineName(selectedRoutineIndex,name);
        notifyObservers();
        saveUser();
    }

    public List<Double> getRoutineExercisesDifficulty(){
        List<Double> exercisesDifficulty = new ArrayList<>();
        for (Exercise exercise : getModel().getExerciseList()){
            exercisesDifficulty.add(exercise.getDifficulty());
        }
        return exercisesDifficulty;
    }

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

    public List<String> getExerciseNamesWithMG(MUSCLE_GROUP mg){
        List<String> exerciseNames = new ArrayList<>();

        for (Exercise exercise: getModel().getExerciseList()){
            if (exercise.getMuscleGroups().contains(mg)){
                exerciseNames.add(exercise.getName());
            }
        }

        return exerciseNames;
    }

    public List<String> getSelectedRoutineExercisesNames(){
        List<String> exerciseNames = new ArrayList<>();
        
        for (Exercise exercise: getModel().getSelectedRoutineExercises(selectedRoutineIndex)){
            exerciseNames.add(exercise.getName());
        }

        return exerciseNames;
    }

    public List<Integer> getSelectedRoutineExercisesSetAmount(){
        List<Integer> sets = new ArrayList<>();

        for(Exercise exercise : getModel().getSelectedRoutineExercises(selectedRoutineIndex)){
            if(exercise instanceof StrengthExercise){
                sets.add(((StrengthExercise) exercise).getSets());
            }
            else{
                sets.add(0);
            }
        }
        return sets;
    }

    public List<Integer> checkIfNoRoutine(){
        List<Integer> amountlist = new ArrayList<>();
        int size = getExerciseNamesWithMG(getSelectedMuscleGroup()).size();
        for (int i = 0; i < size; i++){
            amountlist.add(0);
        }
        return amountlist;
    }

    public void setSelectedMGIndex(int index){
        selectedMGIndex = index;
        notifyObservers();
    }

    public MUSCLE_GROUP getSelectedMuscleGroup(){
        return muscleGroups.get(selectedMGIndex);
    }

    public String getSelectedRoutineExerciseAmount(){
        if (!checkIfEmptyRoutineList()){
            return Integer.toString(getModel().getUserRoutines().get(selectedRoutineIndex).getExercises().size());
        }
        return "";
    }

    public List<Routine> getRoutines(){
        if (!checkIfEmptyRoutineList()) {
            return getModel().getUserRoutines();
        }
        return new ArrayList<>();
    }

    public void setSelectedRoutineIndex(int position){
        selectedRoutineIndex = position;
        notifyObservers();
    }

    public void setSelectedExerciseIndex(int position){
        selectedExerciseIndex = position;
        notifyObservers();
    }

    public String getSelectedRoutineName(){
        if (!checkIfEmptyRoutineList()){
             return  getModel().getUserRoutines().get(selectedRoutineIndex).getName();
        }
        return "";
    }


    public List<Exercise> getExercises(){
        if (!checkIfEmptyExerciseList()){
            return getModel().getUserRoutines().get(selectedRoutineIndex).getExercises();
        }
        return new ArrayList<>();
    }

    //TODO fix all Law of demeter deal-breakers
    public String getExerciseName(){
        if (!checkIfEmptyExerciseList()) {
            return getModel().getSelectedExerciseName(selectedRoutineIndex,selectedExerciseIndex);
        }
        return "";
    }

    public String getSelectedCardioExerciseIntensity(){
        if(!checkIfEmptyExerciseList()) {
            return getModel().getCardioExerciseIntensity(selectedRoutineIndex,selectedExerciseIndex).toString();
        }
        return "";
    }


    public int getSelectedCardioExerciseTime(){
        if (!checkIfEmptyExerciseList() && checkTypeExercise() !=1){
                return getModel().getSelectedCardioExerciseTime(selectedRoutineIndex,selectedExerciseIndex);
        }
        return 0;
    }

    private Exercise getSelectedExecise(){
        if(!checkIfEmptyExerciseList()){
        return getModel().getSelectedExercise(selectedRoutineIndex,selectedExerciseIndex);
        }
        return null;
    }

    public int checkTypeExercise(){
        if (getSelectedExecise() instanceof StrengthExercise){
            return 1;
        }
        else {
            return 0;
        }
    }

    public List<Double> getStrengthExerciseKilograms(){
        if(!checkIfEmptyExerciseList() && checkTypeExercise() == 1) {
            return (getModel().getStrenghtExerciseKilograms(selectedRoutineIndex,selectedExerciseIndex));
        }
        return new ArrayList<>();
    }

    public List<Integer> getStrengthExerciseReps(){
        if(!checkIfEmptyExerciseList() && checkTypeExercise() == 1) {
            return (getModel().getStrenghtExerciseReps(selectedRoutineIndex,selectedExerciseIndex));
        }
        return new ArrayList<>();
    }

    public int getStrengthExerciseSets(){
        if(!checkIfEmptyExerciseList() && checkTypeExercise() == 1){
            return ((StrengthExercise) getModel().getUserRoutines().
                    get(selectedRoutineIndex).getExercises().get(selectedExerciseIndex)).getSets();
        }
        return 0;
    }

    public void updateStrengthExerciseSets(int sets){
        if(!checkIfEmptyExerciseList() && checkTypeExercise() == 1){
            ((StrengthExercise) getModel().getUserRoutines().
                    get(selectedRoutineIndex).getExercises().get(selectedExerciseIndex)).updateSets(sets);
            saveUser();
        }
    }

    public void updateSelectedExerciseKilogramInSet(int index, int value){
        StrengthExercise se = (StrengthExercise) ( getModel().getUserRoutines().
                get(selectedRoutineIndex).getExercises().get(selectedExerciseIndex));

        se.setKilogram(index, value);
        notifyObservers();
        saveUser();
    }

    public void updateSelectedExerciseRepsInSet(int index, int value){
        StrengthExercise se = (StrengthExercise) ( getModel().getUserRoutines().
                get(selectedRoutineIndex).getExercises().get(selectedExerciseIndex));
        se.setRepetitions(index, value);
        notifyObservers();
        saveUser();
    }

    private boolean checkIfEmptyRoutineList(){
        try{
            getModel().getUserRoutines().get(selectedRoutineIndex);
            return false;

        }catch(Exception e){
            return true;
        }
    }

    private boolean checkIfEmptyExerciseList(){
        if (!checkIfEmptyRoutineList()) {
            return getModel().getUserRoutines().get(selectedRoutineIndex).getExercises().isEmpty();
        }
        return true;
    }

    private void saveUser(){
        getModel().saveUser();
    }

    public List<String> getRoutineNames(){
        return getModel().getRoutineNames();
    }

    public List<Integer> getRoutinesExerciseCount(){
        return getModel().getRoutinesExerciseCount();
    }
}
