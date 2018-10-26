package se.chalmers.group22.gymcompanion.ViewModel;

import se.chalmers.group22.gymcompanion.Model.Workout.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.DataStorage.LocalDatabase;
import se.chalmers.group22.gymcompanion.Model.Workout.Routine;
import se.chalmers.group22.gymcompanion.Model.User.User;

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
public class MainViewModel extends ObservableViewModel{
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
