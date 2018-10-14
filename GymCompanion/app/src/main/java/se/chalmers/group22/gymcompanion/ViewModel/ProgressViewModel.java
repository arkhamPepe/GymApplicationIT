package se.chalmers.group22.gymcompanion.ViewModel;

public class ProgressViewModel extends BaseViewModel {

    public String getScheduledRoutineName(){
        return null;
    }

    public void setActiveExercise(int i){
        getModel().setActiveExerciseInActiveRoutine(i);
    }


    public int getAmountOfExercisesInAR(){
        return getModel().getAmountOfExercisesInAR();
    }

    public String getAEName(){
        return getModel().getActiveExerciseName();
    }

    public boolean isExerciseInARStrengthExercise(){
        return getModel().isActiveExerciseStrengthExercise();
    }

    public int getAmountOfSetsInAE(){
        return getModel().getAmountOfSetsInAE();
    }

    public int getAmountOfRepsFromARExerciseSetWithIndex(int index){
        return getModel().getAmountOfRepsFromAESetWithIndex(index);
    }

    public double getAmountWeightFromARExerciseSetWithIndex(int index){
        return getModel().getAmountWeightFromAESetWithIndex(index);
    }

    public int getTimeInAE(){
        return getModel().getTimeInAE();
    }

}
