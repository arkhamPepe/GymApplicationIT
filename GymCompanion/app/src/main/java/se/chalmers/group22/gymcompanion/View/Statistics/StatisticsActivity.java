package se.chalmers.group22.gymcompanion.View.Statistics;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.*;
import se.chalmers.group22.gymcompanion.ViewModel.StatisticsViewModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
/***
 * Title: StatisticsActivity
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 5, 2018
 *
 * Purpose: Manages user interaction and handles which Fragments are in view of the user when this Activity is active
 * Uses: StatisticsViewModel.java, FragmentFactory.java, FragmentOrganizer.java
 * Used by: NavigationFragment.java, StatisticsHistoryDetailsFragment.java, StatisticsHistoryFragment.java,
 *          StatisticsLifetimeStatsFragment.java, StatisticsStartFragment.java
 */
public class StatisticsActivity extends ObserverActivity {

    public static final int index = 4; // Defines which item that represents this activity in the bottom navigation

    //The ViewModel should be created/die along the View
    private StatisticsViewModel viewModel = new StatisticsViewModel();

    // Local fragments for the statistics activity
    private final Fragment fragmentStart = FragmentFactory.createStatisticsStartFragment();
    private final Fragment fragmentHistory = FragmentFactory.createStatisticsHistoryFragment();
    private final Fragment fragmentLifetimeStats = FragmentFactory.createStatisticsLifetimeStatsFragment();
    private final Fragment fragmentHistoryDetails = FragmentFactory.createStatisticsHistoryDetailsFragment();

    private final Fragment navigationFragment = FragmentFactory.createNavigationFragment();

    Fragment active = fragmentStart; // The fragment shown when this activity is created
    private List<Fragment> fragments = new ArrayList<>(); // Collection of all local fragments

    private final FragmentManager fm = getSupportFragmentManager(); // Object that handles transitions between local fragments
    private FragmentOrganizer fo;

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

        fo = new FragmentOrganizer(fragments, fm,
                navigationFragment, R.id.statistics_container);

        fo.setUpFragments(fragmentStart);
    }

    /** fillFragmentsList()
     *  Purpose: Sets up list containing all local fragments
     * */
    private void fillFragmentsList(){
        fragments.add(fragmentStart);
        fragments.add(fragmentHistory);
        fragments.add(fragmentLifetimeStats);
        fragments.add(fragmentHistoryDetails);
    }

    /** onRoutineClick
     * Purpose: Show details about clicked routine.
     */
    public void onRoutineClick(Calendar time){
        viewModel.setSelectedDate(time);
        goToHistoryDetails();
    }

    /** onClickButtonNextWeek
     * Purpose: Displays graph data for next week relative to the currently displayed week
     * @param view
     */
    public void onClickButtonNextWeek(View view){
        viewModel.setGraphedDateNextWeek();
    }

    /** onClickButtonPreviousWeek
     * Purpose: Displays graph data for previous week relative to the currently displayed week
     * @param view
     */
    public void onClickButtonPreviousWeek(View view){
        viewModel.setGraphedDatePreviousWeek();
    }

    /** goToStatisticsStart(View)
     *  Purpose: Show the main page of this activity.
     *  (onClick-method)
     * */
    public void goToStatisticsStart(View view){
        fo.changeToFragment(fragmentStart);
    }

    /** goToHistory(View)
     *  Purpose: Show the page "History".
     *  (onClick-method)
     * */
    public void goToHistory(View view){
        fo.changeToFragment(fragmentHistory);
    }

    /** goToLifetimeStats(View)
     *  Purpose: Show the page "Lifetime Stats".
     *  (onClick-method)
     * */
    public void goToLifetimeStats(View view){
        fo.changeToFragment(fragmentLifetimeStats);
    }

    /** goToHistoryDetails(View)
     *  Purpose: Show detailed view about completed routine.
     *  (onClick-method)
     * */
    public void goToHistoryDetails(){
        fo.changeToFragment(fragmentHistoryDetails);
    }

    public StatisticsViewModel getViewModel(){
        return viewModel;
    }


}
