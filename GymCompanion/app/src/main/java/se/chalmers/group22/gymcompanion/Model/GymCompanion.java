package se.chalmers.group22.gymcompanion.Model;

import lombok.Getter;
import lombok.Setter;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Model.Exercises.CardioExercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.StrengthExercise;
import se.chalmers.group22.gymcompanion.Model.Strategies.FilterStrategy.FilterStrategy;
import se.chalmers.group22.gymcompanion.Model.Strategies.SortingStrategy.SortingStrategy;




import java.util.*;

@Getter
public class GymCompanion {
    @Setter
    private User user;


    @Setter
    private Routine activeRoutine;
    private Exercise activeExercise;
    private boolean isRoutineActive;

    @Setter
    private List<Routine> routineList;

    @Setter
    private List<Exercise> exerciseList;

    public GymCompanion(){

    }

    public void startRoutine(){
        startRoutine(user.getTodaysRoutine());
    }

    public void startRoutine(Routine routine){
        /*TODO Start the routine for the current day*/
        isRoutineActive = true;
        activeRoutine = routine;
        /*TODO redirect to "Workout in progress"-page*/
    }

    //Active Routine Methods

    public void setActiveExerciseInActiveRoutine(int index){
        activeExercise = activeRoutine.getExercises().get(index);
    }

    public int getAmountOfExercisesInActiveRoutine(){
        if(activeRoutine == null)
        {
            return 0;
        }
        return activeRoutine.getExercises().size();
    }

    //Active Exercise Methods

    public String getActiveExerciseName(){
        return activeExercise.getName();
    }

    public boolean isActiveExerciseStrengthExercise(){
        return activeExercise instanceof StrengthExercise;
    }

    public int getAmountOfSetsInActiveExercise(){
        return ((StrengthExercise)activeExercise).getSets();
    }

    public int getTimeInActiveExercise(){
        return ((CardioExercise)activeExercise).getTimespent();
    }

    public int getAmountOfRepsFromActiveExerciseSetWithIndex(int index){
        return ((StrengthExercise)activeExercise).getRepetitions().get(index);
    }

    public double getAmountWeightFromActiveExerciseSetWithIndex(int index){
        return ((StrengthExercise)activeExercise).getKilograms().get(index);
    }


    //Schedule Methods

    public String getScheduledRoutineName(){
        return user.getScheduledRoutineName();
    }

    public Routine getFinishedRoutine() {
        return user.getFinishedRoutine();
    }

    public Map<Calendar, Routine> getUserRoutineSchedule(){
        return user.getRoutineSchedule();
    }

    public ISchedule getUserSchedule(){
        return user.getSchedule();
    }

    public String getDateText(int year, int month, int day){
        return user.getScheduleDateText(year, month, day);
    }

    public String getTodayText(){
        return user.getTodayText();
    }

    public int getYearToday() {
        return user.getYearToday();
    }

    public int getMonthToday() {
        return user.getMonthToday();
    }

    public int getDayToday() {
        return user.getDayToday();
    }

    public Set<Calendar> getScheduleKeyset(){
        return user.getScheduleKeySet();
    }

    public boolean isScheduled(Calendar day){
        return user.scheduleDayHasRoutine(day);
    }

    public void scheduleRoutine(Calendar day, String routineName){
        Routine routine = getRoutine(routineName);

        user.scheduleAddRoutine(routine, day);
    }


    //Routine creation and modification

    public void createRoutine(){
        user.createRoutine();
    }

    public void addExercise(Exercise exercise, Routine routine){
        user.addExerciseToRoutine(exercise, routine);
    }

    //Routine and Exercise Getters

    public List<ISortable> getRoutinesAndExercises(){
        List<ISortable> newList = new ArrayList<>();

        if(!(routineList == null || exerciseList == null)) {
            newList.addAll(routineList);
            newList.addAll(exerciseList);
        }

        return newList;
    }

    public String getRoutineNameOnDate(int year, int month, int day) {
        return user.getRoutineNameOnDate(year, month, day);
    }

    public Routine getRoutineFromDay(Calendar day){
        return user.getRoutineFromDay(day);
    }

    private Routine getRoutine(String routineName){
        for (Routine r : user.getRoutines()){
            if (r.getName().equals(routineName))
                return r;
        }
        return null;
    }

    public double getRoutineDifficulty(Routine routine){
        return routine.getAverageDifficulty();
    }

    public int getTotalAmountOfCompletedRoutines(){
        return user.getTotalAmountOfCompletedRoutines();
    }

    public List<Routine> getRoutines() {
            return user.getRoutines();
    }
    
    public int getTotalAmountOfCompletedExercises(){
        return user.getTotalAmountOfCompletedExercises();
    }

    public String getFavouriteRoutineName(){
        return user.getFavouriteRoutineName();
    }

    public String getFavouriteExerciseName(){
        return user.getFavouriteExerciseName();
    }

    public String getBiggestCompletedRoutineName(){
        return user.getBiggestCompletedRoutineName();
    }

    //Sorting, Filtering and Searching

    public void sort(List<? extends ISortable> list, SortingStrategy strat){
        strat.sort(list);
    }

    public <T extends ISortable> List<T> filter(List<T> toBeFiltered, FilterStrategy filter){
        List<T> newList = new ArrayList<>(toBeFiltered);
        return filter.filter(newList);
    }

    public <T extends ISortable> List<T> filter(List<T> toBeFiltered, List<MUSCLE_GROUP> muscleGroups) {
        List<T> newList = new ArrayList<>(toBeFiltered);

        for (MUSCLE_GROUP mg : muscleGroups){
            for (T re : toBeFiltered) {
                if (re.containsMuscleGroup(mg) && !newList.contains(re)) {
                    newList.add(re);
                }
            }
        }
        return newList;
    }

    public <T extends ISortable> List<T> filterRoutines(List<T> toBeFiltered){
        List<T> newList = new ArrayList<>(toBeFiltered);
        newList.removeAll(exerciseList);
        return newList;
    }

    public <T extends ISortable> List<T> filterExercises(List<T> toBeFiltered){
        List<T> newList = new ArrayList<>(toBeFiltered);
        newList.removeAll(routineList);
        return newList;
    }

    public List<ISortable> search(String search){
        if (search.equals("")) {
            return getRoutinesAndExercises();
        }

        List<ISortable> newList = new ArrayList<>();

        for (ISortable re: getRoutinesAndExercises()) {
            if(search.toLowerCase().equals(re.getName().toLowerCase())){
                newList.add(re);
            }
        }

        for (ISortable re: getRoutinesAndExercises()) {
            if(!newList.contains(re) && re.getName().toLowerCase().startsWith(search.toLowerCase())){
                newList.add(re);
            }
        }

        for (ISortable re: getRoutinesAndExercises()) {
            if(!newList.contains(re) && re.getName().toLowerCase().contains(search.toLowerCase())){
                newList.add(re);
            }
        }
        return newList;
    }
}
