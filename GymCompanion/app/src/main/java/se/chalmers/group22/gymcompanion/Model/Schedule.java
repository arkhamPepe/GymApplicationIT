package se.chalmers.group22.gymcompanion.Model;

import lombok.Getter;

import java.io.Serializable;
import java.util.*;


public class Schedule implements Serializable {

    private Reminder reminder;
    private Calendar calendar = new GregorianCalendar();
    private Map<Day, Routine> schedule = new HashMap<>();


    public Schedule(){
    }


    public void addRoutine(Routine r, Day d){
        schedule.put(d,r);
    }

    public void removeRoutine(Day d){
        schedule.remove(d);
    }

    public Routine getRoutine(Day d){
        return schedule.get(d);
    }

    public boolean dayHasRoutine(Day d){
        return schedule.containsKey(d);
    }
}
