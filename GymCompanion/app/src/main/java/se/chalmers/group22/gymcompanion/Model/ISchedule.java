package se.chalmers.group22.gymcompanion.Model;

import java.util.Calendar;

public interface ISchedule {
    String getRoutineNameFromDate(Calendar date);

    boolean dateHasRoutine(Calendar date);

    void addRoutine(Routine r, Calendar date);

    void removeRoutine(Calendar date);

    String getRoutineNameFromDate(int year, int dayOfYear);

    String getRoutineNameFromDate(int year, int month, int dayOfMonth);
}
