package se.chalmers.group22.gymcompanion.ViewModel;

import lombok.Getter;
import lombok.Setter;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Routine;
import se.chalmers.group22.gymcompanion.Model.Strategies.FilterStrategy.BeginnerFilter;
import se.chalmers.group22.gymcompanion.Model.Strategies.FilterStrategy.FilterStrategy;
import se.chalmers.group22.gymcompanion.Model.Strategies.FilterStrategy.MixedFilter;
import se.chalmers.group22.gymcompanion.Model.Strategies.SortingStrategy.*;

import java.util.ArrayList;
import java.util.List;
/***
 * Title: BrowseViewModel
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 12, 2018
 *
 * Purpose: To handle the communication between the model and the view without without showing the model's underlying
 * representation to the view.
 */
public class BrowseViewModel extends ObservableViewModel {

    /** index
     * @value 0 = search selection, 1 = musclegroup, 2 = beginner, 3 = mix
     * */
    @Setter
    @Getter
    private int index;
    @Setter
    private List<MUSCLE_GROUP> muscleGroups;

    //Most recent search performed
    @Getter
    private String query;

    //Array of the different sort filters
    @Getter
    private List<String> sortFilters;

    //Current page
    private String currentPage;

    //Exercise to add to a user routine
    @Setter
    @Getter
    private String exerciseToAdd;

    //Used to separate the routines from exercises
    private List<Routine> routines;
    private List<Exercise> exercises;

    //Temporary lists when filtering out routines or exercises, used to let the main lists stay intact
    private List<Routine> filteredRoutines;
    private List<Exercise> filteredExercises;

    public BrowseViewModel(){
        this.muscleGroups = new ArrayList<>();
        this.routines = new ArrayList<>();
        this.exercises = new ArrayList<>();
        this.filteredRoutines = new ArrayList<>();
        this.filteredExercises = new ArrayList<>();
        this.sortFilters = new ArrayList<>();
        init();
    }

    /** init()
     * Purpose: inits List<MUSCLE_GROUP> muscleGroups, sets the sortfilter list
     * */
    private void init(){
        for(MUSCLE_GROUP mg : MUSCLE_GROUP.values()) {
            muscleGroups.add(mg);
        }

        sortFilters.add("Asc. alphabetic.");
        sortFilters.add("Desc. alphabetic");
        sortFilters.add("Asc. difficulty");
        sortFilters.add("Desc. difficulty");
    }
    /** search()
     * Purpose: clears all lists and calls searchRoutine() and searchExercise from GymCompanion, and fills
     * the routine and exercise lists with the search results
     * @param query is the text from the searchbox
     * */
    public void search(String query){
        clearLists();

        routines.addAll(getModel().searchRoutine(query));
        exercises.addAll(getModel().searchExercise(query));

        filteredRoutines.addAll(routines);
        filteredExercises.addAll(exercises);

        this.query = query;
    }

    /** filter(FilterStrategy)
     * Purpose: clears all lists and applies a filter depending on strategy
     * (see se.chalmers.group22.gymcompanion.Model.Strategies.FilterStrategy)
     * @param strategy is the chosen filterstrategy
     * */
    public void filter(FilterStrategy strategy){
        clearLists();
        routines.addAll(getModel().filter(getModel().getRoutineList(), strategy));
        exercises.addAll(getModel().filter(getModel().getExerciseList(), strategy));

        filteredRoutines.addAll(routines);
        filteredExercises.addAll(exercises);
    }

    /** filter(String)
     * Purpose: clears al lists and applies a filter depending on muscle group
     * */
    public void filter(String mg) {
        clearLists();
        List<MUSCLE_GROUP> mgList = new ArrayList<>();

        for(MUSCLE_GROUP m : muscleGroups) {
            if(mg.equals(m.toString())) {
                mgList.add(m);
            }
        }

        routines.addAll(getModel().filter(getModel().getRoutineList(), mgList));
        exercises.addAll(getModel().filter(getModel().getExerciseList(), mgList));

        filteredRoutines.addAll(routines);
        filteredExercises.addAll(exercises);
    }

    /** filterRoutinesExercises(boolean, int)
     * Purpose: filters out either all routines or all exercises
     * @param t if this is false, the checkbox is unchecked (and vice versa)
     * @param type if this is 1, it filters routines, 0 filters exercises
     * */
    public void filterRoutinesExercises(boolean t, int type) {
        //Filters Routines
        if(t){
            if(type == 1) {
                filteredRoutines.clear();
            } else {
                filteredExercises.clear();
            }
        } else {
            if(type == 1) {
                filteredRoutines.addAll(routines);
            } else {
                filteredExercises.addAll(exercises);
            }

        }
    }

    /** sortRoutinesAndExercises(int)
     * Purpose: to sort the list by user preference
     * @param position position in spinner to decide what strategy to use
     * */
    public void sortRoutinesAndExercises(int position){
        SortingStrategy strategy;

        switch (position) {
            case 0:
                strategy = new AscendingAlphabetic();
                break;
            case 1:
                strategy = new DescendingAlphabetic();
                break;
            case 2:
                strategy = new AscendingDifficulty();
                break;
            case 3:
                strategy = new DescendingDifficulty();
                break;
            default:
                strategy = new AscendingAlphabetic();
                break;
        }

        getModel().sort(routines, strategy);
        getModel().sort(exercises, strategy);
    }

    /** getCurrentPage()
     * @return a string that displays what page you are currently on (decided through getting where you came from)
     * */
    public String getCurrentPage(){
        switch(index){
            case 0:
                currentPage = query;
                break;
            case 1:
                currentPage = getMuscleGroupString();
                break;
            case 2:
                filter(new BeginnerFilter());
                currentPage = "Beginner";
                break;
            case 3:
                filter(new MixedFilter());
                currentPage = "Mix";
                break;
            default:
                currentPage = "NoIndex";
                break;
        }
        return currentPage;
    }

