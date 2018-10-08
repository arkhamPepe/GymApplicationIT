package se.chalmers.group22.gymcompanion.View;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.*;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.Browse.BrowseStartFragment;

public class ScheduleActivity extends AppCompatActivity {

    public static final int index = 2;
    final Fragment fragmentStart = new BrowseStartFragment();
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
        transaction.add(R.id.navigation, navigationFragment);
        transaction.commit();

        //fillSchedule();

        /*schedulePresenter.fillList();

        // Adapter takes activity context, type of list view and the array as parameters
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                schedulePresenter.getWeekdays());

        schedule_lv.setAdapter(arrayAdapter);

        schedule_lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            // argument position gives the index of item which is clicked
            public void onItemClick(AdapterView<?> arg0, View v,int position, long arg3)
            {
                String selectedweekday=schedulePresenter.getWeekdays().get(position);
                Toast.makeText(getApplicationContext(), "Weekday selected : "+ selectedweekday, Toast.LENGTH_LONG).show();
            }
        });*/
    }

    private void fillSchedule() {
        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.listitem_schedule, null);
        ViewGroup insertPoint = findViewById(R.id.schedule_list);

        for(int i = 0; i < 7; i++) {
            TextView dayOfWeek = view.findViewById(R.id.dayOfWeek);
            dayOfWeek.setText("");
            TextView routineName = view.findViewById(R.id.routineName);
            routineName.setText("");
            insertPoint.addView(view, i);
        }

    }
}
