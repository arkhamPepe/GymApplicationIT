package se.chalmers.group22.gymcompanion.ViewModel;

import lombok.Getter;
import lombok.Setter;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.ISortable;
import se.chalmers.group22.gymcompanion.Model.Routine;
import se.chalmers.group22.gymcompanion.Model.Strategies.FilterStrategy.BeginnerFilter;
import se.chalmers.group22.gymcompanion.Model.Strategies.FilterStrategy.FilterStrategy;
import se.chalmers.group22.gymcompanion.Model.Strategies.FilterStrategy.RecommendedFilter;

import java.util.ArrayList;
import java.util.List;

public class BrowseViewModel extends BaseViewModel {

    /** index
     * @value 0 = search selection, 1 = musclegroup, 2 = beginner, 3 = mix
     * */
    @Setter
    @Getter
    private int index;
    @Setter
    private List<MUSCLE_GROUP> muscleGroups;

    //Current page
    private String currentPage;

    private List<Routine> routines = new ArrayList();
    private List<Exercise> exercises = new ArrayList<>();

    private List<ISortable> searchedList = new ArrayList<>();
    private List<ISortable> filteredList = new ArrayList<>();

    public BrowseViewModel(){
        muscleGroups = new ArrayList<>();
        init();
    }

    private void init(){
        for(MUSCLE_GROUP mg : MUSCLE_GROUP.values()) {
            muscleGroups.add(mg);
        }

        routines.addAll(getModel().getRoutineList());
        exercises.addAll(getModel().getExerciseList());
    }

    public void search(String query){
        clearLists();

        searchedList.addAll(getModel().search(query));
        filteredList.addAll(searchedList);
    }

    public void filter(FilterStrategy strategy){
        searchedList.clear();
        filteredList.clear();

        searchedList.addAll(getModel().filter(getModel().getRoutinesAndExercises(), strategy));
        filteredList.addAll(searchedList);
    }

    public void filter(String mg) {
        searchedList.clear();
        filteredList.clear();

        List<MUSCLE_GROUP> mgList = new ArrayList<>();

        for(MUSCLE_GROUP m : muscleGroups) {
            if(mg.equals(m.toString())) {
                mgList.add(m);
            }
        }

        searchedList.addAll(getModel().filter(getModel().getRoutinesAndExercises(), mgList));
        filteredList.addAll(searchedList);
    }

    public void filterRoutines() {
        //Filters out all of the Exercises
        this.filteredList.clear();
        this.filteredList.addAll(getModel().filterRoutines(searchedList));
    }

    public void filterExercises() {
        //Filters out all of the Routines
        this.filteredList.clear();
        this.filteredList.addAll(getModel().filterExercises(searchedList));
    }

    public String getCurrentPage(){
        switch(index){
            case 0:
                currentPage = "Search result";
                break;
            case 1:
                currentPage = getMuscleGroupString();
                break;
            case 2:
                filter(new BeginnerFilter());
                currentPage = "Beginner";
                break;
            case 3:
                filter(new RecommendedFilter());
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

        String s;
        for(ISortable iSortable : filteredList) {
            if(iSortable.getName().length() > 19) {
                s = iSortable.getName().substring(0,19) + "...";
            } else {
                s = iSortable.getName();
            }
            names.add(s);
        }

        return names;
    }

    public List<Double> getRoutineAndExerciseDifficulties(){
        List<Double> difficulties = new ArrayList<>();

        for (ISortable iSortable : filteredList){
            difficulties.add(iSortable.getDifficulty());
        }

        return difficulties;
    }

    public List<String> getType(){
        List<String> type = new ArrayList<>();

        for (ISortable is : filteredList) {
            type.add("");
        }
        return type;
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
        filteredList.clear();
        searchedList.clear();
    }
}
