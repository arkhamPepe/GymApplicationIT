package se.chalmers.group22.gymcompanion.View.Browse;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import se.chalmers.group22.gymcompanion.View.NavigationFragment;
import se.chalmers.group22.gymcompanion.ViewModel.BrowsePresenter;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.Main.MainActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.Browse.BrowseStartFragment;

public class BrowseActivity extends AppCompatActivity {

    public static final int index = 1;
    final Fragment fragmentStart = new BrowseStartFragment();
    final Fragment navigationFragment = new NavigationFragment();
    final FragmentManager fm = getSupportFragmentManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);


        SearchView searchView = findViewById(R.id.searchBar);
/*
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextChange(String newText) {
                browsePresenter.search(newText);
                return false;
            }
            @Override
            public boolean onQueryTextSubmit(String query) {
                browsePresenter.search(query);
                return false;
            }
        });*/

        //Sends the activity index to NavigationFragment via Bundle
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        navigationFragment.setArguments(bundle);

        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.browse_container, fragmentStart, "1");
        transaction.add(R.id.navigation, navigationFragment);
        transaction.commit();
    }
}
