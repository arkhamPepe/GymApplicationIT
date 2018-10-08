package se.chalmers.group22.gymcompanion.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.Statistics.StatisticsStartFragment;

public class StatisticsActivity extends AppCompatActivity {

    public static final int index = 4;
    final Fragment fragmentStart = new StatisticsStartFragment();
    //final Fragment fragmentProgress = new MainProgressFragment();
    final Fragment navigationFragment = new NavigationFragment();
    final FragmentManager fm = getSupportFragmentManager();
    //Fragment active = fragmentHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        //Sends the activity index to NavigationFragment via Bundle
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        navigationFragment.setArguments(bundle);

        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.statistics_container, fragmentStart, "1");
        transaction.add(R.id.navigation, navigationFragment);
        transaction.commit();
    }
}
