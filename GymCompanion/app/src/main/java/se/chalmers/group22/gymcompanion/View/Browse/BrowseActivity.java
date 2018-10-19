package se.chalmers.group22.gymcompanion.View.Browse;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.BaseActivity;
import se.chalmers.group22.gymcompanion.View.FragmentOrganizer;
import se.chalmers.group22.gymcompanion.View.NavigationFragment;
import se.chalmers.group22.gymcompanion.ViewModel.BrowseViewModel;

import java.util.ArrayList;
import java.util.List;

public class BrowseActivity extends BaseActivity {

    /** pageIndex
     * @value 1
     * */
    private static final int index = 1;
    private final Fragment fragmentStart = new BrowseStartFragment();
    private final Fragment fragmentSelection = new BrowseSelectionFragment();
    private final Fragment fragmentResult = new BrowseResultFragment();
    private final Fragment fragmentRecommended = new BrowseRecommendedFragment();
    private final Fragment navigationFragment = new NavigationFragment();
    private List<Fragment> fragments = new ArrayList<>();
    private final FragmentManager fm = getSupportFragmentManager();
    private FragmentOrganizer fo;

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

        fillFragmentsList();

        fo = new FragmentOrganizer(fragments,fm,navigationFragment,R.id.browse_container);

        if(getIntent().getExtras() != null){
            fo.setUpFragments(fragmentResult);
        }
        else {
            fo.setUpFragments(fragmentStart);
        }
    }

    private void fillFragmentsList(){
        fragments.add(fragmentStart);
        fragments.add(fragmentRecommended);
        fragments.add(fragmentResult);
        fragments.add(fragmentSelection);
    }

    public void goToStart(View view) {
        fo.changeToFragment(fragmentStart);
    }

    public void goToMuscleGroupSelection(View view){
        fo.changeToFragment(fragmentSelection);
    }

    public void goToRecommendedSelection(View view){
        fo.changeToFragment(fragmentRecommended);
    }

    public void resultBack(View view){

        switch(browseViewModel.getIndex()){
            case 0:
                fo.changeToFragment(fragmentStart);
                break;
            case 1:
                fo.changeToFragment(fragmentSelection);
                break;
            case 2:
                fo.changeToFragment(fragmentRecommended);
                break;
            case 3:
                fo.changeToFragment(fragmentRecommended);
                break;
            default:
                break;
        }
    }

    public void goToResult(String s) {
        fo.changeToFragment(fragmentResult);

        String x;
        x = s.replace(" ", "_");
        browseViewModel.setMuscleGroup(x);
        browseViewModel.setIndex(1);
        browseViewModel.filter(x);
        fragmentResult.onResume();
    }

    public void goToResultFromSearch(String s){

        fo.changeToFragment(fragmentResult);

        browseViewModel.setIndex(0);
        browseViewModel.search(s);
        fragmentResult.onResume();
    }

    public void goToResultFromRecommended(View view) {
        fo.changeToFragment(fragmentResult);

        int i = Integer.valueOf((String)view.getTag());
        browseViewModel.setIndex(i);

        fragmentResult.onResume();
    }

    public BrowseViewModel getViewModel(){
        return browseViewModel;
    }

}
