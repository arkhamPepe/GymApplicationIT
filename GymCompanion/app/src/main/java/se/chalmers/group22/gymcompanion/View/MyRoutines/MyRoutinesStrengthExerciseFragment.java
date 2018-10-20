package se.chalmers.group22.gymcompanion.View.MyRoutines;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.Model.Observer;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.ViewModel.MyRoutinesViewModel;

public class MyRoutinesStrengthExerciseFragment extends Fragment implements Observer {

    private MyRoutinesViewModel viewModel;
    public static MyRoutinesStrengthExerciseFragment newInstance() {
        MyRoutinesStrengthExerciseFragment fragment = new MyRoutinesStrengthExerciseFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_routine_setstrengthexercise, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        viewModel = ((MyRoutinesActivity)getActivity()).getViewModel(); // Get the ViewModel
        update();
        viewModel.addObserver(this);

        MyRoutinesStrengthExerciseSetsAdapter adapter = new MyRoutinesStrengthExerciseSetsAdapter(
                getActivity(), viewModel.getStrengthExerciseKilograms(), viewModel.getStrengthExerciseReps()
        );
        ListView listView = getView().findViewById(R.id.setsList);
        listView.setAdapter(adapter);

    }

    @Override
    public void onPause(){
        super.onPause();
        viewModel.removeObserver(this);
    }

    public void update(){
        TextView txtviewStrenghtExerciseName = getView().findViewById(R.id.txtViewStrenghtExerciseName);
        txtviewStrenghtExerciseName.setText(viewModel.getExerciseName());

        NumberPicker amountOfSets = getView().findViewById(R.id.amountofSets);

        MyRoutinesStrengthExerciseSetsAdapter adapter = new MyRoutinesStrengthExerciseSetsAdapter(
                getActivity(), viewModel.getStrengthExerciseKilograms(), viewModel.getStrengthExerciseReps()
        );
        ListView listView = getView().findViewById(R.id.setsList);
        listView.setAdapter(adapter);

    }
}
