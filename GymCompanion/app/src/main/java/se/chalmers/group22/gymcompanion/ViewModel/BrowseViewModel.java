package se.chalmers.group22.gymcompanion.ViewModel;

import lombok.Getter;
import lombok.Setter;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.ISortable;
import se.chalmers.group22.gymcompanion.Model.Routine;
import se.chalmers.group22.gymcompanion.Model.Strategies.FilterStrategy.BeginnerFilter;
import se.chalmers.group22.gymcompanion.Model.Strategies.FilterStrategy.FilterStrategy;
import se.chalmers.group22.gymcompanion.Model.Strategies.FilterStrategy.MixedFilter;

import java.util.ArrayList;
import java.util.List;
/** BrowseViewModel
 *  Purpose: Process data from model to fit the view
 *  Authors: Alexander Bergsten, Marcus Svensson, Erik Bock, Augustas Eidikis, Daniel Olsson
 * */
public class BrowseViewModel extends BaseViewModel {

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
    private String[] sortFilters;

    //Current page
    private String currentPage;

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
        init();
    }

    /** init()
     * Purpose: inits List<MUSCLE_GROUP> muscleGroups, sets the sortfilter array
     * */
    private void init(){
        for(MUSCLE_GROUP mg : MUSCLE_GROUP.values()) {
            muscleGroups.add(mg);
        }

        sortFilters = new String[]{"Asc. alphabetic.", "Desc. alphabetic", "Asc. difficulty", "Desc. difficulty"};
    }

    /** search()
     * Purpose: clears all lists and calls searchRoutine() and searchExercise from GymCompanion, and fills
     * the routine and exercise lists with the search results
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
     * Purpose: clears all lists and
     * */
    public void filter(FilterStrategy strategy){
        filteredRoutines.addAll(getModel().filter(getModel().getRoutineList(), strategy));
        filteredExercises.addAll(getModel().filter(getModel().getExerciseList(), strategy));

        filteredRoutines.addAll(routines);
        filteredExercises.addAll(exercises);
    }

    public void filter(String mg) {
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

    public void setMuscleGroup(String s){
        muscleGroups.clear();

        if(s.equals("ARMS")) {
            muscleGroups.add(MUSCLE_GROUP.TRICEPS);
            muscleGroups.add(MUSCLE_GROUP.BICEPS);
            muscleGroups.add(MUSCLE_GROUP.FOREARMS);
        } else if(s.equals("LEGS")) {
            muscleGroups.add(MUSCLE_GROUP.QUADS);
            muscleGroups.add(MUSCLE_GROUP.HAMSTRINGS);
            muscleGroups.add(MUSCLE_GROUP.GLUTES);
        } else {
            for (MUSCLE_GROUP mg : MUSCLE_GROUP.values()) {
                if(s.equals(mg.toString())) {
                    muscleGroups.add(mg);
                }
            }
        }
    }

    public List<String> getRoutineAndExerciseNames(){
        List<String> names = new ArrayList<>();

        for(Routine r : filteredRoutines) {
            if(r.getName().length() > 17) {
                names.add(r.getName().substring(0,17) + "...");
            } else {
                names.add(r.getName());
            }
        }
        for(Exercise e : filteredExercises) {
            if(e.getName().length() > 17) {
                names.add(e.getName().substring(0,17) + "...");
            } else {
                names.add(e.getName());
            }
        }

        return names;
    }

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

    public List<String> getMuscleGroups(){
        List<String> muscles = new ArrayList<>();
        for(MUSCLE_GROUP mg : muscleGroups){
            muscles.add(mg.toString().replace("_", " "));
        }
        return muscles;
    }

    private void clearLists(){
        routines.clear();
        exercises.clear();
        filteredExercises.clear();
        filteredRoutines.clear();
    }
}
