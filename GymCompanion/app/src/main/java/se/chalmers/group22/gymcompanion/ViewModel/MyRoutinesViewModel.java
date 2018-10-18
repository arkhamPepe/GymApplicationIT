package se.chalmers.group22.gymcompanion.ViewModel;

import lombok.Getter;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.StrengthExercise;
import se.chalmers.group22.gymcompanion.Model.Routine;

import java.util.ArrayList;
import java.util.List;

public class MyRoutinesViewModel extends BaseViewModel {

    @Getter
    private int selectedRoutineIndex;
    List<Routine> routines = new ArrayList<>();

    public MyRoutinesViewModel(){
        Routine routine1 = new Routine("Routine1");
        Routine routine2 = new Routine("Routine2");
        Exercise strengthExercise1 = new StrengthExercise("Benkprench",3.4);
        Exercise strengthExercise2 = new StrengthExercise("Squats",5.5);
        routine1.addExercise(strengthExercise1);
        routine2.addExercise(strengthExercise2);
        routines.add(routine1);
        routines.add(routine2);
    }

    public void createRoutine(){
        getModel().createRoutine();
    }

    /*public void addExercise(){
        getModel().addExercise(,routines.get(selectedRoutineIndex));

    }*/

    public String getSelectedRoutineExerciseAmount(){
        return Integer.toString(routines.get(selectedRoutineIndex).getExercises().size());
    }

    public List<Routine> getRoutines(){
        return routines;
    }

    public void setSelectedRoutineIndex(int position){
        selectedRoutineIndex = position;
    }

    public String getSelectedRoutineName(){
        return  routines.get(selectedRoutineIndex).getName();
    }

    public List<Exercise> getExercises(){
        return routines.get(selectedRoutineIndex).getExercises();
    }

    public void setActiveRoutine(){
        getModel().setActiveRoutine(routines.get(selectedRoutineIndex));
    }

}
