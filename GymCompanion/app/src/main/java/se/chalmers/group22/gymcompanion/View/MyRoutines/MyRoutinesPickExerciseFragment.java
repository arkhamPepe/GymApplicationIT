package se.chalmers.group22.gymcompanion.View.MyRoutines;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.Model.Observer;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.Browse.BrowseResultListAdapter;
import se.chalmers.group22.gymcompanion.ViewModel.MyRoutinesViewModel;

public class MyRoutinesPickExerciseFragment extends Fragment implements Observer {

    private MyRoutinesViewModel viewModel;

    public static MyRoutinesPickExerciseFragment newInstance() {
        MyRoutinesPickExerciseFragment fragment = new MyRoutinesPickExerciseFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_routines_pick_exercise, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        viewModel = ((MyRoutinesActivity)getActivity()).getViewModel(); //get the viewmodel
        viewModel.addObserver(this);

        BrowseResultListAdapter adapter = new BrowseResultListAdapter(getActivity(),
                viewModel.getExerciseNamesWithMG(viewModel.getSelectedMuscleGroup()),
                viewModel.getRoutineExercisesDifficulty(),viewModel.checkIfNoRoutine());
        ListView listView = getView().findViewById(R.id.listviewMyRoutinesPickExercise);
        listView.setAdapter(adapter);


    }

    @Override
    public void onPause(){
        super.onPause();
        viewModel.removeObserver(this);

    }

    @Override
    public void update() {
        TextView title = getView().findViewById(R.id.txtMyRoutinesPickExerciseTitle);
        title.setText(viewModel.getSelectedMuscleGroup().toString());

        BrowseResultListAdapter adapter = new BrowseResultListAdapter(getActivity(),
                viewModel.getExerciseNamesWithMG(viewModel.getSelectedMuscleGroup()),
                viewModel.getRoutineExercisesDifficulty(),viewModel.checkIfNoRoutine());
        ListView listView = getView().findViewById(R.id.listviewMyRoutinesPickExercise);
        listView.setAdapter(adapter);
    }
}
