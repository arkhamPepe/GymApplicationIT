package se.chalmers.group22.gymcompanion.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.*;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.Browse.BrowseActivity;
import se.chalmers.group22.gymcompanion.View.Home.HomeActivity;
import se.chalmers.group22.gymcompanion.View.MyRoutines.MyRoutinesActivity;
import se.chalmers.group22.gymcompanion.View.Schedule.ScheduleActivity;
import se.chalmers.group22.gymcompanion.View.Statistics.StatisticsActivity;

/***
 * Title: NavigationFragment
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: September 20, 2018
 *
 * Purpose: Fragment used by several activities. Handles travel between activities.
 * Fragment connected to a xml displaying the Bottom Navigation Bar in the app
 *
 * Used by: FragmentFactory.java
 *
 * Uses: HomeActivity.java, BrowseActivity.java, ScheduleActivity.java, MyRoutinesActivity.java
 * StatisticsActivity.java
 *
 */

public class NavigationFragment extends Fragment {
    /** pageIndex
     * @value get set by the bundle "index" argument
     * */
    private int pageIndex;

    public static NavigationFragment newInstance(){
        return new NavigationFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        pageIndex = this.getArguments().getInt("index", 0);
        return inflater.inflate(R.layout.fragment_navigation, container, false);
    }


    /** onStart()
     *  Sets an intent for each activity in the nav bar, uses the index from corresponding activity
     *  to change the color on the nav bar item you are on.
     *  Starts new activity via onNavigationItemSelected with its intent and overrides the standard android
     *  transition between activities (swipe animation).
     * */
    public void onStart(){
        super.onStart();
        Intent intentHome = new Intent(getActivity(), HomeActivity.class);
        Intent intentBrowse = new Intent(getActivity(), BrowseActivity.class);
        Intent intentSchedule = new Intent(getActivity(), ScheduleActivity.class);
        Intent intentMyRoutines = new Intent(getActivity(), MyRoutinesActivity.class);
        Intent intentStatistics = new Intent(getActivity(), StatisticsActivity.class);

        BottomNavigationView bottomNavigationView = getView().findViewById(R.id.navigation);

        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(pageIndex);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Intent intent;
                        switch (item.getItemId()) {
                            case R.id.action_item1:
                                intent = intentHome;
                                break;
                            case R.id.action_item2:
                                intent = intentBrowse;
                                break;
                            case R.id.action_item3:
                                intent = intentSchedule;
                                break;
                            case R.id.action_item4:
                                intent = intentMyRoutines;
                                break;
                            case R.id.action_item5:
                                intent = intentStatistics;
                                break;
                            default:
                                intent = intentHome;
                                break;
                        }

                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                                Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        getActivity().overridePendingTransition(0, 0);
                        return true;
                    }
                });
    }
}
