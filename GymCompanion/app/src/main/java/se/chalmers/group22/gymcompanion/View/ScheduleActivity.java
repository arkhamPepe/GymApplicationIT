package se.chalmers.group22.gymcompanion.View;

import android.app.ActionBar;
import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import se.chalmers.group22.gymcompanion.Presenter.SchedulePresenter;
import se.chalmers.group22.gymcompanion.R;

public class ScheduleActivity extends AppCompatActivity implements INavigation, IScheduleView {

    ListView schedule_lv;
    private SchedulePresenter schedulePresenter = new SchedulePresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_schedule);
        schedule_lv = findViewById(R.id.schedule_list);

        schedulePresenter.fillList();

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
        });
    }

    @Override
    public void startActivityBrowse(View view) {
        Intent intent = new Intent(this, BrowseActivity.class);
        startActivity(intent);
    }

    @Override
    public void startActivityMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void startActivityStatistics(View view) {
        Intent intent = new Intent(this, StatisticsActivity.class);
        startActivity(intent);
    }

    @Override
    public void startActivityMyRoutines(View view) {
        Intent intent = new Intent(this, MyRoutinesAcivity.class);
        startActivity(intent);
    }

    @Override
    public void startActivitySchedule(View view) {
        // NOTHING
    }
}
