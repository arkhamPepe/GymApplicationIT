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
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.Main.MainActivity;
import se.chalmers.group22.gymcompanion.View.Browse.BrowseStartFragment;
import se.chalmers.group22.gymcompanion.View.MyRoutines.MyRoutinesStartFragment;

public class MyRoutinesActivity extends AppCompatActivity {

    public static final int index = 3;
    final Fragment fragmentStart = new MyRoutinesStartFragment();
    final Fragment navigationFragment = new NavigationFragment();
    final FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_routines);

        //Sends the activity index to NavigationFragment via Bundle
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        navigationFragment.setArguments(bundle);

        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.my_routines_container, fragmentStart, "1");
        transaction.add(R.id.navigation, navigationFragment);
        transaction.commit();
    }
}
