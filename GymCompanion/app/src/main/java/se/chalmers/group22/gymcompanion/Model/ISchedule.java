package se.chalmers.group22.gymcompanion.Model;

import java.util.Calendar;

public interface ISchedule {
    String getRoutineNameFromDay(Calendar day);

    boolean dayHasRoutine(Calendar day);
}
