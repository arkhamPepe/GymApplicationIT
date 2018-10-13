package se.chalmers.group22.gymcompanion.ViewModel;

import se.chalmers.group22.gymcompanion.Model.ISchedule;
import se.chalmers.group22.gymcompanion.Model.Routine;

import java.util.*;

public class ScheduleViewModel extends BaseViewModel {
    private int relativeWeek; // is zero if current week is displayed
    private Map<Calendar, Routine> calendarRoutineMap;
    private ISchedule schedule;
    private int selectedYear;
    private int selectedMonth;
    private int selectedDay;
    private String selectedRoutineName;

    public ScheduleViewModel(){
        relativeWeek = 0;
        calendarRoutineMap = getModel().getUserRoutineSchedule();
        schedule = getModel().getUserSchedule();
    }

    public String getToday(){
        return getModel().getTodaysDate();
    }

    /** getSelectedDate
     * Returns the selected date formatted as String
     * @return date formatted as String
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

    public void selectDate(int year, int month, int day){
        selectedYear = year;
        selectedMonth = month;
        selectedDay = day;
    }

    public void scheduleSelectedRoutine(){
        Calendar day = new GregorianCalendar();
        day.set(selectedYear, selectedMonth, selectedDay);

        if (getModel().isScheduled(day)){
            getModel().scheduleRoutine(day, selectedRoutineName);
        }
    }

    public void selectRoutine(String routineName){
        selectedRoutineName = routineName;
    }

    public String getSelectedDateRoutineName(){
        return selectedRoutineName;
    }
}
