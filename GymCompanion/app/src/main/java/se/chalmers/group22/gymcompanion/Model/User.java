package se.chalmers.group22.gymcompanion.Model;

import lombok.Getter;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Getter
public class User implements Serializable {

    private List<User> friends;
    private List<Routine> routines;
    private String name;
    private String gym;
    private int age;
    private int weight;
    private boolean isBeginner;
    private boolean isRoutineActive;

    private Routine activeRoutine;
    private StatisticsCalculator statCalc;
    private Schedule schedule;


    public User(List<User> friends, List<Routine> routines, String name, String gym, int age, int weight, boolean isBeginner){
        this.friends = friends;
        this.routines = routines;
        this.name = name;
        this.gym = gym;
        this.age = age;
        this.weight = weight;
        this.isBeginner = isBeginner;
        this.isRoutineActive = false;
        this.schedule = new Schedule();
        this.statCalc = new StatisticsCalculator(schedule);
    }

    public User(String name, String gym, int age, int weight, boolean isBeginner){
        this.friends = new ArrayList<>();
        this.routines = new ArrayList<>();
        this.age = age;
        this.weight = weight;
        this.isBeginner = isBeginner;
        this.isRoutineActive = false;
        this.schedule = new Schedule();
        this.statCalc = new StatisticsCalculator(schedule);
    }

    public void startRoutine(Routine routine){
       /*TODO Start the routine for the current day*/
        isRoutineActive = true;
        activeRoutine = routine;
        /*TODO redirect to "Workout in progress"-page*/
    }

    public void endActiveRoutine(){
        activeRoutine = null;
        isRoutineActive = false;
    }

    public void checkDay(){
        Calendar today = Calendar.getInstance();
        if (schedule.dayHasRoutine(today)){
            startRoutine(schedule.getRoutine(today));
        }
        else {
            /*TODO Direct the user to MR so it can create a new routine*/
        }
    }

    public void createRoutine(){
        routines.add(new Routine());
    }

    public void addExerciseToRoutine(Exercise exercise, Routine routine){
        routine.addExercise(exercise);
    }

    public void modifyRoutineDescription(Routine routine, String description){
        routine.setDescription(description);
    }


}
