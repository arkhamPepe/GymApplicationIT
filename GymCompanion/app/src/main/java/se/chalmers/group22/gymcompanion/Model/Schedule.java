package se.chalmers.group22.gymcompanion.Model;

import lombok.AccessLevel;
import lombok.Getter;

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

    public Routine getRoutine(Calendar day){
        return routineSchedule.get(day);
    }

    public boolean dayHasRoutine(Calendar day){
        return routineSchedule.containsKey(day);
    }

    public Map<Calendar, Routine> getSchedule() {
        return new HashMap<>(routineSchedule);
    }
}
