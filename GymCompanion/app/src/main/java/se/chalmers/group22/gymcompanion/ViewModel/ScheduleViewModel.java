package se.chalmers.group22.gymcompanion.ViewModel;

import se.chalmers.group22.gymcompanion.Model.ISchedule;
import se.chalmers.group22.gymcompanion.Model.Routine;

import java.util.*;

public class ScheduleViewModel extends BaseViewModel {
    private Map<Calendar, Routine> calendarRoutineMap;
    private ISchedule schedule;
    private int selectedYear;
    private int selectedMonth;
    private int selectedDay;
    private String selectedRoutineName = "";

    private final String buttonBookTextScheduledDate = "Change routine";
    private final String buttonBookTextEmptyDate = "Book routine";

    public ScheduleViewModel(){
        calendarRoutineMap = getModel().getUserRoutineSchedule();
        schedule = getModel().getUserSchedule();
    }


    /** scheduleSelectedRoutine
     * Purpose: Schedule the selected routine on the selected day.
     */
    public void scheduleSelectedRoutine(){
        Calendar day = new GregorianCalendar();
        day.set(selectedYear, selectedMonth, selectedDay);

        if (getModel().isScheduled(day)){
            getModel().scheduleRoutine(day, selectedRoutineName);
        }
    }

    /**--------------------------------------------------------------*/
    /**                         SETTERS                              */
    /**--------------------------------------------------------------*/

    public void setDate(int year, int month, int day){
        selectedYear = year;
        selectedMonth = month;
        selectedDay = day;
    }

    public void setRoutine(String routineName){
        selectedRoutineName = routineName;
    }

    /**--------------------------------------------------------------*/
    /**                         GETTERS                              */
    /**--------------------------------------------------------------*/
    public String getSelectedDateRoutineName(){
        return selectedRoutineName;
    }

    public String getToday(){
        return getModel().getTodaysDate();
    }

    /** getSelectedDate
     * @return selected date formatted as String
     */
    public String getSelectedDate(){
        StringBuilder sb = new StringBuilder();

        sb.append(selectedYear);
        sb.append("-");

        if (selectedMonth < 10) {
            sb.append("0");
        }

        sb.append(selectedMonth);
        sb.append("-");

        if (selectedDay < 10) {
            sb.append("0");
        }

        sb.append(selectedDay);
        return sb.toString();
    }

    public String getBookingButtonText(){
        if (selectedRoutineName.length() < 2)
            return buttonBookTextEmptyDate;
        return buttonBookTextScheduledDate;
    }
}
