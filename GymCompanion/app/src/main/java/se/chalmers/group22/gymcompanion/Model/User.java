package se.chalmers.group22.gymcompanion.Model;

import lombok.AccessLevel;
import lombok.Getter;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;

import java.io.Serializable;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/***
 * Title: User
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: 21 September, 2018
 *
 * Purpose: Class for handling overall User related actions and data.
 */


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
        completedRoutines.put(getTodaysDate(), routine);
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

    public void scheduleAddRoutine(Routine routine, Calendar date){
        schedule.addRoutine(routine, date);
    }

    public ISchedule getSchedule(){
        return schedule;
    }

    public String getScheduleDateText(int year, int month, int day){
        return schedule.getDateText(year, month, day);
    }

    public String getTodayText(){
        return schedule.getTodayText();
    }

    public Map<Calendar, Routine> getRoutineSchedule(){
        return schedule.getSchedule();
    }

    public String getRoutineNameOnDate(int year, int month, int day){
        return schedule.getRoutineNameFromDate(year, month, day);
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

    public int getTotalAmountOfCompletedRoutines(){
        return completedRoutines.size();
    }

    public int getTotalAmountOfCompletedExercises(){
        int amount = 0;

        for (Routine r: completedRoutines.values()){
            amount += r.getExercises().size();
        }

        return amount;
    }

    public String getFavouriteRoutineName(){
        List<String> strList = new ArrayList<>();

        for (Routine r:completedRoutines.values()) {
            strList.add(r.getName());
        }

        return findMostCommonName(strList);
    }

    public String getFavouriteExerciseName(){
        List<String> strList = new ArrayList<>();

        for (Routine r:completedRoutines.values()) {
            for (Exercise e:r.getExercises()) {
                strList.add(e.getName());
            }
        }

        return findMostCommonName(strList);
    }

    private String findMostCommonName(List<String> strList){
        Map<String,Long> ocurrences = strList.stream().collect(Collectors.groupingBy(w->w, Collectors.counting()));
        long biggest = 0;

        if(ocurrences.isEmpty()){
            return "No Favourite";
        }

        for (long i:ocurrences.values()) {
            if(i>biggest){
                biggest = i;
            }
        }

        for (String str:ocurrences.keySet()) {
            if(ocurrences.get(str)==biggest){
                return str;
            }
        }

        return "Something went wrong";
    }

    public String getBiggestCompletedRoutineName(){
        Routine big = new Routine();
        boolean first = true;

        if(!completedRoutines.isEmpty()){
            for(Routine r: completedRoutines.values()){
                if(first){
                    big = r;
                    first = false;
                }else if(r.getExercises().size() > big.getExercises().size()){
                    big = r;
                }
            }
            return big.getName();
        }
        return "No Routines Completed";
    }

}
