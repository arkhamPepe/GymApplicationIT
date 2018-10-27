package se.chalmers.group22.gymcompanion.Model.Statistics;


import se.chalmers.group22.gymcompanion.Model.Schedule.Schedule;
import se.chalmers.group22.gymcompanion.Model.Workout.Exercises.Exercise;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/***
 * Title: StatisticsCalculator
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: September 27, 2018
 *
 * Purpose: Class for calculating statistics and graphs of workout data.
 * Used by: User.java
 * Uses: Schedule.java, Exercise.java
 */

public class StatisticsCalculator implements Serializable {
    private Schedule schedule;

    public StatisticsCalculator(Schedule schedule){
       this.schedule = schedule;
    }

    public Map<Calendar, Double> getGraphDataPoints(int weekOffset){

        Map<Calendar, Double> graphMap = new HashMap<>();
        Calendar iterableDate = new GregorianCalendar();
        double score;

        // Setting up the Calendar object used in loop
        iterableDate.add(Calendar.WEEK_OF_YEAR, weekOffset);
        iterableDate.set(Calendar.DAY_OF_WEEK, 1);

        for (int i = 0; i < 7; i++){
            score = 0;

            // Calculate score
            if(schedule.dateHasRoutine(iterableDate)){
                for (Exercise e : schedule.getRoutineFromDay(iterableDate).getExercises()){
                    score += e.calculateScore();
                }
            }

            // Save score with date
            Calendar copyIterableDate = new GregorianCalendar();
            copyIterableDate.set(Calendar.YEAR, iterableDate.get(Calendar.YEAR));
            copyIterableDate.set(Calendar.DAY_OF_YEAR, iterableDate.get(Calendar.DAY_OF_YEAR));
            graphMap.put(copyIterableDate, score);

            // Next day in calendar
            iterableDate.add(Calendar.DAY_OF_YEAR, 1);
        }

        return graphMap;
    }

}
