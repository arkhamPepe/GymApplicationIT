package se.chalmers.group22.gymcompanion.View.Main;

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
import se.chalmers.group22.gymcompanion.View.*;
import se.chalmers.group22.gymcompanion.View.Progress.ProgressActivity;

public class MainActivity extends AppCompatActivity implements IView {

    public static final int index = 0;

    final Fragment fragmentHome = new MainStartFragment();
    final Fragment fragmentFinished = new MainFinishedFragment();
    final FragmentManager fm = getSupportFragmentManager();

    private TextView todaysRoutine = findViewById(R.id.textViewTodayRoutine);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //todaysRoutine.setText();

        FragmentTransaction transaction = fm.beginTransaction();

        if(getIntent().getExtras() != null) {
            transaction.add(R.id.main_container, fragmentFinished, "2");
            transaction.add(R.id.main_container, fragmentHome, "1").hide(fragmentHome);
        }
        else{
            transaction.add(R.id.main_container, fragmentFinished, "2").hide(fragmentFinished);;
            transaction.add(R.id.main_container, fragmentHome, "1");
        }

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

    public void goToProgress(View view){
        Intent intent = new Intent(this, ProgressActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    public void goToHome(View view){
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.hide(fragmentFinished);
        transaction.show(fragmentHome);
        transaction.commit();
    }
}