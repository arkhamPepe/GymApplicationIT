package se.chalmers.group22.gymcompanion.ViewModel;

import com.jjoe64.graphview.series.DataPoint;
import se.chalmers.group22.gymcompanion.Model.Routine;

import java.util.*;

public class StatisticsViewModel extends ObservableViewModel {
    private Map<Calendar, Routine> schedule;
    private Calendar graphedDate; // The date from which the graph is displaying data
    private int currentWeekOffset = 0;
    private Map<Calendar, Double> currentGraphPoints;

    public StatisticsViewModel(){
        schedule = new HashMap<>();
        graphedDate = new GregorianCalendar();
        update();
    }

    public void update(){
        currentGraphPoints = getModel().getGraphData(graphedDate, currentWeekOffset);
        notifyObservers();
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