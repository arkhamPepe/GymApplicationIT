package se.chalmers.group22.gymcompanion.Model.Schedule;

import lombok.AccessLevel;
import lombok.Getter;
import se.chalmers.group22.gymcompanion.Model.Workout.Routine;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

/***
 * Title: Schedule
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: September 21, 2018
 *
 * Purpose: Class for scheduling user routines.
 * Used by: GymCompanion.java, ScheduleTest.java, StatisticsCalculator.java, User.java
 * Uses: Routine.java
 */

@Getter
public class Schedule implements Serializable {

    private Calendar calendar = new GregorianCalendar();
    private final String NO_ROUTINE_SCHEDULED_ON_DATE = "No Scheduled Routine";

    @Getter(AccessLevel.NONE)
    private Map<Calendar, Routine> routineSchedule;

    public Schedule(){
        routineSchedule = new HashMap<>();
    }

    /** addRoutine
     * Purpose: Schedule input routine on input date.
     * @param routine
     * @param date
     */
    public void addRoutine(Routine routine, Calendar date){
        if (routine != null && date != null ) {
            removeRoutine(date); // Remove existing booked date
            routineSchedule.put(date, routine); // Schedule new routine
        }
    }

    /** removeRoutine
     * Purpose: Remove routine on input date from schedule
     * @param date
     */
    public void removeRoutine(Calendar date){
        for (Calendar calendar : routineSchedule.keySet()){
            if (calendar.get(Calendar.DAY_OF_YEAR) == date.get(Calendar.DAY_OF_YEAR) &&
                    calendar.get(Calendar.YEAR) == date.get(Calendar.YEAR)
            ){
                routineSchedule.remove(calendar);
            }
        }
    }

    /** dateHasRoutine
     * @param date
     * @return true if input date has a routine scheduled, else false
     */
    public boolean dateHasRoutine(Calendar date){
        for (Calendar calendar : routineSchedule.keySet()){
            if (calendar.get(Calendar.DAY_OF_YEAR) == date.get(Calendar.DAY_OF_YEAR) &&
                    calendar.get(Calendar.YEAR) == date.get(Calendar.YEAR)
            ){
                return true;
            }
        }
        return false;
    }

    /**--------------------------------------------------------------*/
    /**                         GETTERS                              */
    /**--------------------------------------------------------------*/

    /** getRoutineFromDay
     * @param date
     * @return Routine object scheduled on input date
     */
    public Routine getRoutineFromDay(Calendar date){
        for (Calendar calendar : routineSchedule.keySet()){
            if (calendar.get(Calendar.DAY_OF_YEAR) == date.get(Calendar.DAY_OF_YEAR) &&
                    calendar.get(Calendar.YEAR) == date.get(Calendar.YEAR)
            ){
                return routineSchedule.get(calendar);
            }
        }
        return null;
    }

    /** getSchedule
     * @return Defensive copy of the routine schedule.
     */
    public Map<Calendar, Routine> getSchedule() {
        return new HashMap<>(routineSchedule);
    }

    /** getTodayText
     * @return String representation of the date of today.
     */
    public String getTodayText(){
        return getDateText(calendar); // calendar has today's date
    }

    public String getDateText(int year, int month, int day){
        Calendar date = new GregorianCalendar();
        date.set(Calendar.YEAR, year);
        date.set(Calendar.MONTH, month);
        date.set(Calendar.DAY_OF_MONTH, day);

        return getDateText(date);
    }

    private String getDateText(Calendar date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date.getTime());
    }

    /** getScheduleKeySet()
     * @return all dates with a scheduled routine.
     */
    public Set<Calendar> getScheduleKeySet(){
        return routineSchedule.keySet();
    }

    /** getLatestFinishedRoutine
     * @return the latest finished routine.
     */
    public Routine getLatestFinishedRoutine() {
        Calendar latestDate = null;
        Routine finishedRoutine = null;
        for (Calendar date : getScheduleKeySet()) {
            if (latestDate == null || date.getTime().after(latestDate.getTime())) {
                latestDate = date;
                finishedRoutine = routineSchedule.get(latestDate);
            }
        }
        return finishedRoutine;
    }

    /** getRoutineNameFromDate
     * @param date
     * @return name of the routine that is scheduled on input date.
     */
    public String getRoutineNameFromDate(Calendar date){

        Routine r = getRoutineFromDay(date);
        if(r==null){
            return NO_ROUTINE_SCHEDULED_ON_DATE;
        }

        return r.getName();
    }

    /** getRoutineNameFromDate
     * @param year
     * @param dayOfYear
     * @return name of the routine that is scheduled on input date.
     */
    public String getRoutineNameFromDate(int year, int dayOfYear){
        Calendar c = new GregorianCalendar();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.DAY_OF_YEAR, dayOfYear);

        return getRoutineFromDay(c).getName();
    }

    /** getRoutineNameFromDate
     * @param year
     * @param month
     * @param dayOfMonth
     * @return name of the routine that is scheduled on input date.
     */
    public String getRoutineNameFromDate(int year, int month, int dayOfMonth){
        Calendar c = new GregorianCalendar();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        return getRoutineNameFromDate(c);
    }

    public int getYearToday() {
        return calendar.get(Calendar.YEAR);
    }

    public int getMonthToday() {
        return calendar.get(Calendar.MONTH);
    }

    public int getDayOfYearToday(){
        return calendar.get(Calendar.DAY_OF_YEAR);
    }

    public int getDayOfMonthToday() {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public String getTextNoRoutineScheduled(){
        return NO_ROUTINE_SCHEDULED_ON_DATE;
    }
}

