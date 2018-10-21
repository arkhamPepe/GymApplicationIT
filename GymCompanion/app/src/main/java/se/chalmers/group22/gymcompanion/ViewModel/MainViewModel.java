package se.chalmers.group22.gymcompanion.ViewModel;

import se.chalmers.group22.gymcompanion.Model.Workout.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.DataStorage.LocalDatabase;
import se.chalmers.group22.gymcompanion.Model.Workout.Routine;
import se.chalmers.group22.gymcompanion.Model.User.User;

import java.util.List;

public class MainViewModel extends BaseViewModel{
    public MainViewModel(){
        init();
    }

    private void init(){
        LocalDatabase localDatabase = LocalDatabase.getInstance();
        User loadedUser = localDatabase.loadUser();
        List<Exercise> totalExercises = localDatabase.loadTotalExercises();
        List<Routine> totalRoutines = localDatabase.loadTotalRoutines();

        getModel().setExerciseList(totalExercises);
        getModel().setRoutineList(totalRoutines);
        getModel().setUser(loadedUser);
    }
}
