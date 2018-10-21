package se.chalmers.group22.gymcompanion.ViewModel;

import se.chalmers.group22.gymcompanion.Model.Workout.Routine;

import java.util.HashMap;
import java.util.Map;

public class HomeViewModel extends BaseViewModel {

    public HomeViewModel(){
    }

    public String getTodaysRoutineName() {
        String routineName = getModel().getActiveRoutine().getName();
        if (routineName.isEmpty()) {
            return "No routine for today";
        }
        return routineName;
    }

    public String getScheduledRoutineName(){
        return getModel().getScheduledRoutineName();
    }

    public void startRoutine(){
        getModel().startRoutine();
    }

    public boolean startRoutineIsSet(){
        return getModel().startRoutineIsSet();
    }

    public Map<String, String> getFinishedRoutineStats(){
        Routine finishedRoutine = getModel().getFinishedRoutine();
        Map<String, String> routineStatsMap = new HashMap<>();

       if(finishedRoutine != null) {
            routineStatsMap.put("exerciseName", String.valueOf(finishedRoutine.getName()));
            routineStatsMap.put("totalExercises", String.valueOf(finishedRoutine.getExercises().size()));
            routineStatsMap.put("completedExercises", String.valueOf(finishedRoutine.getCompletedExercises()));
        }

        return routineStatsMap;
    }

}
