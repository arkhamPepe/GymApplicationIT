package se.chalmers.group22.gymcompanion.Model;

import java.util.*;

public class Schedule {

    private Reminder reminder;
    private Calendar calendar;
    private Map<Calendar, Routine> routineMap;

    public Schedule(){
        routineMap = new HashMap<>();
    }

    public void addRoutine(Calendar date, Routine routine){
        routineMap.put(date, routine);
    }

    public boolean hasRoutine(){
        /*Checks if there is a routine on the current day*/
        Calendar currentTime = Calendar.getInstance();
        return routineMap.containsKey(currentTime);
    }

    public Routine getRoutineCurrent(){
        return routineMap.get(calendar);
    }
}
