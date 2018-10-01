package se.chalmers.group22.gymcompanion.View;

import android.view.View;

public interface INavigation {
    void startActivityBrowse(View view);
    void startActivityMain(View view);
    void startActivityStatistics(View view);
    void startActivityMyRoutines(View view);
    void startActivitySchedule(View view);

}
