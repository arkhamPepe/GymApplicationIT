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
    private boolean routineActive;

    @Getter
    private Schedule schedule;


    public User(List<User> friends, String name, String gym, int age, int weight, boolean isBeginner){
        this.friends = friends;
        this.name = name;
        this.gym = gym;
        this.age = age;
        this.weight = weight;
        this.isBeginner = isBeginner;
        this.routineActive = false;
        this.schedule = new Schedule();
    }

    public void startRoutine(){
        /*Start the routine for the current day*/
        routineActive = true;
    }

    public void addRoutine(){
        /*Press a button to add a routine to the current day*/
    }

    public void selectRoutine(){
        /*Select the routine located on the current day and initiate it*/
    }

}
