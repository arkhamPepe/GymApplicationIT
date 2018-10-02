package se.chalmers.group22.gymcompanion.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import se.chalmers.group22.gymcompanion.Presenter.SchedulePresenter;
import se.chalmers.group22.gymcompanion.R;

public class ScheduleActivity extends AppCompatActivity implements INavigation, IScheduleView {

    private ListView schedule_lv;
    private SchedulePresenter schedulePresenter = new SchedulePresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_schedule);
        schedule_lv = findViewById(R.id.schedule_list);

        //fillSchedule();

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
