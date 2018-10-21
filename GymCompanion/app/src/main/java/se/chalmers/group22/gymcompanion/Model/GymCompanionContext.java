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
 * Used by: GymCompanion.java, LocalDatabase.java, Parser.java, AndroidManifest.xml
 * Uses: NA
 */

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
