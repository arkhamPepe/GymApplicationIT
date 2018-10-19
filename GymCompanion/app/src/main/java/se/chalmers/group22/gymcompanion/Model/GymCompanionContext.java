package se.chalmers.group22.gymcompanion.Model;

import android.app.Application;
import android.content.Context;

/***
 * Title: GymCompanionContext
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 5, 2018
 *
 * Purpose: Class for handling global static access to the Android application context.
 */

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
