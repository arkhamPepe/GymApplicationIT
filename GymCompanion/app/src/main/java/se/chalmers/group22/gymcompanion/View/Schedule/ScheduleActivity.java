package se.chalmers.group22.gymcompanion.View.Schedule;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ListView;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.BaseActivity;
import se.chalmers.group22.gymcompanion.View.NavigationFragment;
import se.chalmers.group22.gymcompanion.ViewModel.ScheduleViewModel;

public class ScheduleActivity extends BaseActivity {

    public static final int index = 2;
    private final Fragment fragmentStart = new ScheduleStartFragment();
    private final Fragment fragmentPickRoutine = new SchedulePickRoutineFragment();
    private final Fragment navigationFragment = new NavigationFragment();
    private final FragmentManager fm = getSupportFragmentManager();
    private ListView schedule_lv;

    private ScheduleViewModel viewModel = new ScheduleViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_schedule);

        schedule_lv = findViewById(R.id.schedule_list);

        //Sends the activity index to NavigationFragment via Bundle
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        navigationFragment.setArguments(bundle);

        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.schedule_container, fragmentStart, "1");
        transaction.add(R.id.schedule_container, fragmentPickRoutine, "2").hide(fragmentPickRoutine);
        transaction.add(R.id.navigation, navigationFragment);
        transaction.commit();
    }

    public void scheduleRoutine(){
        viewModel.scheduleSelectedRoutine();
    }

    public void goToPickRoutine(View view){
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.show(fragmentPickRoutine);
        transaction.hide(fragmentStart);
        transaction.commit();
    }

    public void goToStart(View view){
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.hide(fragmentPickRoutine);
        transaction.show(fragmentStart);
        transaction.commit();
    }

    public ScheduleViewModel getViewModel(){
        return viewModel;
    }
}
