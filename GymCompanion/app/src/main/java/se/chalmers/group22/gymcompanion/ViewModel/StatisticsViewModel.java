package se.chalmers.group22.gymcompanion.ViewModel;

import se.chalmers.group22.gymcompanion.Model.DataHandler;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Routine;
import se.chalmers.group22.gymcompanion.Model.Schedule;

import java.time.LocalDate;
import java.util.*;

public class StatisticsViewModel {

    private DataHandler dataHandler;

    private List<Routine> routines;
    private List<Exercise> exercises;
    private Map<Calendar, Routine> schedule;

    public StatisticsViewModel(){
        this.dataHandler = DataHandler.getInstance();
        this.routines = new ArrayList<>();
        this.exercises = new ArrayList<>();
        this.schedule = new HashMap<>();
    }

    /**
     * Purpose: Gets all routines performed from a given date to the current date
     * @return treemap of all routines between a given date and current date
     */
    private TreeMap<Calendar, Routine> getRoutineHistory(Calendar c) {
        Date toDate = Calendar.getInstance().getTime();
        Date fromDate = c.getTime();
        for(Calendar cur : dataHandler.getRoutineSchedule().keySet()) {
            if (toDate.compareTo(cur.getTime()) >= 0 || fromDate.compareTo(cur.getTime()) < 0) {
                schedule.put(cur, dataHandler.getRoutineSchedule().get(cur));
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