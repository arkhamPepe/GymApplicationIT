package se.chalmers.group22.gymcompanion.Model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Getter
public class User {

    private List<User> friends;
    private List<Routine> routines;
    private List<CompletedRoutine> completedRoutines;
    private String name;
    private String gym;
    private int age;
    private int weight;
    private boolean isBeginner;
    private boolean routineActive;

    private ActiveRoutine activeRoutine;
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
        this.routineActive = false;
        this.schedule = new Schedule();
        this.statCalc = new StatisticsCalculator(completedRoutines);
        completedRoutines = new ArrayList<>();
    }

    public void startRoutine(Routine routine, Day day){
       /*TODO Start the routine for the current day*/
        activeRoutine = new ActiveRoutine(routine,day);
        routineActive= true;
        /*TODO redirect to "Workout in progress"-page*/

    }

    public void endActiveRoutine(){
        if(activeRoutine != null){
            completedRoutines.add(activeRoutine.finishRoutine());

        }
        activeRoutine = null;
        routineActive = false;
    }

    public void checkDay(){
        Day today = new Day(Calendar.WEEK_OF_YEAR, Calendar.DAY_OF_WEEK);
        if (schedule.dayHasRoutine(today)){
            startRoutine(schedule.getRoutine(today),today);
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
