package se.chalmers.group22.gymcompanion.Model;

public class GymCompanion {
    private User user;
    public GymCompanion(){
        user = LocalDatabase.getInstance().loadUser();
    }
}
