package se.chalmers.group22.gymcompanion.ViewModel;
/***
 * Title: ProgressViewModel
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
 *
 * Used by: ProgressActivity.java, ProgressStartFragment.java
 *
 * Uses: AbstractObservableViewModel.java
 */
public class ProgressViewModel extends AbstractObservableViewModel {

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
