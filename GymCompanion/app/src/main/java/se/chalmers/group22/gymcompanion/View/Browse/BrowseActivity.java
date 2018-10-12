package se.chalmers.group22.gymcompanion.View.Browse;

import android.os.Bundle;
import android.view.View;
import se.chalmers.group22.gymcompanion.View.NavigationFragment;
import se.chalmers.group22.gymcompanion.R;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class BrowseActivity extends AppCompatActivity {

    public static final int index = 1;
    final Fragment fragmentStart = new BrowseStartFragment();
    final Fragment fragmentSelection = new BrowseSelectionFragment();
    final Fragment fragmentSelectedItem = new BrowseSelectedItemFragment();
    final Fragment navigationFragment = new NavigationFragment();
    final FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        //Sends the activity index to NavigationFragment via Bundle
        Bundle navBundle = new Bundle();
        navBundle.putInt("index", index);
        navigationFragment.setArguments(navBundle);

        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.browse_container, fragmentSelectedItem, "3").hide(fragmentSelectedItem);
        transaction.add(R.id.browse_container, fragmentSelection, "2").hide(fragmentSelection);
        transaction.add(R.id.browse_container, fragmentStart, "1");
        transaction.add(R.id.navigation, navigationFragment);
        transaction.commit();
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    public void goToBrowseSelection(View view){
        FragmentTransaction transaction = fm.beginTransaction();

        transaction.hide(fragmentStart);
        transaction.show(fragmentSelection);
        transaction.commit();
    }

    public void goToSelectedItem(View view){
        FragmentTransaction transaction = fm.beginTransaction();

        transaction.hide(fragmentSelection);
        transaction.show(fragmentSelectedItem);
        transaction.commit();
    }
}
