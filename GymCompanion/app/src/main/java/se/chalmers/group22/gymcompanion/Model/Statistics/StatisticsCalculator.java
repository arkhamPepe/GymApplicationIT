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
 * Uses: Schedule.java, Exercise.java, Routine.java
 */

public class StatisticsCalculator implements Serializable {
    private Schedule schedule;

    public StatisticsCalculator(Schedule schedule){
       this.schedule = schedule;
    }

    public Map<Calendar, Double> getGraphDataPoints(int weekOffset){

        Map<Calendar, Double> graphMap = new HashMap<>();
        Calendar today = new GregorianCalendar();
        double score;

        for (int i = 6; i >= 0; i--){
            score = 0;

            Calendar cal = new GregorianCalendar();
            cal.add(Calendar.DAY_OF_YEAR, (i-today.get(Calendar.DAY_OF_WEEK)) + (7 * weekOffset));
            if(schedule.dateHasRoutine(cal)){

                for (Exercise e : schedule.getRoutineFromDay(cal).getExercises()){
                    score += e.calculateScore();
                }
            }

            graphMap.put(cal, score);
        }

        return graphMap;
    }



}
