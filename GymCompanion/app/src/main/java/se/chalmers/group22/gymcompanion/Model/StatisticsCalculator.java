package se.chalmers.group22.gymcompanion.Model;


import se.chalmers.group22.gymcompanion.Enums.INTENSITY;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.StrengthExercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.TimedExercise;

import java.io.Serializable;
import java.util.*;

public class StatisticsCalculator implements Serializable {
    private User user;
    private Schedule schedule;

    public StatisticsCalculator(Schedule schedule){
       this.schedule = schedule;
    }

    public Map<Calendar, Exercise> getSpecificExercise(Exercise specificExercise){
        Map<Calendar, Exercise> specificExerciseMap = new HashMap<>();
        for(Calendar day : schedule.getScheduleKeySet()){
            Routine r = schedule.getRoutineFromDay(day);
            for(Exercise exercise : r.getExercises()){
                if(exercise.getName().equals(specificExercise.getName())){
                    specificExerciseMap.put(day, exercise);
                }
            }
        }
        return specificExerciseMap;
    }

    public double calculateScore(StrengthExercise exercise){
        double sum = 0;
        int kgIndex = 0;
        for (Integer repetition: exercise.getRepetitions()){
            sum += repetition * exercise.getKilograms().get(kgIndex);
            kgIndex++;
        }
        return sum;
    }

    public double calculateScore(TimedExercise exercise) {
        if (exercise.getIntensity() == INTENSITY.LOW) {
            return exercise.getTimespent() * 0.25;
        } else if (exercise.getIntensity() == INTENSITY.MEDIUM) {
            return exercise.getTimespent() * 0.5;
        } else {
            return exercise.getTimespent() * 0.75;
        }
    }

}
