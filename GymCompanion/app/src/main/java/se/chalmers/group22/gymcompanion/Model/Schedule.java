package se.chalmers.group22.gymcompanion.Model;

import lombok.Getter;

import java.util.*;


public class Schedule {

    private Reminder reminder;

    @Getter
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

    public Routine getRoutine(Calendar day){
        return routineSchedule.get(day);
    }

    public boolean dayHasRoutine(Calendar day){
        return routineSchedule.containsKey(day);
    }
}
