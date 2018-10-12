package se.chalmers.group22.gymcompanion.Model;

import android.app.Application;
import android.content.Context;

public class GymCompanionContext extends Application {
    private static Context context;

    public void onCreate(){
        super.onCreate();
        context = getApplicationContext();
    }
    public static Context getContext(){
        return context;
    }
}
