package se.chalmers.group22.gymcompanion.ViewModel;

import se.chalmers.group22.gymcompanion.Model.Routine;

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

    public Map<String, Integer> getFinishedRoutineStats(){
        Routine finishedRoutine = getModel().getFinishedRoutine();
        Map<String, Integer> routineStatsMap = new HashMap<>();

        if(finishedRoutine != null) {
            // TODO fix timeSpent value
            routineStatsMap.put("timeSpent", 0);
            routineStatsMap.put("totalExercises", finishedRoutine.getExercises().size());
            routineStatsMap.put("completedExercises", finishedRoutine.getCompletedExercises());
        }

        return routineStatsMap;
    }

}
