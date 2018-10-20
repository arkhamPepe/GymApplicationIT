package se.chalmers.group22.gymcompanion.Model;

import java.util.Calendar;

/***
 * Title: ISchedule
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 12, 2018
 *
 * Purpose: Interface to abstract essential Schedule methods.
 */

public interface ISchedule {
    String getRoutineNameFromDate(Calendar date);

    boolean dateHasRoutine(Calendar date);

    void addRoutine(Routine r, Calendar date);

    void removeRoutine(Calendar date);

    String getRoutineNameFromDate(int year, int dayOfYear);

    String getRoutineNameFromDate(int year, int month, int dayOfMonth);
}
