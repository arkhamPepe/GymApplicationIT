package se.chalmers.group22.gymcompanion.ViewModel;

public class ProgressViewModel extends BaseViewModel {

    public String getScheduledRoutineName(){
        String routineName = getModel().getScheduledRoutineName();
        if(routineName.length() > 25){
            routineName = routineName.substring(0, 25) + "...";
        }
        return routineName;
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

    public void toggleCompletionExerciseInARWithIndex(int index, boolean completed){
        getModel().toggleCompletionExerciseInARWithIndex(index, completed);
    }

    public void completeActiveRoutine(){
        getModel().completeActiveRoutine();
    }

}
