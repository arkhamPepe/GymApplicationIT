package se.chalmers.group22.gymcompanion.Model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Model.Exercises.CardioExercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.StrengthExercise;
import se.chalmers.group22.gymcompanion.Model.Strategies.FilterStrategy.FilterStrategy;
import se.chalmers.group22.gymcompanion.Model.Strategies.SortingStrategy.SortingStrategy;




import java.util.*;

/***
 * Title: GymCompanion
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 5, 2018
 *
 * Purpose: Class for handling external access to model classes.
 */

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
        saveUser();
    }

    public void startRoutine(Routine routine){
        /*TODO Start the routine for the current day*/
        isRoutineActive = true;
        activeRoutine = routine;
        /*TODO redirect to "Workout in progress"-page*/
        saveUser();

        if(exerciseList != null) {
            for (Exercise e : exerciseList) {
                e.toggleCompletion(false);
            }
        }
        setActiveRoutine(user.getTodaysRoutine());
    }

    public void setActiveRoutine(Routine routine){
        if(routine != null) {
            isRoutineActive = true;
            activeRoutine = new Routine(routine);
        }
    }

    //Active Routine Methods

    public void setActiveExerciseInActiveRoutine(int index){
        activeExercise = activeRoutine.getExercises().get(index);
        saveUser();
    }

    public int getAmountOfExercisesInActiveRoutine(){
        if(activeRoutine == null)
        {
            return 0;
        }
        return activeRoutine.getExercises().size();
    }

    public void toggleCompletionExerciseInARWithIndex(int index, boolean completed){
        activeRoutine.setCompletionOfExerciseWithIndex(index,completed);
    }

    public void completeActiveRoutine() {
        user.finishRoutine(activeRoutine);
    }
    public boolean startRoutineIsSet(){
        return activeRoutine != null;
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
        saveUser();
    }

    public Map<Calendar, Double> getGraphData(int weekOffset){
        return user.getGraphData(weekOffset);
    }

    public Map<Calendar, Routine> getUserCompletedRoutines(){
        return user.getCompletedRoutines();
    }

    //Routine creation and modification

    public void createRoutine(){
        user.createRoutine();
    }

    public void addExercise(Exercise exercise, Routine routine){
        user.addExerciseToRoutine(exercise, routine);
        saveUser();
    }

    public void addExerciseToRoutine(int selectedRoutineIndex, String exerciseName){
        Exercise e = null;
        for (Exercise ex: new ArrayList<>(exerciseList)) {
            if(ex.getName().equals(exerciseName)){
                e = ex;
                break;
            }
        }

        user.addExerciseToRoutine(selectedRoutineIndex,e );
        saveUser();
    }

    public void removeExerciseFromRoutine(int selectedRoutineIndex, String exerciseName){
        Exercise e = null;
        for (Exercise ex: new ArrayList<>(user.getRoutineExercises(selectedRoutineIndex))) {
            if(ex.getName().equals(exerciseName)){
                e = ex;
                break;
            }
        }

        user.removeExerciseFromRoutine(selectedRoutineIndex,e);
        saveUser();
    }

    public void setSelectedRoutineName(int position, String name){
        user.getRoutines().get(position).setName(name);
    }

    public void removeRoutine(String routineName){
        Routine r = null;
        for (Routine ro: new ArrayList<>(user.getRoutines())) {
            if(ro.getName().equals(routineName)){
                r= ro;
                break;
            }
        }
        user.removeRoutine(r);
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



    public List<Routine> getUserRoutines() {
        return user.getRoutines();
    }

    public Routine getRoutineFromDay(Calendar day){
        return user.getRoutineFromDay(day);
    }

    public Routine getRoutineFromName(String name){
        return user.getRoutineFromName(name);
    }

    public String getRoutineNameOnDate(int year, int month, int day) {
        return user.getRoutineNameOnDate(year, month, day);
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

    public List<Exercise> getSelectedRoutineExercises(int index){
        return user.getRoutineExercises(index);
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
        List<T> newList = new ArrayList<>();

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
        newList.removeAll(new ArrayList<>(routineList));
        return newList;
    }

    public <T extends ISortable> List<T> filterExercises(List<T> toBeFiltered){
        List<T> newList = new ArrayList<>(toBeFiltered);
        newList.removeAll(new ArrayList<>(exerciseList));
        return newList;
    }

    public List<Routine> searchRoutine(String search){
        if (search.equals("")) {
            return new ArrayList<>(routineList);
        }
        List<Routine> newList = new ArrayList<>();

        for (Routine r: new ArrayList<>(routineList)) {
            matchSearchWithName(search,r,newList);
        }
        return newList;
    }

    public List<Exercise> searchExercise(String search){
        if (search.equals("")) {
            return new ArrayList<>(exerciseList);
        }
        List<Exercise> newList = new ArrayList<>();

        for (Exercise e: new ArrayList<>(exerciseList)) {
            matchSearchWithName(search,e,newList);
        }
        return newList;
    }
    
    private <T extends ISortable> void matchSearchWithName(String search, T re, List<T> newList){
        if(search.toLowerCase().equals(re.getName().toLowerCase())){
            newList.add(re);
        }
        else if(!newList.contains(re) && re.getName().toLowerCase().startsWith(search.toLowerCase())){
            newList.add(re);
        }
        else if(!newList.contains(re) && re.getName().toLowerCase().contains(search.toLowerCase())){
            newList.add(re);
        }
    }

    // User save data

    private void saveUser(){
        if(GymCompanionContext.getContext() != null) {
            LocalDatabase db = LocalDatabase.getInstance();
            db.saveUser(user);
        }
    }

}
