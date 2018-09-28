package se.chalmers.group22.gymcompanion.Model;


import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import se.chalmers.group22.gymcompanion.Model.Exercises.CardioExercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;

import java.util.*;

public class StatisticsCalculator {
    private Schedule schedule;

    public StatisticsCalculator(Schedule schedule){
       this.schedule = schedule;
    }

    public Map<Calendar, Exercise> getSpecificExercise(Exercise specificExercise){
        Map<Calendar, Exercise> specificExerciseMap = new HashMap<>();
        for(Calendar day : schedule.getRoutineSchedule().keySet()){
            Routine r = schedule.getRoutineSchedule().get(day);
            for(Exercise exercise : r.getExercises()){
                if(exercise.equals(specificExercise)){
                    specificExerciseMap.put(day, exercise);
                }
            }
        }
        return specificExerciseMap;
    }




}
