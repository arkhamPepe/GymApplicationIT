package se.chalmers.group22.gymcompanion.ViewModel;

import se.chalmers.group22.gymcompanion.Model.Routine;
import java.util.*;

public class ScheduleViewModel extends BaseViewModel {
    private int selectedYear; // Year of selected date
    private int selectedMonth; // Month of selected date
    private int selectedDay; // Day of selected date

    private final String buttonBookTextScheduledDate = "Change routine";
    private final String buttonBookTextEmptyDate = "Book routine";

    private List<Routine> routines; // Gets updated when the owner of this dies (fragment or activity)

    /** ScheduleViewModel
     * Purpose: Select today as selected date
     */
    public ScheduleViewModel(){
        selectedYear = getModel().getYearToday();
        selectedMonth = getModel().getMonthToday();
        selectedDay = getModel().getDayToday();

        routines = getModel().getUserRoutines();
    }

    /** scheduleSelectedRoutine
     * Purpose: Schedule the selected routine on the selected day.
     */
    public void scheduleSelectedRoutine(String routineName){
        getModel().scheduleRoutine(getSelectedDate(), routineName);

        int x = new GregorianCalendar().get(Calendar.DAY_OF_MONTH);
        int y = new GregorianCalendar().get(Calendar.YEAR);

        if (selectedDay == x &&
                selectedYear == y){
            getModel().setActiveRoutine(getModel().getRoutineFromName(routineName));
        }
    }

    /** isSelectedDateBooked
     * Purpose: Helper method
     * @return true if the currently selected date has a scheduled routine
     */
    private boolean isSelectedDateBooked(){
        return getModel().isScheduled(getSelectedDate());
    }

    /**--------------------------------------------------------------*/
    /**                         SETTERS                              */
    /**--------------------------------------------------------------*/

    /** setSelectedDate
     * Purpose: Make input date the new selected date
     * @param year
     * @param month
     * @param day
     */
    public void setSelectedDate(int year, int month, int day){
        selectedYear = year;
        selectedMonth = month;
        selectedDay = day;
    }

    /**--------------------------------------------------------------*/
    /**                         GETTERS                              */
    /**--------------------------------------------------------------*/

    /** getSelectedDate
     * Purpose: Helper method
     * @return
     */
    private Calendar getSelectedDate(){
        Calendar date = new GregorianCalendar();
        date.set(Calendar.YEAR, selectedYear);
        date.set(Calendar.MONTH, selectedMonth);
        date.set(Calendar.DAY_OF_MONTH, selectedDay);

        return date;
    }

    /** getSelectedDateRoutineName
     * @return the name of the routine that is scheduled on the currently selected date
     */
    public String getSelectedDateRoutineName(){
        return getModel().getRoutineNameOnDate(selectedYear, selectedMonth, selectedDay);
    }

    /** getDateText
     * @param year
     * @param month
     * @param day
     * @return the date corresponding to the input year, month and day as text
     */
    public String getDateText(int year, int month, int day){
        return getModel().getDateText(year, month, day);
    }

    /** getTodayText
     * @return the date of today as text
     */
    public String getTodayText(){
        return getModel().getTodayText();
    }

    /** getSelectedDateText
     * @return the date of the currently selected date as text
     */
    public String getSelectedDateText(){
        return getModel().getDateText(selectedYear, selectedMonth, selectedDay);
    } // Might be useful if other fragments in ScheduleActivity wants to get the date of selected date without knowing exactly what the selected date is

    /** getBookingButtonText
     * @return the text for the booking button
     */
    public String getBookingButtonText(){
        if (isSelectedDateBooked())
            return buttonBookTextEmptyDate;
        return buttonBookTextScheduledDate;
    }

    /** getRoutineNames
     * @return all the names of the routines to be displayed in order
     */
    public List<String> getRoutineNames(){
        List<String> names = new ArrayList<>();

        for (Routine r : routines){
            names.add(r.getName());
        }

        return names;
    }

    /** getRoutineNames
     * @return the difficulties of the routines to be displayed in order
     */
    public List<Double> getRoutineDifficulties(){
        List<Double> difficulties = new ArrayList<>();

        for (Routine r : routines){
            difficulties.add(getModel().getRoutineDifficulty(r));
        }

        return difficulties;
    }

    /** getRoutineExercisesAmounts
     * @return the amount of exercises for each routine to be displayed in order
     */
    public List<Integer> getRoutineExercisesAmounts(){
        List<Integer> amounts = new ArrayList<>();

        for (Routine r : routines){
            amounts.add(r.getExercises().size());
        }

        return amounts;
    }
}