    private String getMuscleGroupString(){
        StringBuilder muscles = new StringBuilder();
        if(muscleGroups != null) {
            for(MUSCLE_GROUP mg : muscleGroups) {
                muscles.append(mg.toString().replace("_", " ") + " ");
            }
        }
        return muscles.toString();
    }

    /** setMuscleGroup()
     * Purpose: sets the muscle_group to the chosen muscle group
     * */
    public void setMuscleGroup(String s){
        muscleGroups.clear();
        for (MUSCLE_GROUP mg : MUSCLE_GROUP.values()) {
            if(s.equals(mg.toString())) {
                muscleGroups.add(mg);
            }
        }
    }
    /** getRoutineAndExerciseNames()
     * Purpose: used by arrayadapters to build their listviews
     * @return list of routine & exercise names (String)
     * */
    public List<String> getRoutineAndExerciseNames(){
        List<String> names = new ArrayList<>();

        for(Routine r : filteredRoutines) {
            if(r.getName().length() > 25) {
                names.add(r.getName().substring(0,25) + "...");
            } else {
                names.add(r.getName());
            }
        }
        for(Exercise e : filteredExercises) {
            if(e.getName().length() > 25) {
                names.add(e.getName().substring(0,25) + "...");
            } else {
                names.add(e.getName());
            }
        }

        return names;
    }

    /** getRoutineAndExerciseDifficulties()
     * Purpose: used by arrayadapters to build their listviews
     * @return list of routine & exercise difficulties in (Double)
     * */
    public List<Double> getRoutineAndExerciseDifficulties(){
        List<Double> difficulties = new ArrayList<>();

        for(Routine r : filteredRoutines) {
            difficulties.add(r.getDifficulty());
        }

        for(Exercise e : filteredExercises) {
            difficulties.add(e.getDifficulty());
        }

        return difficulties;
    }

    /** getRoutineAmountExercises()
     * Purpose: used by arrayadapters to build their listviews
     * @return list of the amount of exercises a routine contains, if this is an exercise it will contain 0 (Integer)
     * */
    public List<Integer> getRoutineAmountExercises(){
        List<Integer> amount = new ArrayList<>();

        for(Routine r : filteredRoutines) {
            amount.add(r.getExercises().size());
        }
        for(int i = 0;i < filteredExercises.size();i++){
            amount.add(0);
        }
        return amount;
    }

    /** getUserRoutineNames()
     * Purpose: used by arrayadapters to build their listviews
     * @return list of the user's custom routines names (String)
     * */
    public List<String> getUserRoutineNames(){
        List<String> names = new ArrayList<>();

        for(Routine r : getModel().getUserRoutines()) {
            names.add(r.getName());
        }

        return names;
    }

    /** getUserRoutineDifficulties()
     * Purpose: used by arrayadapters to build their listviews
     * @return list of user routine difficulties (Double)
     * */
    public List<Double> getUserRoutineDifficulties(){
        List<Double> difficulties = new ArrayList<>();

        for(Routine r : getModel().getUserRoutines()) {
            difficulties.add(r.getDifficulty());
        }

        return difficulties;
    }

    /** getUserRoutineAmountExercises()
     * Purpose: used by arrayadapters to build their listviews
     * @return list of user routine amount of exercises (Integer)
     * */
    public List<Integer> getUserRoutineAmountExercises(){
        List<Integer> amount = new ArrayList<>();

        for(Routine r : getModel().getUserRoutines()) {
            amount.add(r.getExercises().size());
        }

        return amount;
    }


    /** getMuscleGroups()
     * Purpose: used in the arrayadapter that builds the muscle group list, to get the muscle group name
     * @return list of muscle group names (String)
     * */
    public List<String> getMuscleGroups(){
        List<String> muscles = new ArrayList<>();
        for(MUSCLE_GROUP mg : muscleGroups){
            muscles.add(mg.toString().replace("_", " "));
        }
        return muscles;
    }

    /** addRoutineToUser(String)
     *  Purpose: adds a selected routine to the user
     * @param routineName name of the clicked routine in listview
     * */
    public void addRoutineToUser(String routineName){
        for(Routine r :getModel().getRoutineList()) {
            if(r.getName().equals(routineName)) {
                getModel().getUser().addRoutine(r);
                break;
            }
        }
    }

    /** addExerciseToUserRoutine(String)
     * Purpose: Adds the the exercise clicked in result list to the routine clicked in routineinfo fragment
     * @param routineName the name of the routine pressed
     * */
    public void addExerciseToUserRoutine(String routineName){
        for(Routine r :getModel().getUserRoutines()) {
            if(r.getName().equals(routineName)) {
                getModel().getUser().addExerciseToRoutine(getExerciseByName(), r);
                break;
            }
        }
    }

    /** compareRoutineExercises(String)
     * Purpose: checks whether the name is a routine or exercise name
     * @param name name of routine or exercise
     * @return an index depending on if the name corresponds to a routine or an exercise
     * */
    public int compareRoutineExercises(String name){
        for(Routine r : getModel().getRoutineList()) {
            if(r.getName().equals(name)) {
                return 0;
            }
        }
        for(Exercise e : getModel().getExerciseList()) {
            if(e.getName().equals(name)) {
                return 1;
            }
        }
        return 2;
    }

    private Exercise getExerciseByName() {
        for(Exercise e : getModel().getExerciseList()){
            if(e.getName().equals(exerciseToAdd)) {
                return e;
            }
        }
        return null;
    }

    private void clearLists(){
        routines.clear();
        exercises.clear();
        filteredExercises.clear();
        filteredRoutines.clear();
    }
}
