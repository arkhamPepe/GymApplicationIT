package se.chalmers.group22.gymcompanion.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.Statistics.StatisticsExercisesFragment;
import se.chalmers.group22.gymcompanion.View.Statistics.StatisticsHistoryFragment;
import se.chalmers.group22.gymcompanion.View.Statistics.StatisticsLifetimeStatsFragment;
import se.chalmers.group22.gymcompanion.View.Statistics.StatisticsStartFragment;
import se.chalmers.group22.gymcompanion.ViewModel.StatisticsViewModel;

import java.util.ArrayList;
import java.util.List;

/** StatisticsActivity
 *  Purpose: Manage user interaction in the activity Statistics
 *  Authors: Alexander Bergsten, Marcus Svensson, Erik Bock, Augustas Eidikis, Daniel Olsson
 * */
public class StatisticsActivity extends AppCompatActivity {

    public static final int index = 4; // Defines which item that represents this activity in the bottom navigation

    //The ViewModel should be created/die along the View
    private StatisticsViewModel statisticsViewModel = new StatisticsViewModel();

    // Local fragments for the statistics activity
    final Fragment fragmentStart = new StatisticsStartFragment();
    final Fragment fragmentExercises = new StatisticsExercisesFragment();
    final Fragment fragmentHistory = new StatisticsHistoryFragment();
    final Fragment fragmentLifetimeStats = new StatisticsLifetimeStatsFragment();
    final Fragment navigationFragment = new NavigationFragment();

    Fragment active = fragmentStart; // The fragment shown when this activity is created
    private List<Fragment> fragments = new ArrayList<>(); // Collection of all local fragments

    final FragmentManager fm = getSupportFragmentManager(); // Object that handles transitions between local fragments


    /** onCreate(Bundle)
     *  Purpose: Initiates this activity;
     *      configures the bottom navigation
     *      prepares and arranges fragments
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        //Sends the activity index to NavigationFragment via Bundle
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        navigationFragment.setArguments(bundle);

        fillFragmentsList();
        performInitTransaction();

    }

    /** fillFragmentsList()
     *  Purpose: Sets up list containing all local fragments
     * */
    private void fillFragmentsList(){
        fragments.add(fragmentStart);
        fragments.add(fragmentExercises);
        fragments.add(fragmentHistory);
        fragments.add(fragmentLifetimeStats);
    }

    /** performInitTransaction()
     *  Purpose: Add all local fragments to the fragment manager.
     * */
    private void performInitTransaction(){
        FragmentTransaction transaction = fm.beginTransaction();

        int index = 2;
        for (Fragment f : fragments){
            if (f == active){
                transaction.add(R.id.statistics_container, f, "1");
            }
            else {
                transaction.add(R.id.statistics_container, f, String.valueOf(index)).hide(f);
                index++;
            }
        }
        transaction.add(R.id.navigation, navigationFragment);

        transaction.commit();
    }

    /** openFragment(Fragment)
     *  Purpose: Show parameter fragment and hide all other fragments.
     * */
    private void openFragment(Fragment fragment){
        FragmentTransaction transaction = fm.beginTransaction();

        for (Fragment f : fragments){
            if (f == fragment){
                transaction.show(f);
            }
            else {
                transaction.hide(f);
            }
        }
        transaction.commit();
    }

    /** openStatisticsStart(View)
     *  Purpose: Show the main page of this activity.
     *  (onClick-method)
     * */
    public void openStatisticsStart(View view){
        openFragment(fragmentStart);
    }

    /** openExercises(View)
     *  Purpose: Show the page "Exercises".
     *  (onClick-method)
     * */
    public void openExercises(View view){
        openFragment(fragmentExercises);
    }

    /** openHistory(View)
     *  Purpose: Show the page "History".
     *  (onClick-method)
     * */
    public void openHistory(View view){
        openFragment(fragmentHistory);
    }

    /** openLifetimeStats(View)
     *  Purpose: Show the page "Lifetime Stats".
     *  (onClick-method)
     * */
    public void openLifetimeStats(View view){
        openFragment(fragmentLifetimeStats);
    }
}
