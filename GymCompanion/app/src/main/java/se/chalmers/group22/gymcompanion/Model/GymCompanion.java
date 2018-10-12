package se.chalmers.group22.gymcompanion.Model;

import lombok.Getter;

import java.util.Calendar;

@Getter
public class GymCompanion {
    private User user;
    public GymCompanion(){
        user = LocalDatabase.getInstance().loadUser();
    }

    public String getTodaysRoutineName(){
        return user.getTodaysRoutineName();
    }

    public void startRoutine(){
        user.startRoutine(user.getTodaysRoutine());
    }


}
