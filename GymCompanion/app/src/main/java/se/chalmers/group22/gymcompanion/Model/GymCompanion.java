package se.chalmers.group22.gymcompanion.Model;

import android.app.Application;
import android.content.Context;

public class GymCompanion extends Application {
    private static Context context;

    public void onCreate(){
        super.onCreate();
        GymCompanion.context = getApplicationContext();
    }

    public static Context getAppContext(){
        return GymCompanion.context;
    }
}
