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
    private List<Routine> routinesWeek;
    private ISchedule schedule;

    public ScheduleViewModel(){
        relativeWeek = 0;
        calendarRoutineMap = getModel().getUserRoutineSchedule();
        schedule = getModel().getUserSchedule();
    }


    private void getRoutinesWeek(){
        List<Routine> list = new ArrayList<>();
        int displayedWeek = getDisplayedWeek();
        String[] routineNamesOnDay = new String[7];

        // For every day in selected week add scheduled routine if existing
        for (int i = 0; i < routineNamesOnDay.length; i++){
            /* TODO Get all scheduled routines */
        }

        routinesWeek = list;
    }


    public List<String> getRoutineNamesWeek(){
        /* TODO Make list with names of scheduled routines */
        return null;
    }

    private int getDisplayedWeek(){
        return (Calendar.WEEK_OF_YEAR + relativeWeek) % 52;
    }

    /** getRoutineNamesNextWeek
     * Purpose: Selects displayed week of schedule to be the next in the calendar
     */
    public void selectNextWeek(){
        relativeWeek++;
    }

    /** getRoutineNamesNextWeek
     * Purpose: Selects displayed week of schedule to be the next in the calendar
     */
    public void selectPreviousWeek(){
        relativeWeek--;
    }
}
