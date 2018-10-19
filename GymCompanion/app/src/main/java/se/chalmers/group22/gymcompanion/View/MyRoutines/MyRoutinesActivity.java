package se.chalmers.group22.gymcompanion.View.MyRoutines;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.BaseActivity;
import se.chalmers.group22.gymcompanion.View.Browse.BrowseActivity;
import se.chalmers.group22.gymcompanion.View.FragmentOrganizer;
import se.chalmers.group22.gymcompanion.View.NavigationFragment;
import se.chalmers.group22.gymcompanion.ViewModel.MyRoutinesViewModel;

import java.util.ArrayList;
import java.util.List;

public class MyRoutinesActivity extends BaseActivity {

    public static final int index = 3;

    private MyRoutinesViewModel viewModel;
    private final Fragment navigationFragment = new NavigationFragment();
    private final FragmentManager fm = getSupportFragmentManager();
    private FragmentOrganizer fo;

    private final Fragment fragmentStart = new MyRoutinesStartFragment();
    private final Fragment fragmentRoutineInfo = new MyRoutinesRoutineInfoFragment();
    private final Fragment fragmentExerciseInfo = new MyRoutinesExerciseInfoFragment();
    private final Fragment fragmentStrengthExercise = new MyRoutinesStrengthExerciseFragment();
    private List<Fragment> fragments = new ArrayList<>();



    //Variables for listitem_my_routines.xml
    private TextView routineName;
    private TextView amountOfExercises;

    //Variables for listitem_my_routines_sets.xml
    private TextView setNumber;
    private NumberPicker setReps;
    private NumberPicker setWeight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_routines);

        viewModel = new MyRoutinesViewModel();

        //Sends the activity index to NavigationFragment via Bundle
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        navigationFragment.setArguments(bundle);

        fillFragmentsList();

        fo = new FragmentOrganizer(fragments, fm,
                navigationFragment, R.id.my_routines_container);

        fo.setUpFragments(fragmentStart);
    }

    private void fillFragmentsList(){
        fragments.add(fragmentStrengthExercise);
        fragments.add(fragmentExerciseInfo);
        fragments.add(fragmentRoutineInfo);
        fragments.add(fragmentStart);
    }

    public void onClickCreateRoutine(View view){
        viewModel.createRoutine();
        //fragmentStart.update();
        fo.changeToFragment(fragmentRoutineInfo);
    }
    /*public void createRoutine(View view){
        dataHandler.createRoutine();
    }*/

    public void onClickAddExercise(View view){
        Intent intent = new Intent(this, BrowseActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.putExtra("MyRoutines",true);
        //viewModel.addExercise();
        startActivity(intent);

    }

    public MyRoutinesViewModel getViewModel(){
        return viewModel;
    }

    public void setRoutineName(View view){
        routineName.setText(viewModel.getSelectedRoutineName());
    }

    public void onClickEnterRoutine(int position){
        viewModel.setSelectedRoutineIndex(position);
        //fragmentRoutineInfo.update();
        fo.changeToFragment(fragmentRoutineInfo);
    }

    public void onClickEnterExercise(int position){
        viewModel.setSelectedExerciseIndex(position);
        //fragmentExerciseInfo.update();
        fo.changeToFragment(fragmentExerciseInfo);
    }

    public void goBackFromExercise(View view){
        //fragmentRoutineInfo.update();
        fo.changeToFragment(fragmentRoutineInfo);
    }

    public void goBackFromRoutine(View view){
        fo.changeToFragment(fragmentStart);
    }
}
