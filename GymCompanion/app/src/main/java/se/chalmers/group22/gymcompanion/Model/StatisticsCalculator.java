package se.chalmers.group22.gymcompanion.Model;


import se.chalmers.group22.gymcompanion.Enums.INTENSITY;
import se.chalmers.group22.gymcompanion.Model.Exercises.CardioExercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.StrengthExercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.TimedExercise;

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

    public double calculateStrengthExercise(StrengthExercise exercise){
        return exercise.getSets()*exercise.getKilograms()*exercise.getRepetitions();
    }

    public double calculateTimedExercise(TimedExercise exercise){
        if (exercise.getIntensity() == INTENSITY.LOW){
            return exercise.getTimespent();
        }
        else if(exercise.getIntensity() == INTENSITY.MEDIUM){
            return exercise.getTimespent()*1.3;
        }
        else {
            return exercise.getTimespent()*1.6;
        }
    }


}
