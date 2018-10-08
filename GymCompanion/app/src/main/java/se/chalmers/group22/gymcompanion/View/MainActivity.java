package se.chalmers.group22.gymcompanion.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.Main.MainHomeFragment;
import se.chalmers.group22.gymcompanion.View.Main.MainProgressFragment;

public class MainActivity extends AppCompatActivity implements IView {

    public static final int index = 0;

    final Fragment fragmentStart = new MainHomeFragment();
    final Fragment fragmentProgress = new MainProgressFragment();
    final Fragment navigationFragment = new NavigationFragment();
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = fragmentStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Sends the activity index to NavigationFragment via Bundle
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        navigationFragment.setArguments(bundle);

        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.main_container, fragmentProgress, "2").hide(fragmentProgress);
        transaction.add(R.id.main_container, fragmentStart, "1");
        transaction.add(R.id.navigation, navigationFragment);
        transaction.commit();


    }

    public void showProgress(View view){
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.show(fragmentProgress);
        transaction.hide(fragmentStart);
        transaction.commit();
    }

    public void showHome(View view){
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.hide(fragmentProgress);
        transaction.show(fragmentStart);
        transaction.commit();
    }
}
