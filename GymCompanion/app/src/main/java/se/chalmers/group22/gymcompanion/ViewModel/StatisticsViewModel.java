package se.chalmers.group22.gymcompanion.ViewModel;

import com.jjoe64.graphview.series.DataPoint;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Routine;

import java.util.*;

public class StatisticsViewModel extends ObservableViewModel {
    private Map<Calendar, Routine> schedule;
    private Map<Calendar, Routine> completedRoutines;
    private int currentWeekOffset = 0;
    private Map<Calendar, Double> currentGraphPoints;
    private String selectedRoutine;
    String[] strDays = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thusday", "Friday", "Saturday" };

    public StatisticsViewModel(){
        schedule = new HashMap<>();
        update();
    }

    public void update(){
        currentGraphPoints = getModel().getGraphData(currentWeekOffset);
        completedRoutines = getModel().getUserCompletedRoutines();
        notifyObservers();
    }

    public void setSelectedRoutine(String routineName){
        selectedRoutine = routineName;
    }

    public void setGraphedDateNextWeek(){
        currentWeekOffset++;
        update();
    }

    public void setGraphedDatePreviousWeek(){
        currentWeekOffset--;
        update();
    }

    public DataPoint[] getDataPoints(){
        int size = 0;
        size = currentGraphPoints.size();

        DataPoint[] dataPoints = new DataPoint[size];
        int index = 0;
        long xValue;
        double yValue;

        List<Point> points = new ArrayList<>();

        for (Calendar c : currentGraphPoints.keySet()){
            xValue = c.getTime().getTime();
            yValue = currentGraphPoints.get(c);
            points.add(new Point(xValue, yValue));
        }

        sortPoints(points);

        for (Calendar c : currentGraphPoints.keySet()){
            Point point = points.get(index);
            dataPoints[index] = new DataPoint(point.getX(), point.getY());
            index++;
        }

        return dataPoints;
    }

    private void sortPoints(List<Point> points){
        Point temp;
        int min_idx;

        for (int i = 0; i < points.size()-1; i++)
        {
            // Find the minimum element in unsorted array
            min_idx = i;
            for (int j = i+1; j < points.size(); j++)
                if (points.get(j).getX() < points.get(min_idx).getX())
                    min_idx = j;

            // Swap the found minimum element with the first element
            temp = points.get(min_idx);
            points.set(min_idx, points.get(i));
            points.set(i, temp);
        }
    }

    private class Point {
        private double x;
        private double y;

        Point(double x, double y){
            this.x = x;
            this.y = y;
        }

        double getX(){
            return x;
        }
        double getY(){
            return y;
        }
    }

    /* TODO Control functionality when history is implemented */
    public List<String> getHistoryExerciseNames(){
        List<String> names = new ArrayList<>();

        try {
            for(Exercise e : getModel().getRoutineFromName(selectedRoutine).getExercises()){
                names.add(e.getName());
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return names;
    }

    /* TODO Control functionality when history is implemented */
    public List<Boolean> getHistoryExercisePerformedValues(){
        List<Boolean> performances = new ArrayList<>();

        try {
            for (Exercise e : getModel().getRoutineFromName(selectedRoutine).getExercises()) {
                performances.add(e.isCompleted());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return performances;
    }

    public List<String> getRoutineNames(){
        List<String> routineNames = new ArrayList<>();

        for(Calendar c : getDates()){
            routineNames.add(completedRoutines.get(c).getName());
        }
        return routineNames;
    }

    public List<String> getRoutineDates(){
        List<String> dateNames = new ArrayList<>();

        for(Calendar c : getDates()){
            StringBuilder sb = new StringBuilder();

            sb.append("Week " + c.get(Calendar.WEEK_OF_YEAR));
            sb.append(" " + strDays[c.get(Calendar.DAY_OF_WEEK)]);
            dateNames.add(sb.toString());
        }
        return dateNames;
    }

    private List<Calendar> getDates(){
        List<Calendar> dates = new ArrayList<>();

        for(Calendar c : completedRoutines.keySet()){
            dates.add(c);
        }
        Collections.reverse(dates);

        return dates;
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

    private List<String> getRoutineNamesWeek(){
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, -7);
        return getRoutineNames(cal);
    }

    private List<String> getRoutineNamesMonth(){
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, -1);
        return getRoutineNames(cal);
    }

    private List<String> getRoutineNamesYear(){
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