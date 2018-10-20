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

        for (int i = 0; i < points.size()-1; i++)
            for (int j = 0; j < points.size()-i-1; j++)
                if (points.get(j).getX() > points.get(j+1).getX()){
                    temp = points.get(j);
                    points.set(j, points.get(j+1));
                    points.set(j+1, temp);
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