package se.chalmers.group22.gymcompanion.ViewModel;

import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Routine;

import java.util.*;

public class StatisticsViewModel extends ObservableViewModel {


    private Map<Calendar, Routine> schedule;
    private Calendar graphedDate; // The date from which the graph is displaying data

    public StatisticsViewModel(){
        schedule = new HashMap<>();
        graphedDate = new GregorianCalendar();
    }

    public void setGraphedDateNextWeek(){
        graphedDate.set(Calendar.WEEK_OF_YEAR, Calendar.WEEK_OF_YEAR + 1);
        notifyObservers();
    }

    public void setGraphedDatePreviousWeek(){
        graphedDate.set(Calendar.WEEK_OF_YEAR, Calendar.WEEK_OF_YEAR + 1);
        notifyObservers();
    }

    /**
     * Purpose: Gets all routines performed from a given date to the current date
     * @return treemap of all routines between a given date and current date
     */
    private TreeMap<Calendar, Routine> getRoutineHistory(Calendar c) {
        Date toDate = Calendar.getInstance().getTime();
        Date fromDate = c.getTime();
        for(Calendar day : getModel().getScheduleKeyset()) {
            if (toDate.compareTo(day.getTime()) >= 0 || fromDate.compareTo(day.getTime()) < 0) {
                schedule.put(day, getModel().getRoutineFromDay(day));
            }
        }
        return new TreeMap<>(schedule);
    }

    /**
     * @return Routine names between current date and a given date
     */
    private List<String> getRoutineNames(Calendar c){
        Map<Calendar, Routine> s = getRoutineHistory(c);
        List<String> routineNames = new ArrayList<>();
        for(Routine r : s.values()){
            routineNames.add(r.getName());
        }
        return routineNames;
    }

    public Map<Calendar, Double> getGraphData(Calendar date, int weekOffset){
        return getModel().getGraphData(date, weekOffset);
    }

    public int getTotalAmountOfCompletedRoutines(){
        return getModel().getTotalAmountOfCompletedRoutines();
    }

    public int getTotalAmountOfCompletedExercises(){
        return getModel().getTotalAmountOfCompletedExercises();
    }

    public String getFavouriteRoutineName(){
        return getModel().getFavouriteRoutineName();
    }

    public String getFavouriteExerciseName(){
        return getModel().getFavouriteExerciseName();
    }

    public String getBiggestCompletedRoutineName(){
        return getModel().getBiggestCompletedRoutineName();
    }

    public List<String> getRoutineNamesWeek(){
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, -7);
        return getRoutineNames(cal);
    }

    public List<String> getRoutineNamesMonth(){
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, -1);
        return getRoutineNames(cal);
    }

    public List<String> getRoutineNamesYear(){
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        cal.add(Calendar.YEAR, -1);
        return getRoutineNames(cal);
    }

    public List<String> getSelectedRoutineExerciseNames(){

        return null;
    }

    public List<List<Integer>> getSelectedRoutineExerciseReps(){
        return null;
    }

    public List<List<Double>> getSelectedRoutineExerciseWeight(){
        return null;
    }
}