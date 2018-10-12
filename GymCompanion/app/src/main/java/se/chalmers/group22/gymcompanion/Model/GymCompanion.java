package se.chalmers.group22.gymcompanion.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;

@Getter
public class GymCompanion {
    @Setter
    private User user;
    public GymCompanion(){

    }

    public String getTodaysRoutineName(){
        return user.getTodaysRoutineName();
    }

    public void startRoutine(){
        user.startRoutine(user.getTodaysRoutine());
    }


}
