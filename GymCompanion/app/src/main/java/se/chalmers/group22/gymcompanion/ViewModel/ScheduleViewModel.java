package se.chalmers.group22.gymcompanion.ViewModel;

import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.StrengthExercise;
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

    // TEMPORARY
    private List<Routine> routines = new ArrayList<>();
    private List<Exercise> exercises1 = new ArrayList<>();
    private List<Exercise> exercises2 = new ArrayList<>();
    private List<Exercise> exercises3 = new ArrayList<>();

    public ScheduleViewModel(){
        calendarRoutineMap = getModel().getUserRoutineSchedule();
        schedule = getModel().getUserSchedule();

        // TEMPORARY
        exercises1.add(new StrengthExercise("Bench press", 2));
        exercises1.add(new StrengthExercise("Incline bench press", 2));
        exercises1.add(new StrengthExercise("Incline flies", 2));

        exercises2.add(new StrengthExercise("Squats", 3));
        exercises2.add(new StrengthExercise("Deadlifts", 5));
        exercises2.add(new StrengthExercise("Hamstring curls", 2));
        exercises2.add(new StrengthExercise("Calf raises", 1));

        exercises3.add(new StrengthExercise("Pull-ups", 3));
        exercises3.add(new StrengthExercise("Rows", 2));


        routines.add(new Routine("Chest ripper", exercises1));
        routines.add(new Routine("Leg breaker", exercises2));
        routines.add(new Routine("Back attack", exercises3));
    }


    /** scheduleSelectedRoutine
     * Purpose: Schedule the selected routine on the selected day.
     * @return true if routine got scheduled.
     */
    public boolean scheduleSelectedRoutine(){
        Calendar day = new GregorianCalendar();
        day.set(selectedYear, selectedMonth, selectedDay);

        if (getModel().isScheduled(day)){
            getModel().scheduleRoutine(day, selectedRoutineName);
            return false;
        }

        if (getModel().isScheduled(day))
            return true;

        return false;
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

    public List<String> getRoutineNames(){
        List<String> names = new ArrayList<>();

        for (Routine r : routines){
            names.add(r.getName());
        }

        return names;
    }

    public List<Double> getRoutineDifficulties(){
        List<Double> difficulties = new ArrayList<>();

        for (Routine r : routines){
            difficulties.add(getModel().getRoutineDifficulty(r));
        }

        return difficulties;
    }

    public List<Integer> getRoutineExercisesAmounts(){
        List<Integer> amounts = new ArrayList<>();

        for (Routine r : routines){
            amounts.add(r.getExercises().size());
        }

        return amounts;
    }
}
