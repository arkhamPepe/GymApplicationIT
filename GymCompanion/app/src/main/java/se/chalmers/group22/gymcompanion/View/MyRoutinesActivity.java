package se.chalmers.group22.gymcompanion.View;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import se.chalmers.group22.gymcompanion.Model.DataHandler;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.MyRoutines.MyRoutinesExerciseInfoFragment;
import se.chalmers.group22.gymcompanion.View.MyRoutines.MyRoutinesRoutineInfoFragment;
import se.chalmers.group22.gymcompanion.View.MyRoutines.MyRoutinesStartFragment;
import se.chalmers.group22.gymcompanion.View.MyRoutines.MyRoutinesStrengthExerciseFragment;

import java.util.List;

public class MyRoutinesActivity extends AppCompatActivity {

    private static final int index = 3;

    private final Fragment fragmentStart = new MyRoutinesStartFragment();
    private final Fragment fragmentRoutineInfo = new MyRoutinesRoutineInfoFragment();
    private final Fragment fragmentExerciseInfo = new MyRoutinesExerciseInfoFragment();
    private final Fragment fragmentStrengthExercise = new MyRoutinesStrengthExerciseFragment();
    private final FragmentManager fm = getSupportFragmentManager();
    private Fragment active = fragmentStart;
    private DataHandler dataHandler = DataHandler.getInstance();

    ListView routineList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_routines);

        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.my_routines_container, fragmentExerciseInfo, "2").hide(fragmentExerciseInfo);
        transaction.add(R.id.my_routines_container, fragmentRoutineInfo, "2").hide(fragmentRoutineInfo);
        transaction.add(R.id.my_routines_container, fragmentStrengthExercise, "2").hide(fragmentStrengthExercise);
        transaction.add(R.id.my_routines_container, fragmentStart, "1");

        routineList = findViewById(R.id.routineList);
        transaction.commit();

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
    public void createRoutine(View view){
    }
}
