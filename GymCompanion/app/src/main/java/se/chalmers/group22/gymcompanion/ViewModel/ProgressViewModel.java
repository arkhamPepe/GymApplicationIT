package se.chalmers.group22.gymcompanion.ViewModel;

public class ProgressViewModel extends BaseViewModel {

    public String getScheduledRoutineName(){
        return null;
    }

    public void setActiveExercise(int i){
        getModel().setActiveExerciseInActiveRoutine(i);
    }


    public int getAmountOfExercisesInAR(){
        return getModel().getAmountOfExercisesInActiveRoutine();
    }

    public String getAEName(){
        return getModel().getActiveExerciseName();
    }

    public boolean isExerciseInARStrengthExercise(){
        return getModel().isActiveExerciseStrengthExercise();
    }

    public int getAmountOfSetsInAE(){
        return getModel().getAmountOfSetsInActiveExercise();
    }

    public int getAmountOfRepsFromARExerciseSetWithIndex(int index){
        return getModel().getAmountOfRepsFromActiveExerciseSetWithIndex(index);
    }

    public double getAmountWeightFromARExerciseSetWithIndex(int index){
        return getModel().getAmountWeightFromActiveExerciseSetWithIndex(index);
    }

    public int getTimeInActiveExercise(){
        return getModel().getTimeInActiveExercise();
    }

}
