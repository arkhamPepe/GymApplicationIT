package se.chalmers.group22.gymcompanion.Model;


import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.StrengthExercise;

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

    public double calculateStrength(StrengthExercise exercise){
        return 1;
    }


}
