package se.chalmers.group22.gymcompanion.View.Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.BaseActivity;
import se.chalmers.group22.gymcompanion.View.FragmentOrganizer;
import se.chalmers.group22.gymcompanion.View.NavigationFragment;
import se.chalmers.group22.gymcompanion.View.Progress.ProgressActivity;
import se.chalmers.group22.gymcompanion.ViewModel.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

/***
 * Title: HomeActivity
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: September 20, 2018
 *
 * Purpose: Manages user interaction and handles which Fragments are in view of the user when this activity is active
 */

public class HomeActivity extends BaseActivity {

    private static final int index = 0;

    private final Fragment fragmentHome = new HomeStartFragment();
    private final Fragment fragmentFinished = new HomeFinishedFragment();
    private final Fragment navigationFragment = new NavigationFragment();
    private final FragmentManager fm = getSupportFragmentManager();
    private FragmentOrganizer fo;
    private List<Fragment> fragments = new ArrayList<>();

    private HomeViewModel homeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeViewModel = new HomeViewModel();

        homeViewModel.startRoutine();

        //Sends the activity index to NavigationFragment via Bundle
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        navigationFragment.setArguments(bundle);

        fillFragmentsList();

        fo = new FragmentOrganizer(fragments, fm,
                navigationFragment, R.id.main_container);

        if(getIntent().getExtras() != null) {
            fo.setUpFragments(fragmentFinished);
        }
        else{
            fo.setUpFragments(fragmentHome);
        }


    }

    private void fillFragmentsList(){
        fragments.add(fragmentHome);
        fragments.add(fragmentFinished);
    }

    public void goToProgress(View view) {
        Intent intent = new Intent(this, ProgressActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    public void goToHome(View view){
        fo.changeToFragment(fragmentHome);
    }

    public HomeViewModel getViewModel(){
        return homeViewModel;
    }

    
}

