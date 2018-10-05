package se.chalmers.group22.gymcompanion.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.Main.MainHomeFragment;
import se.chalmers.group22.gymcompanion.View.Main.MainProgressFragment;

public class MainActivity extends AppCompatActivity implements IView {

    public static final int index = 0;

    final Fragment fragmentHome = new MainHomeFragment();
    final Fragment fragmentProgress = new MainProgressFragment();
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = fragmentHome;

    private TextView workoutName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        workoutName = findViewById(R.id.workoutName);

        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.main_container, fragmentProgress, "2").hide(fragmentProgress);
        transaction.add(R.id.main_container, fragmentHome, "1");
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

    public void showProgress(View view){
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.show(fragmentProgress);
        transaction.hide(fragmentHome);
        transaction.commit();
    }

    public void showHome(View view){
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.hide(fragmentProgress);
        transaction.show(fragmentHome);
        transaction.commit();
    }

    public void startWorkout(View view){
        
    }

    public void setWorkoutName(String name){
        workoutName.setText(name);
    }

}

/*bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment;
                        switch (item.getItemId()) {
                            case R.id.action_item1:
                                selectedFragment = HomeStartFragment.newInstance();
                                break;
                            case R.id.action_item2:
                                selectedFragment = BrowseFragment.newInstance();
                                break;
                            case R.id.action_item3:
                                selectedFragment = ScheduleFragment.newInstance();
                                break;
                            case R.id.action_item4:
                                selectedFragment = MyRoutinesFragment.newInstance();
                                break;
                            case R.id.action_item5:
                                selectedFragment = StatisticsFragment.newInstance();
                                break;
                            default:
                                selectedFragment = HomeStartFragment.newInstance();
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });

        //Manually displaying the first fragment - one time only
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, HomeStartFragment.newInstance());
        transaction.commit();*/
