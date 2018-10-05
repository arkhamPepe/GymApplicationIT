package se.chalmers.group22.gymcompanion.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.*;
import se.chalmers.group22.gymcompanion.Presenter.SchedulePresenter;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.Main.MainActivity;

public class ScheduleActivity extends AppCompatActivity implements INavigation, IScheduleView {

    public static final int index = 2;

    private ListView schedule_lv;
    private SchedulePresenter schedulePresenter = new SchedulePresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_schedule);


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
        Intent intent = new Intent(this, MyRoutinesActivity.class);
        startActivity(intent);
    }

    @Override
    public void startActivitySchedule(View view) {
        // NOTHING
    }
}
