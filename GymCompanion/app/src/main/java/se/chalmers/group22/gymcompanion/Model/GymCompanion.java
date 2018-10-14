package se.chalmers.group22.gymcompanion.Model;

import lombok.Getter;
import lombok.Setter;
import se.chalmers.group22.gymcompanion.Model.Exercises.CardioExercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.StrengthExercise;

import java.util.Calendar;

@Getter
public class GymCompanion {
    @Setter
    private User user;

    private Routine activeRoutine;
    private Exercise activeExercise;
    private boolean isRoutineActive;

    public GymCompanion(){

    }

    public String getTodaysRoutineName(){
        return user.getTodaysRoutineName();
    }

    public void startRoutine(){
        startRoutine(user.getTodaysRoutine());
    }

    public void startRoutine(Routine routine){
        /*TODO Start the routine for the current day*/
        isRoutineActive = true;
        activeRoutine = routine;
        /*TODO redirect to "Workout in progress"-page*/
    }

    public void endActiveRoutine(){
        activeRoutine = null;
        isRoutineActive = false;
    }

    public void checkDay(){
        Calendar today = Calendar.getInstance();
        if (user.scheduleDayHasRoutine(today)){
            startRoutine(user.getSchedulRoutineFromDay(today));
        }
        else {
            /*TODO Direct the user to MR so it can create a new routine*/
        }
    }

    public void setActiveExerciseInActiveRoutine(int index){
        activeExercise = activeRoutine.getExercises().get(index);
    }

    public int getAmountOfExercisesInAR(){
        if(activeRoutine == null)
        {
            return 0;
        }
        return activeRoutine.getExercises().size();
    }

    public String getActiveExerciseName(){
        return activeExercise.getName();
    }

    public boolean isActiveExerciseStrengthExercise(){
        return activeExercise instanceof StrengthExercise;
    }

    public int getAmountOfSetsInAE(){
        return ((StrengthExercise)activeExercise).getSets();
    }

    public int getTimeInAE(){
        return ((CardioExercise)activeExercise).getTimespent();
    }

    public int getAmountOfRepsFromAESetWithIndex(int index){
        return ((StrengthExercise)activeExercise).getRepetitions().get(index);
    }

    public double getAmountWeightFromAESetWithIndex(int index){
        return ((StrengthExercise)activeExercise).getKilograms().get(index);
    }


}
