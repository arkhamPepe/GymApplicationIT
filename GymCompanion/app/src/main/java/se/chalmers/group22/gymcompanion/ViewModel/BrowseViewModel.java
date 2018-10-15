package se.chalmers.group22.gymcompanion.ViewModel;

import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.LocalDatabase;
import se.chalmers.group22.gymcompanion.Model.Routine;
import se.chalmers.group22.gymcompanion.Model.User;

import java.util.ArrayList;
import java.util.List;

public class BrowseViewModel extends BaseViewModel {

    private List<Routine> routines = new ArrayList<>();
    private List<Exercise> exercises = new ArrayList<>();

    public BrowseViewModel(){
        init();
    }

    private void init(){
        //Do stuff
    }

    public String search(String query){
        return "Query: " + query;
    }

    public List<String> getRoutineNames(){
        List<String> names = new ArrayList<>();

        for (Routine r : routines){
            names.add(r.getName());
        }

        return names;
    }

    public List<String> getExerciseNames(){
        List<String> names = new ArrayList<>();

        for (Exercise e : exercises) {
            names.add(e.getName()) ;
        }
        return names;
    }
}
