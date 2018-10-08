package se.chalmers.group22.gymcompanion.View.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.*;
import se.chalmers.group22.gymcompanion.View.Progress.ProgressActivity;
import se.chalmers.group22.gymcompanion.ViewModel.MainViewModel;

public class MainActivity extends AppCompatActivity implements IView {

    private static final int index = 0;

    final Fragment fragmentHome = new MainStartFragment();
    final Fragment fragmentFinished = new MainFinishedFragment();
    final Fragment navigationFragment = new NavigationFragment();
    final FragmentManager fm = getSupportFragmentManager();

    private MainViewModel mainViewModel = new MainViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView todaysRoutine = findViewById(R.id.textViewTodayRoutine);

        todaysRoutine.setText(mainViewModel.getScheduledRoutineName());

        FragmentTransaction transaction = fm.beginTransaction();

        if(getIntent().getExtras() != null) {
            transaction.add(R.id.main_container, fragmentFinished, "2");
            transaction.add(R.id.main_container, fragmentHome, "1").hide(fragmentHome);
        }
        else{
            transaction.add(R.id.main_container, fragmentFinished, "2").hide(fragmentFinished);;
            transaction.add(R.id.main_container, fragmentHome, "1");
        }

        //Sends the activity index to NavigationFragment via Bundle
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        navigationFragment.setArguments(bundle);

        transaction.commit();


    }


    public void goToProgress(View view) {
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

