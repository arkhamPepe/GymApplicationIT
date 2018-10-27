package se.chalmers.group22.gymcompanion.View.Schedule;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ListView;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.*;
import se.chalmers.group22.gymcompanion.ViewModel.ScheduleViewModel;

import java.util.ArrayList;
import java.util.List;
/***
 * Title: ScheduleActivity
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
 * Uses: FragmentFactory.java, FragmentOrganizer.java, ScheduleViewModel.java
 * Used by: SchedulePickRoutineFragment.java, ScheduleStartFragment.java, NavigationFragment.java
 */
public class ScheduleActivity extends ObserverActivity {

    public static final int index = 2;
    private final Fragment startFragment = FragmentFactory.createScheduleStartFragment();
    private final Fragment pickRoutineFragment = FragmentFactory.createSchedulePickRoutineFragment();
    private final Fragment navigationFragment = FragmentFactory.createNavigationFragment();
    private List<Fragment> fragments = new ArrayList<>(); // Collection of all local fragments
    private final FragmentManager fm = getSupportFragmentManager();
    private FragmentOrganizer fo;
    private ListView schedule_lv;

    private ScheduleViewModel viewModel = new ScheduleViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_schedule);

        schedule_lv = findViewById(R.id.schedule_list);

        fillFragmentsList();

        fo = new FragmentOrganizer(fragments, fm,
                navigationFragment, R.id.schedule_container);

        fo.setUpFragments(startFragment);

        //Sends the activity index to NavigationFragment via Bundle
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        navigationFragment.setArguments(bundle);
    }

    /** fillFragmentsList()
     *  Purpose: Sets up list containing all local fragments
     * */
    private void fillFragmentsList(){
        fragments.add(startFragment);
        fragments.add(pickRoutineFragment);
    }

    public void scheduleRoutine(int routineIndex){
        viewModel.scheduleSelectedRoutine(routineIndex);
    }

    public void goToPickRoutine(View view){
        fo.changeToFragment(pickRoutineFragment);
    }

    public void goToStart(View view){
        fo.changeToFragment(startFragment);
    }

    public ScheduleViewModel getViewModel(){
        return viewModel;
    }
}
