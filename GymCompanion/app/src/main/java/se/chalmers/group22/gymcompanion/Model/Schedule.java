package se.chalmers.group22.gymcompanion.Model;

import lombok.AccessLevel;
import lombok.Getter;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;

import java.io.Serializable;
import java.util.*;

@Getter
public class Schedule implements Serializable {

    private Reminder reminder;
    private Calendar calendar = new GregorianCalendar();

    @Getter(AccessLevel.NONE)
    private Map<Calendar, Routine> routineSchedule;

    public Schedule(){
        reminder = new Reminder();
        routineSchedule = new HashMap<>();
    }


    public void addRoutine(Routine r, Calendar day){
        routineSchedule.put(day,r);
    }

    public void removeRoutine(Calendar day){
        routineSchedule.remove(day);
    }

    public Routine getRoutineFromDay(Calendar day){
        return routineSchedule.get(day);
    }

    public boolean dayHasRoutine(Calendar day){
        return routineSchedule.containsKey(day);
    }

    public Map<Calendar, Routine> getSchedule() {
        return new HashMap<>(routineSchedule);
    }

    public Set<Calendar> getScheduleKeySet(){
        return routineSchedule.keySet();
    }



    public String getRoutineNameFromDay(Calendar day){
        return getRoutineFromDay(day).getName();
    }


    public Routine getLatestFinishedRoutine(){
        Calendar latestDate = null;
        Routine finishedRoutine = null;
        for(Calendar date : getScheduleKeySet()){
            if (latestDate == null || date.getTime().after(latestDate.getTime())) {
                latestDate = date;
                finishedRoutine = routineSchedule.get(latestDate);
            }
        }

        return finishedRoutine;
    }
}
