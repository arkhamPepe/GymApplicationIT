package se.chalmers.group22.gymcompanion.Model;

import android.app.Application;
import android.content.Context;

public class GymCompanionContext extends Application {
    private static GymCompanionContext context;

    @Override
    public void onCreate(){
        super.onCreate();
        context = this;
    }

    public static GymCompanionContext getContext(){
        return context;
    }
}
