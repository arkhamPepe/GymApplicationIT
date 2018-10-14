package se.chalmers.group22.gymcompanion.Model;

import lombok.AccessLevel;
import lombok.Getter;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Getter
public class User implements Serializable {

    @Getter(AccessLevel.NONE)
    private List<User> friends;

    @Getter(AccessLevel.NONE)
    private List<Routine> routines;


    private String name;
    private String gym;
    private int age;
    private int weight;
    private boolean isBeginner;


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
        this.schedule = new Schedule();
        this.statCalc = new StatisticsCalculator(schedule);
    }

    public User(String name, String gym, int age, int weight, boolean isBeginner){
        this.friends = new ArrayList<>();
        this.routines = new ArrayList<>();
        this.age = age;
        this.weight = weight;
        this.isBeginner = isBeginner;
        this.schedule = new Schedule();
        this.statCalc = new StatisticsCalculator(schedule);
    }

    // Defensive copy
    public List<User> getFriends() {
        return new ArrayList<>(friends);
    }

    // Defensive copy
    public List<Routine> getRoutines() {
        return new ArrayList<>(routines);
    }

    public void addFriend(User friend){
        friends.add(friend);
    }

    public void removeFriend(User friend){
        friends.remove(friend);
    }

    public void addRoutine(Routine routine){
        routines.add(routine);
    }

    public void removeRoutine(Routine routine){
        routines.remove(routine);
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


    private Calendar getTodaysDate(){
        return Calendar.getInstance();
    }

    public String getTodaysRoutineName(){
        return schedule.getRoutineNameFromDay(getTodaysDate());
    }

    public Routine getTodaysRoutine(){
        return schedule.getRoutineFromDay(getTodaysDate());
    }

    public boolean scheduleDayHasRoutine(Calendar day){
        return schedule.dayHasRoutine(day);
    }

    public Routine getSchedulRoutineFromDay(Calendar day){
        return schedule.getRoutineFromDay(day);
    }

}
