package se.chalmers.group22.gymcompanion.Model;

import lombok.AccessLevel;
import lombok.Getter;
import se.chalmers.group22.gymcompanion.Model.Exercises.CardioExercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;

import java.io.Serializable;
import java.util.*;

@Getter
public class User implements Serializable {

    @Getter(AccessLevel.NONE)
    private List<User> friends;

    @Getter(AccessLevel.NONE)
    private List<Routine> routines;

    @Getter(AccessLevel.NONE)
    private Map<Calendar, Routine> completedRoutines;


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
        this.completedRoutines = new HashMap<>();
    }

    public User(String name, String gym, int age, int weight, boolean isBeginner){
        this.name = name;
        this.gym = gym;
        this.friends = new ArrayList<>();
        this.routines = new ArrayList<>();
        this.age = age;
        this.weight = weight;
        this.isBeginner = isBeginner;
        this.schedule = new Schedule();
        this.statCalc = new StatisticsCalculator(schedule);
        this.completedRoutines = new HashMap<>();
    }

    // Defensive copy
    public List<User> getFriends() {
        return new ArrayList<>(friends);
    }

    // Defensive copy
    public List<Routine> getRoutines() {
        return new ArrayList<>(routines);
    }

    // Defensive Copy
    public Map<Calendar, Routine> getCompletedRoutines(){
        return new HashMap<>(completedRoutines);
    }

    public void finishRoutine(Routine routine){
        completedRoutines.put(Calendar.getInstance(), routine);
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

    public String getScheduledRoutineName(){
        return schedule.getRoutineNameFromDate(getTodaysDate());
    }

    public Routine getTodaysRoutine(){
        return schedule.getRoutineFromDay(getTodaysDate());
    }

    public boolean scheduleDayHasRoutine(Calendar date){
        return schedule.dateHasRoutine(date);
    }

    public Routine getScheduleRoutineFromDay(Calendar date){
        return schedule.getRoutineFromDay(date);
    }

    public Routine getFinishedRoutine() {
        Routine latestFinishedRoutine = null;
        Calendar latestDate = null;
        for(Calendar day : completedRoutines.keySet()){
            if(latestDate == null || day.after(latestDate)){
                latestDate = day;
                latestFinishedRoutine = completedRoutines.get(day);
            }
        }
        return latestFinishedRoutine;
    }

    public ISchedule getSchedule(){
        return schedule;
    }

    public String getToday(){
        return schedule.getToday();
    }

    public Map<Calendar, Routine> getRoutineSchedule(){
        return schedule.getSchedule();
    }

    public String getRoutineNameOnDate(int year, int day){
        return schedule.getRoutineNameFromDate(year, day);
    }

    public int getYearToday() {
        return schedule.getYearToday();
    }

    public int getMonthToday() {
        return schedule.getMonthToday();
    }

    public int getDayToday() {
        return schedule.getDayOfMonthToday();
    }

    public Set<Calendar> getScheduleKeySet(){
        return schedule.getScheduleKeySet();
    }

    public Routine getRoutineFromDay(Calendar day){
        return schedule.getRoutineFromDay(day);
    }

}
