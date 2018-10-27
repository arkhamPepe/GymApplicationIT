package se.chalmers.group22.gymcompanion.Model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import se.chalmers.group22.gymcompanion.Enums.INTENSITY;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Model.DataStorage.LocalDatabase;
import se.chalmers.group22.gymcompanion.Model.Schedule.Schedule;
import se.chalmers.group22.gymcompanion.Model.User.User;
import se.chalmers.group22.gymcompanion.Model.Workout.Exercises.CardioExercise;
import se.chalmers.group22.gymcompanion.Model.Workout.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Workout.Exercises.StrengthExercise;
import se.chalmers.group22.gymcompanion.Model.Strategies.FilterStrategy.FilterStrategy;
import se.chalmers.group22.gymcompanion.Model.Strategies.SortingStrategy.SortingStrategy;
import se.chalmers.group22.gymcompanion.Model.Workout.Routine;


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
 * Used by: GymCompanionSearchTest.java, GymCompanionSortAndFilterTest.java,
 *      GymCompanionTest.java, BaseViewModel.java
 * Uses: User.java, Routine.java, Exercise.java,
 *      StrengthExercise.java, CardioExercise.java,
 *      ISortable.java, SortingStrategy.java, FilterStrategy.java,
 *      GymCompanionContext.java, LocalDatabase.java
 */

@Getter
public class GymCompanion {
    @Setter
    private User user;


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
        if(exerciseList != null) {
            for (Exercise e : exerciseList) {
                e.toggleCompletion(false);
            }
        }
        setActiveRoutine(user.getTodaysRoutine());
        saveUser();
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

    public boolean isActiveExerciseStrengthExercise(){
        return activeExercise instanceof StrengthExercise;
    }

    //Schedule Methods

    public boolean isScheduled(Calendar day){
        return user.scheduleDayHasRoutine(day);
    }

    public void scheduleRoutine(Calendar day, int routineIndex){
        user.scheduleAddRoutine(user.getRoutine(routineIndex), day);
    }

    public void scheduleRoutine(Calendar day, String routineName){
        Routine routine = getRoutine(routineName);

        user.scheduleAddRoutine(routine, day);
        saveUser();
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

    public void addExerciseToRoutine(Exercise exercise, Routine routine) {
        user.addExerciseToRoutine(exercise, routine);
    }

    public void addRoutine(Routine routine){
        user.addRoutine(routine);
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

    public void removeRoutine(int position){
        Routine r = getUser().getRoutines().get(position);
        user.removeRoutine(r);
        saveUser();
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

    public void saveUser(){
        if(GymCompanionContext.getContext() != null) {
            LocalDatabase db = LocalDatabase.getInstance();
            db.saveUser(user);
        }
    }

    /**
     *              GETTERS for Law of Demeter
     **/

    public String getSelectedRoutineName(int selectedRoutineIndex){
        return getSelectedRoutine(selectedRoutineIndex).getName();
    }

    public int getSelectedRoutineExerciseAmount(int selectedRoutineIndex){
        return getSelectedRoutineExercises(selectedRoutineIndex).size();
    }

    public Routine getSelectedRoutine(int selectedRoutineIndex){
        return getUser().getRoutine(selectedRoutineIndex);
    }

    public void updateStrenghtExerciseSets(int sets, int selectedRoutineIndex, int selectedExerciseIndex){
        ((StrengthExercise)getUser().getRoutine(selectedRoutineIndex).getExercises().get(selectedExerciseIndex)).updateSets(sets);

    }

    public int getStrenghtExerciseSets(int selectedRoutineIndex, int selectedExerciseIndex){
        return ((StrengthExercise)getUser()
                .getRoutine(selectedRoutineIndex).getExercises().get(selectedExerciseIndex)).getSets();
    }

    public List<Double> getStrenghtExerciseKilograms(int selectedRoutineIndex, int selectedExerciseIndex){
               return ((StrengthExercise)user.getRoutine(selectedRoutineIndex)
                       .getExercises().get(selectedExerciseIndex)).getKilograms();
    }

    public List<Integer> getStrenghtExerciseReps(int selectedRoutineIndex, int selectedExerciseIndex){
        return ((StrengthExercise)user.getRoutine(selectedRoutineIndex).getExercises().get(selectedExerciseIndex)).getRepetitions();
    }


    public List<Routine> getUserRoutines(){
        return getUser().getRoutines();
    }

    public String getSelectedExerciseName(int selectedRoutineIndex, int selectedExerciseIndex){
        return user.getRoutine(selectedRoutineIndex).getExercises().get(selectedExerciseIndex).getName();
    }

    public int getSelectedCardioExerciseTime(int selectedRoutineIndex, int selectedExerciseIndex){
        return ((CardioExercise)user.getRoutine(selectedRoutineIndex).getExercises().get(selectedExerciseIndex)).getTimespent();
    }

    public INTENSITY getCardioExerciseIntensity(int selectedRoutineIndex, int selectedExerciseIndex) {
        return user.getRoutine(selectedRoutineIndex).getExercises().get(selectedExerciseIndex).getIntensity();
    }

    public Exercise getSelectedExercise(int selectedRoutineIndex, int selectedExerciseIndex){
        return getUser().getRoutine(selectedRoutineIndex).getExercises().get(selectedExerciseIndex);
    }

    public Routine getRoutineFromDay(Calendar day){
        return user.getRoutineFromDay(day);
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

    public Routine getRoutineFromIndex(int routineIndex){
        return user.getRoutine(routineIndex);
    }

    public int getAmountOfExercisesInActiveRoutine(){
        if(activeRoutine == null)
        {
            return 0;
        }
        return activeRoutine.getExercises().size();
    }

    public String getActiveExerciseName(){
        return activeExercise.getName();
    }

    public String getActiveRoutineName(){
        return  activeRoutine.getName();
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

    public String getScheduledRoutineName(){
        return user.getScheduledRoutineName();
    }


    public Routine getFinishedRoutine() {
        return user.getFinishedRoutine();
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

    public Map<Calendar, Double> getGraphData(int weekOffset){
        return user.getGraphData(weekOffset);
    }

    public Map<Calendar, Routine> getUserCompletedRoutines(){
        return user.getCompletedRoutines();
    }

    public List<String> getRoutineNames(){
        List<String> routineNames = new ArrayList<>();
        for (Routine routine: user.getRoutines()){
            routineNames.add(routine.getName());
        }
        return routineNames;
    }

    public List<Integer> getRoutinesExerciseCount(){
        List<Integer> routinesExerciseCount = new ArrayList<>();
        for (Routine routine: user.getRoutines()){
            routinesExerciseCount.add(routine.getExercises().size());
        }
        return routinesExerciseCount;
    }

}
