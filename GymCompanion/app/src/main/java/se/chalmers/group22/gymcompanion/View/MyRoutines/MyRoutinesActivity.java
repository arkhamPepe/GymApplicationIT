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
    private final Fragment fragmentPickExercise = new MyRoutinesPickExerciseFragment();
    private final Fragment fragmentPickMG = new MyRoutinesPickMGFragment();
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
        fragments.add(fragmentPickExercise);
        fragments.add(fragmentPickMG);
    }

    public void onClickCreateRoutine(View view){
        viewModel.createRoutine();
        fo.changeToFragment(fragmentRoutineInfo);
    }

    public void onClickPickMG(View view){
        goToPickExercise(view);
    }

    public void goToRoutineInfo(View view){
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.show(fragmentRoutineInfo);
        transaction.hide(fragmentPickMG);
        transaction.commit();
    }

    public void goToPickExercise(View view){
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.show(fragmentPickExercise);
        transaction.hide(fragmentPickMG);
        transaction.commit();
    }

    public void goToPickMG(View view){
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.show(fragmentPickMG);
        transaction.hide(fragmentRoutineInfo);
        transaction.hide(fragmentPickExercise);
        transaction.commit();
    }

    /* TODO Add stuff */
    public void onClickAddExercise(View view){
        goToPickMG(view);
    }

    public MyRoutinesViewModel getViewModel(){
        return viewModel;
    }

    public void setRoutineName(View view){
        routineName.setText(viewModel.getSelectedRoutineName());
    }

    public void onClickEnterRoutine(int position){
        viewModel.setSelectedRoutineIndex(position);
        fo.changeToFragment(fragmentRoutineInfo);
    }

    public void onClickEnterExercise(int position){
        viewModel.setSelectedExerciseIndex(position);
        fo.changeToFragment(fragmentExerciseInfo);
    }

    public void goBackFromExercise(View view){
        fo.changeToFragment(fragmentRoutineInfo);
    }

    public void goBackFromRoutine(View view){
        fo.changeToFragment(fragmentStart);
    }
}
