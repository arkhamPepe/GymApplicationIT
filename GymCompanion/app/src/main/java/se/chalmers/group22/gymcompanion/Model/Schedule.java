package se.chalmers.group22.gymcompanion.Model;

import java.util.*;

public class Schedule {

    private Reminder reminder;
    private Calendar calendar;
    private Map<Date, Routine> routineMap;
    public Schedule(){
        routineMap = new HashMap<>();
        calendar.getInstance();
    }
}
