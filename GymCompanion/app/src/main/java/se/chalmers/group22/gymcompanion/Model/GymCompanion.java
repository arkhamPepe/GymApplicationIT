package se.chalmers.group22.gymcompanion.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.Map;

@Getter
public class GymCompanion {
    @Setter
    private User user;
    private DataHandler dataHandler = DataHandler.getInstance();

    public GymCompanion(){
        user = LocalDatabase.getInstance().loadUser();
    }

    public String getTodaysRoutineName(){
        return user.getTodaysRoutineName();
    }

    public void startRoutine(){
        user.startRoutine(user.getTodaysRoutine());
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
        for (Routine r : dataHandler.getRoutines()){
            if (r.getName().equals(routineName))
                return r;
        }

        return null;
    }
}
