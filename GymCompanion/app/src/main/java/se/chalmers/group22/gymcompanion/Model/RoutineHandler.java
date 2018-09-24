package se.chalmers.group22.gymcompanion.Model;

public class RoutineHandler {

    private static RoutineHandler routineHandler = new RoutineHandler();
    private RoutineHandler(){}

    public static RoutineHandler getInstance(){
        return routineHandler;
    }
}
