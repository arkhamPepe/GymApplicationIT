package se.chalmers.group22.gymcompanion.Model;

import lombok.Getter;
import lombok.Setter;
import se.chalmers.group22.gymcompanion.Model.Exercises.CardioExercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.StrengthExercise;


import java.util.Calendar;
import java.util.Map;

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

    public int getAmountOfSetsInActiveExercise(){
        return ((StrengthExercise)activeExercise).getSets();
    }

    public int getTimeInActiveExercise(){
        return ((CardioExercise)activeExercise).getTimespent();
    }

    public int getAmountOfRepsFromActiveExerciseSetWithIndex(int index){
        return ((StrengthExercise)activeExercise).getRepetitions().get(index);
    }

    public double getAmountWeightFromActiveExerciseSetWithIndex(int index){
        return ((StrengthExercise)activeExercise).getKilograms().get(index);
    }

    public Routine getFinishedRoutine() {
        return user.getFinishedRoutine();
    }

    public Map<Calendar, Routine> getUserRoutineSchedule(){
        return user.getRoutineSchedule();
    }

    public ISchedule getUserSchedule(){
        return user.getSchedule();
    }

    public String getTodaysDate(){
        return user.getToday();
    }

    public int getYearToday() {
        return user.getYearToday();
    }

    public int getMonthToday() {
        return user.getMonthToday();
    }

    public int getDayToday() {
        return user.getDayToday();
    }

    public boolean isScheduled(Calendar day){
        return user.getSchedule().dayHasRoutine(day);
    }

    public void scheduleRoutine(Calendar day, String routineName){
        Routine routine = getRoutine(routineName);

        user.getSchedule().addRoutine(routine, day);
    }

    public double getRoutineDifficulty(Routine routine){
        return routine.getAverageDifficulty();
    }

    public String getRoutineNameOnDate(int year, int month, int day){
        return user.getRoutineNameOnDate(year, month, day);
    }

    private Routine getRoutine(String routineName){
        for (Routine r : user.getRoutines()){
            if (r.getName().equals(routineName))
                return r;
        }

        return null;
    }
}
