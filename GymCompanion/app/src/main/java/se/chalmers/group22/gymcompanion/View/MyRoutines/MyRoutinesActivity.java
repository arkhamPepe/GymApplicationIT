package se.chalmers.group22.gymcompanion.View.MyRoutines;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.*;
import se.chalmers.group22.gymcompanion.ViewModel.MyRoutinesViewModel;

import java.util.ArrayList;
import java.util.List;
/***
 * Title: MyRoutinesActivity
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 18, 2018
 *
 * Purpose: Manages user interaction and handles which Fragments are in view of the user when this activity is active
 * Used by: NavigationFragment.java, MyRoutinesCardioExerciseFragment.java, MyRoutinesExerciseInfoFragment.java,
 *          MyRoutinesPickExerciseFragment.java, MyRoutinesPickMGFragment.java, MyRoutinesRoutineInfoFragment.java,
 *          MyRoutinesStartFragment.java, MyRoutinesStrengthExerciseFragment.java, MyRoutinesStrengthExerciseSetsAdapter.java
 * Uses: MyRoutinesViewModel.java, NavigationFragment.java, MyRoutinesStartFragment.java, MyRoutinesPickMGFragment.java,
 *       MyRoutinesRoutineInfoFragment.java, MyRoutinesExerciseInfoFragment.java, MyRoutinesPickExerciseFragment.java,
 *       MyRoutinesStrengthExerciseFragment.java, MyRoutinesCardioExercise.java
 */
public class MyRoutinesActivity extends ObserverActivity {

    public static final int index = 3;

    private MyRoutinesViewModel viewModel;
    private final Fragment navigationFragment = FragmentFactory.createNavigationFragment();
    private final FragmentManager fm = getSupportFragmentManager();
    private FragmentOrganizer fo;

    private final Fragment fragmentStart = FragmentFactory.createMyRoutinesStartFragment();
    private final Fragment fragmentRoutineInfo = FragmentFactory.createMyRoutinesRoutineInfoFragment();
    private final Fragment fragmentExerciseInfo = FragmentFactory.createMyRoutinesExerciseInfoFragment();
    private final Fragment fragmentPickExercise = FragmentFactory.createMyRoutinesPickExerciseFragment();
    private final Fragment fragmentPickMG = FragmentFactory.createMyRoutinesPickMGFragment();
    private final Fragment fragmentStrengthExercise = FragmentFactory.createMyRoutinesStrengthExerciseFragment();
    private final Fragment fragmentCardioExercise = FragmentFactory.createMyRoutinesCardioExerciseFragment();
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
        fragments.add(fragmentCardioExercise);
    }

    public void onClickCreateRoutine(View view){
        fo.changeToFragment(fragmentRoutineInfo);
        viewModel.createRoutine();
    }

    public void onClickPickMG(View view){
        goToPickExercise(view);
    }

    public void goToRoutineInfo(View view){
        fo.changeToFragment(fragmentRoutineInfo);
    }

    public void goToPickExercise(View view){
        fo.changeToFragment(fragmentPickExercise);
    }

    public void goToPickMG(View view){
        viewModel.notifyObservers();
        fo.changeToFragment(fragmentPickMG);

    }

    /* TODO Add stuff */
    public void onClickAddExercise(View view){
        goToPickMG(view);
    }

    public MyRoutinesViewModel getBrowseViewModel(){
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
        if(viewModel.checkTypeExercise() == 1){
            fo.changeToFragment(fragmentStrengthExercise);
        }
        else {
            fo.changeToFragment(fragmentCardioExercise);
        }
    }

    public void updateSelectedExerciseKilogramInSet(int index, int value){
        viewModel.updateSelectedExerciseKilogramInSet(index, value);
    }

    public void updateSelectedExerciseRepsInSet(int index, int value){
        viewModel.updateSelectedExerciseRepsInSet(index, value);
    }

    public void goBackFromExercise(View view){
        viewModel.notifyObservers();
        fo.changeToFragment(fragmentRoutineInfo);
    }

    public void goBackFromRoutine(View view){
        fo.changeToFragment(fragmentStart);
    }

    public void onAddClick(View view){
        viewModel.addExercise((String)view.getTag());
    }

    public MyRoutinesViewModel getViewModel() {
        return viewModel;
    }
    public void onDeleteClick(View view){
        viewModel.removeExercise((String)view.getTag());

    }
    public void onDeleteClickRoutine(View view){
        viewModel.removeSelectedRoutine((int)view.getTag());
    }
}
