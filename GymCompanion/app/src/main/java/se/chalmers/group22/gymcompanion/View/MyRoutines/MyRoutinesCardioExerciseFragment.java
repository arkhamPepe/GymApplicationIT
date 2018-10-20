package se.chalmers.group22.gymcompanion.View.MyRoutines;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.Model.Observer;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.ViewModel.MyRoutinesViewModel;

public class MyRoutinesCardioExerciseFragment extends Fragment implements Observer {
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
        return inflater.inflate(R.layout.fragment_routine_cardioexercise, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        viewModel = ((MyRoutinesActivity)getActivity()).getViewModel(); // Get the ViewModel

        update();
        viewModel.addObserver(this);

    }

    public void update() {
        TextView txtViewCardioName = getView().findViewById(R.id.txtViewCardioExerciseName);
        txtViewCardioName.setText(viewModel.getExerciseName());
    }
}
