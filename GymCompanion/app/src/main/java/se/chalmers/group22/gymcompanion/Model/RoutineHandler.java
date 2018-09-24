package se.chalmers.group22.gymcompanion.Model;

import java.util.List;

public class RoutineHandler {


    private static RoutineHandler routineHandler = new RoutineHandler();
    private RoutineHandler(){}

    public static RoutineHandler getInstance(){
        return routineHandler;
    }

    public void start(Routine routine){

    }
}
