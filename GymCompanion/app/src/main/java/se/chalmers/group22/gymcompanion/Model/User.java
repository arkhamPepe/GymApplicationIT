package se.chalmers.group22.gymcompanion.Model;

import java.util.List;

public class User {

    private List<User> friends;
    private String name;
    private String gym;
    private int age;
    private int weight;
    private boolean isBeginner;
    private boolean routineActive;
    // private Schedule schedule;


    User(List<User> friends, String name, String gym, int age, int weight, boolean isBeginner){
        this.friends = friends;
        this.name = name;
        this.gym = gym;
        this.age = age;
        this.weight = weight;
        this.isBeginner = isBeginner;
        this.routineActive = false;
    }

    public void startRoutine(){}

    public void getRoutine(){}

    public void selectRoutine(){}

}
