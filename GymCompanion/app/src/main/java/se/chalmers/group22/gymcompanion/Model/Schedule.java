package se.chalmers.group22.gymcompanion.Model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
public class Schedule {

    private List<Routine> routines = new ArrayList<>();
    private Reminder reminder;

    public Schedule(){

    }

    public void addRoutine(Routine routine, Date date){

    }

    public Routine getRoutine(Date date){
        return null;
    }
}
