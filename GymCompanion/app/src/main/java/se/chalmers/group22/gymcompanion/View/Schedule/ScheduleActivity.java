package se.chalmers.group22.gymcompanion.View.Schedule;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.MyRoutines.MyRoutinesStartFragment;
import se.chalmers.group22.gymcompanion.View.NavigationFragment;

public class ScheduleActivity extends AppCompatActivity {

    public static final int index = 2;
    final Fragment fragmentStart = new ScheduleStartFragment();
    final Fragment fragmentPickRoutine = new SchedulePickRoutineFragment();
    final Fragment navigationFragment = new NavigationFragment();
    final FragmentManager fm = getSupportFragmentManager();
    private ListView schedule_lv;

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
}
