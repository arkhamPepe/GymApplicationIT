package se.chalmers.group22.gymcompanion.Model;

import lombok.Getter;

import java.util.List;

public class User {

    private List<User> friends;
    private String name;
    private String gym;
    private int age;
    private int weight;
    private boolean isBeginner;

    @Getter
    private boolean routineIsActive;

    @Getter
    private Schedule schedule;


    public User(List<User> friends, String name, String gym, int age, int weight, boolean isBeginner){
        this.friends = friends;
        this.name = name;
        this.gym = gym;
        this.age = age;
        this.weight = weight;
        this.isBeginner = isBeginner;
        this.routineIsActive = false;
        this.schedule = new Schedule();
    }

    public void startRoutine(Routine routine){
       /*TODO Start the routine for the current day*/
        routineIsActive = true;
        /*TODO redirect to "Workout in progress"-page*/

    }

    public void checkDay(){
        if (true/*check if routine exists in the current day*/){
            startRoutine(null/*get routine from schedule*/);
        }
        else {
            /*TODO Direct the user to MR so it can create a new routine*/
        }
    }

}
