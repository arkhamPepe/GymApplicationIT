package se.chalmers.group22.gymcompanion.View.Progress;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.BaseActivity;
import se.chalmers.group22.gymcompanion.View.FragmentOrganizer;
import se.chalmers.group22.gymcompanion.View.Home.HomeActivity;
import se.chalmers.group22.gymcompanion.ViewModel.ProgressViewModel;

import java.util.ArrayList;
import java.util.List;

/***
 * Title: ProgressActivity
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 5, 2018
 *
 * Purpose: Manages user interaction and handles which Fragments are in view of the user when this Activity is active
 */

public class ProgressActivity extends BaseActivity {

    private final FragmentManager fm = getSupportFragmentManager();
    private FragmentOrganizer fo;
    private final Fragment fragmentStart = new ProgressStartFragment();
    private final Fragment fragmentEditRoutine = new ProgressEditRoutineFragment();
    private List<Fragment> fragments = new ArrayList<>();

    private ProgressViewModel progressViewModel = new ProgressViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        fillFragmentsList();

        fo = new FragmentOrganizer(fragments, fm, R.id.progress_container);

        fo.setUpFragments(fragmentStart);

    }

    private void fillFragmentsList(){
        fragments.add(fragmentStart);
        fragments.add(fragmentEditRoutine);
    }

    public void goToStart(View view){
        fo.changeToFragment(fragmentStart);
    }

    public void goToEditRoutine(View view){
        fo.changeToFragment(fragmentEditRoutine);
    }

    //Goes back to HomeActivity with an extra boolean so that the Finished Fragment is in focus
    public void goToFinished(View view){

        progressViewModel.completeActiveRoutine();

        Intent intent = new Intent(this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_CLEAR_TASK);

        //Currently the value of the boolean doesn't matter, it only matters that it exists
        intent.putExtra("Finished Workout",true);

        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    //ESCAPE
    //Goes back to the start page of HomeActivity
    public void goToHome(View view){
        Intent intent = new Intent(this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    public void toggleCompleted(View view){
        if(((CheckBox)view).isChecked()){
            progressViewModel.toggleCompletionExerciseInARWithIndex((Integer)view.getTag(), true);
        }else{
            progressViewModel.toggleCompletionExerciseInARWithIndex((Integer)view.getTag(), false);
        }
    }

    public ProgressViewModel getViewModel(){
        return progressViewModel;
    }

}
