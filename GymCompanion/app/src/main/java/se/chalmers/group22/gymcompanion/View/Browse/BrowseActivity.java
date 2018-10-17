package se.chalmers.group22.gymcompanion.View.Browse;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.BaseActivity;
import se.chalmers.group22.gymcompanion.View.NavigationFragment;
import se.chalmers.group22.gymcompanion.ViewModel.BrowseViewModel;

public class BrowseActivity extends BaseActivity {

    /** pageIndex
     * @value 1
     * */
    private static final int index = 1;
    private final Fragment fragmentStart = new BrowseStartFragment();
    private final Fragment fragmentSelection = new BrowseSelectionFragment();
    private final Fragment fragmentResult = new BrowseResultFragment();
    private final Fragment navigationFragment = new NavigationFragment();
    private final FragmentManager fm = getSupportFragmentManager();

    private BrowseViewModel browseViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        browseViewModel = new BrowseViewModel();

        //Sends the activity index to NavigationFragment via Bundle
        Bundle navBundle = new Bundle();
        navBundle.putInt("index", index);
        navigationFragment.setArguments(navBundle);

        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.browse_container, fragmentResult, "3").hide(fragmentResult);
        transaction.add(R.id.browse_container, fragmentSelection, "2").hide(fragmentSelection);
        transaction.add(R.id.browse_container, fragmentStart, "1");
        transaction.add(R.id.navigation, navigationFragment);
        transaction.commit();
    }

    public void goToBrowseSelection(View view){
        FragmentTransaction transaction = fm.beginTransaction();

        transaction.hide(fragmentStart);
        transaction.show(fragmentSelection);
        transaction.hide(fragmentResult);

        int i = Integer.valueOf((String)view.getTag());
        browseViewModel.setIndex(i);

        fragmentSelection.onResume();

        transaction.commit();
    }

    public void goToResult(View view) {
        FragmentTransaction transaction = fm.beginTransaction();

        transaction.hide(fragmentStart);
        transaction.hide(fragmentSelection);
        transaction.show(fragmentResult);

        String x = ((Button)view).getText().toString();
        x = x.replace(" ", "_");
        browseViewModel.setMuscleGroup(x);
        fragmentResult.onResume();

        transaction.commit();
    }

    public void goToStart(View view) {
        FragmentTransaction transaction = fm.beginTransaction();

        transaction.show(fragmentStart);
        transaction.hide(fragmentSelection);
        transaction.hide(fragmentResult);
        fragmentStart.onResume();
        transaction.commit();
    }

    public BrowseViewModel getViewModel(){
        return browseViewModel;
    }

}
