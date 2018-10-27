package se.chalmers.group22.gymcompanion.View.MyRoutines;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.Model.ViewModelObserver;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.ViewModel.MyRoutinesViewModel;

/***
 * Title: MyRoutinesCardioExerciseFragment
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 2, 2018
 *
 * Purpose: Fragment connected to a xml displaying the Cardio Exercise fragment in the app
 * Uses: MyRoutinesViewModel.java, fragment_routine_setcardioexercise.xml, MyRoutinesActivity.java
 * Used by: MyRoutinesActivity.java
 */
public class MyRoutinesCardioExerciseFragment extends Fragment implements ViewModelObserver {

    private MyRoutinesViewModel viewModel;
    public static MyRoutinesCardioExerciseFragment newInstance() {
        MyRoutinesCardioExerciseFragment fragment = new MyRoutinesCardioExerciseFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_routine_setcardioexercise, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        viewModel = ((MyRoutinesActivity)getActivity()).getViewModel(); // Get the ViewModel

        update();
        viewModel.addObserver(this);

    }

    @Override
    public void onPause(){
        super.onPause();
        viewModel.removeObserver(this);
    }

    public void update() {
        TextView txtViewCardioName = getView().findViewById(R.id.txtViewCardioExerciseName);
        txtViewCardioName.setText(viewModel.getExerciseName());

        TextView cardioTime = getView().findViewById(R.id.cardioExerciseTime);
        cardioTime.setText(String.valueOf(viewModel.getSelectedCardioExerciseTime()));

        TextView cardioIntensity = getView().findViewById(R.id.cardioExerciseIntensity);
        cardioIntensity.setText(viewModel.getSelectedCardioExerciseIntensity());
    }
}
