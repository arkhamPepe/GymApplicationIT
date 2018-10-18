package se.chalmers.group22.gymcompanion.ViewModel;

import lombok.Getter;
import lombok.Setter;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;

import java.util.ArrayList;
import java.util.List;

public class BrowseViewModel extends BaseViewModel {

    /** index
     * @value 0 = routine, 1 = exercise, 2 = recommended
     * */
    @Setter
    @Getter
    private int index;
    @Setter
    private List<MUSCLE_GROUP> muscleGroups = new ArrayList<>();

    private String currentPage;

    public BrowseViewModel(){
        init();
    }

    private void init(){
        //Do stuff
    }

    public String search(String query){
        return "Query: " + query;
    }

    public String getCurrentPage(){
        switch(index){
            case 0:
                currentPage = "ROUTINE";
                break;
            case 1:
                currentPage = "EXERCISE";
                break;
            case 2:
                currentPage = "RECOMMENDED";
                break;
            case 3:
                //DO NOTHING
                break;
            default:
                currentPage = "NoIndex";
                break;
        }
        return currentPage;
    }

    public String getMuscleGroupString(){
        String muscles = "";
        if(muscleGroups != null) {
            for(MUSCLE_GROUP mg : muscleGroups) {
                muscles = muscles.concat(mg.toString().replace("_", " ") + " ");
            }
        }
        return muscles;
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

}
