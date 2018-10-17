package se.chalmers.group22.gymcompanion.View.MyRoutines;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.BaseActivity;
import se.chalmers.group22.gymcompanion.View.NavigationFragment;
import se.chalmers.group22.gymcompanion.ViewModel.MyRoutinesViewModel;

public class MyRoutinesActivity extends BaseActivity {

    public static final int index = 3;

    private MyRoutinesViewModel viewModel;
    final Fragment navigationFragment = new NavigationFragment();
    final FragmentManager fm = getSupportFragmentManager();

    private final Fragment fragmentStart = new MyRoutinesStartFragment();
    private final MyRoutinesRoutineInfoFragment fragmentRoutineInfo = new MyRoutinesRoutineInfoFragment();
    private final Fragment fragmentExerciseInfo = new MyRoutinesExerciseInfoFragment();
    private final Fragment fragmentStrengthExercise = new MyRoutinesStrengthExerciseFragment();
    private Fragment active = fragmentStart;

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

        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.my_routines_container, fragmentExerciseInfo, "2").hide(fragmentExerciseInfo);
        transaction.add(R.id.my_routines_container, fragmentRoutineInfo, "2").hide(fragmentRoutineInfo);
        transaction.add(R.id.my_routines_container, fragmentStrengthExercise, "2").hide(fragmentStrengthExercise);
        transaction.add(R.id.my_routines_container, fragmentStart, "1");

        viewModel = new MyRoutinesViewModel();

        //Sends the activity index to NavigationFragment via Bundle
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        navigationFragment.setArguments(bundle);

        transaction.add(R.id.navigation,navigationFragment);

        transaction.commit();
    }

    public void onClickCreateRoutine(View view){
        viewModel.createRoutine();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.show(fragmentRoutineInfo);
        transaction.hide(fragmentStart);
        transaction.commit();
    }
    /*public void createRoutine(View view){
        dataHandler.createRoutine();
    }*/

    public void onClickAddExercise(View view){
        //viewModel.addExercise();
    }

    public MyRoutinesViewModel getViewModel(){
        return viewModel;
    }

    public void setRoutineName(View view){
        routineName.setText(viewModel.getSelectedRoutineName());
    }

    public void onClickEnterRoutine(int position){
        viewModel.setSelectedRoutineIndex(position);
        fragmentRoutineInfo.update();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.show(fragmentRoutineInfo);
        transaction.hide(fragmentStart);
        transaction.commit();

    }
}
