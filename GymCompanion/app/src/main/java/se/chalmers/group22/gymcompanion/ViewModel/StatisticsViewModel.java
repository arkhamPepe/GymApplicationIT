package se.chalmers.group22.gymcompanion.ViewModel;

import com.jjoe64.graphview.series.DataPoint;
import se.chalmers.group22.gymcompanion.Model.Workout.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Workout.Routine;

import java.util.*;
/***
 * Title: StatisticsViewModel
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 12, 2018
 *
 * Purpose: To handle the communication between the model and the view without without showing the model's underlying
 * representation to the view.
 *
 * Used by: StatisticsActivity.java, StatisticsHistoryDetailsFragment.java, StatisticsHistoryFragment.java
 * StatisticsLifetimeStatsFragment.java, StatisticsStartFragment.java,
 *
 * Uses: AbstractObservableViewModel.java, Point.java (nested class), Routine.java, Exercise.java
 *
 */
public class StatisticsViewModel extends AbstractObservableViewModel {
    private Map<Calendar, Routine> completedRoutines;
    private int currentWeekOffset = 0;
    private Map<Calendar, Double> currentGraphPoints;
    private Calendar selectedDate;
    String[] strDays = new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };

    public StatisticsViewModel(){
        completedRoutines = getModel().getUserCompletedRoutines();
        updateGraph();
    }

    public void updateGraph(){
        currentGraphPoints = getModel().getGraphData(currentWeekOffset);
    }

    public void setSelectedDate(Calendar time){
        selectedDate = time;
        notifyObservers();
    }

    public void setGraphedDateNextWeek(){
        currentWeekOffset++;
        updateGraph();
        notifyObservers();
    }

    public void setGraphedDatePreviousWeek(){
        currentWeekOffset--;
        updateGraph();
        notifyObservers();
    }

    public DataPoint[] getDataPoints(){
        int size = 0;
        size = currentGraphPoints.size();

        DataPoint[] dataPoints = new DataPoint[size];

        long xValue;
        double yValue;

        List<Point> points = new ArrayList<>();

        for (Calendar c : currentGraphPoints.keySet()){
            xValue = c.getTimeInMillis();
            yValue = currentGraphPoints.get(c);
            points.add(new Point(xValue, yValue));
        }

        sortPoints(points);

        int index = 0;
        for (Point p : points){
            dataPoints[index] = new DataPoint(p.getX(), p.getY());
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

    @Override
    public void updateView() {
        updateGraph();
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

    public List<String> getHistoryExerciseNames(){
        List<String> names = new ArrayList<>();
        List<Exercise> exercises = new ArrayList<>();

        if (selectedDate != null) {
            exercises = completedRoutines.get(selectedDate).getExercises();
        }

        for(Exercise e : exercises){
            names.add(e.getName());
        }

        return names;
    }

    public String getDisplayedWeek(){
        Calendar cal = new GregorianCalendar();
        cal.add(Calendar.WEEK_OF_YEAR, currentWeekOffset);

        StringBuilder sb = new StringBuilder();
        sb.append("Week ");
        sb.append(cal.get(Calendar.WEEK_OF_YEAR));

        return sb.toString();
    }

    public List<Boolean> getHistoryExercisePerformedValues(){
        List<Boolean> performances = new ArrayList<>();
        List<Exercise> exercises = new ArrayList<>();

        if (selectedDate != null) {
            exercises = completedRoutines.get(selectedDate).getExercises();
        }

        for(Exercise e : exercises) {
            performances.add(e.isCompleted());
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

    public List<Calendar> getRoutineDates(){
        List<Calendar> dates = new ArrayList<>();

        for(Calendar c : getDates()){
            dates.add(c);
        }

        return dates;
    }

    public List<String> getRoutineDatesFormatted(){
        List<String> dateNames = new ArrayList<>();

        for(Calendar c : getDates()){
            StringBuilder sb = new StringBuilder();

            sb.append("Week " + c.get(Calendar.WEEK_OF_YEAR));
            sb.append(" " + strDays[c.get(Calendar.DAY_OF_WEEK)-1]);
            sb.append(" " + ((2 + c.get(Calendar.HOUR_OF_DAY)) % 24) + ":");

            int min = c.get(Calendar.MINUTE);
            if (min < 10)
                sb.append("0");
            sb.append(min);
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
/*    private TreeMap<Calendar, Routine> getRoutineHistory(Calendar c) {
        Date toDate = Calendar.getInstance().getTime();
        Date fromDate = c.getTime();
        for(Calendar day : getModel().getScheduleKeyset()) {
            if (toDate.compareTo(day.getTime()) >= 0 || fromDate.compareTo(day.getTime()) < 0) {
                schedule.put(day, getModel().getRoutineFromDay(day));
            }
        }
        return new TreeMap<>(schedule);
    }*/

    /**
     * @return Routine names between current date and a given date
     */
    /*private List<String> getRoutineNames(Calendar c){
        Map<Calendar, Routine> s = getRoutineHistory(c);
        List<String> routineNames = new ArrayList<>();
        for(Routine r : s.values()){
            routineNames.add(r.getName());
        }
        return routineNames;
    }*/

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
}