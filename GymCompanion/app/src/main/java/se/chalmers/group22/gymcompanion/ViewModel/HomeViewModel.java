package se.chalmers.group22.gymcompanion.ViewModel;

import se.chalmers.group22.gymcompanion.Model.Routine;

import java.util.HashMap;
import java.util.Map;

public class HomeViewModel extends BaseViewModel {

    public HomeViewModel(){
    }

    public String getScheduledRoutineName(){
        return "Hej";
    }

    public String getTodaysRoutineName(){
        return getModel().getTodaysRoutineName();
    }

    public void startRoutine(){
        getModel().startRoutine();
    }

    public Map<String, String> getFinishedRoutineStats(){
        Routine finishedRoutine = getModel().getFinishedRoutine();
        Map<String, String> routineStatsMap = new HashMap<>();

        if(finishedRoutine != null) {
            // TODO fix timeSpent value
            routineStatsMap.put("timeSpent", "Unknown");
            routineStatsMap.put("totalExercises", String.valueOf(finishedRoutine.getExercises().size()));
            routineStatsMap.put("completedExercises", String.valueOf(finishedRoutine.getCompletedExercises()));
        }

        return routineStatsMap;
    }

}
