package se.chalmers.group22.gymcompanion.ViewModel;

import se.chalmers.group22.gymcompanion.Model.ISchedule;
import se.chalmers.group22.gymcompanion.Model.Routine;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class ScheduleViewModel extends BaseViewModel {
    private int relativeWeek; // is zero if current week is displayed
    private Map<Calendar, Routine> calendarRoutineMap;
    private ISchedule schedule;

    public ScheduleViewModel(){
        relativeWeek = 0;
        calendarRoutineMap = getModel().getUserRoutineSchedule();
        schedule = getModel().getUserSchedule();
    }

    public String getToday(){
        return getModel().getTodaysDate();
    }

    /** getDateString
     * Helper method for formatting date to String.
     * @param year
     * @param month
     * @param day
     * @return date formatted as String
     */
    public String getDateString(int year, int month, int day){
        StringBuilder sb = new StringBuilder();

        sb.append(year);
        sb.append("-");

        if (month + 1 < 10) {
            sb.append("0");
        }

        sb.append(month + 1);
        sb.append("-");

        if (day < 10) {
            sb.append("0");
        }

        sb.append(day);
        return sb.toString();
    }
}
