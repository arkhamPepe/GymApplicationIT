package se.chalmers.group22.gymcompanion.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.Statistics.StatisticsExercisesFragment;
import se.chalmers.group22.gymcompanion.View.Statistics.StatisticsHistoryFragment;
import se.chalmers.group22.gymcompanion.View.Statistics.StatisticsLifetimeStatsFragment;
import se.chalmers.group22.gymcompanion.View.Statistics.StatisticsStartFragment;

import java.util.ArrayList;
import java.util.List;

public class StatisticsActivity extends AppCompatActivity {

    public static final int index = 4; // Defines which item that represents this activity in the bottom navigation

    // Local fragments for the statistics activity
    final Fragment fragmentStart = new StatisticsStartFragment();
    final Fragment fragmentExercises = new StatisticsExercisesFragment();
    final Fragment fragmentHistory = new StatisticsHistoryFragment();
    final Fragment fragmentLifetimeStats = new StatisticsLifetimeStatsFragment();

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

        fillFragmentsList();
        performInitTransaction();

        Intent intent1 = new Intent(this, MainActivity.class);
        Intent intent2 = new Intent(this, BrowseActivity.class);
        Intent intent3 = new Intent(this, ScheduleActivity.class);
        Intent intent4 = new Intent(this, MyRoutinesActivity.class);
        Intent intent5 = new Intent(this, StatisticsActivity.class);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);

        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(index);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Intent intent;
                        switch (item.getItemId()) {
                            case R.id.action_item1:
                                intent = intent1;
                                break;
                            case R.id.action_item2:
                                intent = intent2;
                                break;
                            case R.id.action_item3:
                                intent = intent3;
                                break;
                            case R.id.action_item4:
                                intent = intent4;
                                break;
                            case R.id.action_item5:
                                intent = intent5;
                                break;
                            default:
                                intent = intent1;
                                break;
                        }
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                                Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                        return true;
                    }
                });
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
