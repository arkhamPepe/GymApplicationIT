package se.chalmers.group22.gymcompanion.View.MyRoutines;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import se.chalmers.group22.gymcompanion.Model.ViewModelObserver;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.ViewModel.MyRoutinesViewModel;

public class MyRoutinesRoutineInfoFragment extends Fragment implements ViewModelObserver {

    //variables for fragment_routine_routine_info.xml
    private MyRoutinesViewModel viewModel;

    public static MyRoutinesRoutineInfoFragment newInstance() {
        MyRoutinesRoutineInfoFragment fragment = new MyRoutinesRoutineInfoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_routine_routine_info, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        viewModel = ((MyRoutinesActivity)getActivity()).getBrowseViewModel(); // Get the ViewModel

        viewModel.addObserver(this);

        MyRoutinesUserExercisesListAdapter adapter = new MyRoutinesUserExercisesListAdapter(
                getActivity(),
                viewModel.getSelectedRoutineExercisesNames(),
                viewModel.getSelectedRoutineExercisesSetAmount()
        );
        ListView listView = getView().findViewById(R.id.listViewExercise);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                ((MyRoutinesActivity)getActivity()).onClickEnterExercise(position);
            }
        });
    }

    @Override
    public void onPause(){
        super.onPause();

        viewModel.removeObserver(this);
    }

    public void update(){
        EditText edittextRoutineName = getView().findViewById(R.id.txtEditMyRoutinesInfoRoutineName);

        TextView textViewAmountOfExercises = getView().findViewById(R.id.textViewRoutineInfoAmountOfExercises);

        edittextRoutineName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                viewModel.setSelectedRoutineName(edittextRoutineName.getText().toString());
                return false;

            }
        });

        edittextRoutineName.setText(viewModel.getSelectedRoutineName());
        textViewAmountOfExercises.setText(viewModel.getSelectedRoutineExerciseAmount());

        MyRoutinesUserExercisesListAdapter adapter = new MyRoutinesUserExercisesListAdapter(
                getActivity(),
                viewModel.getSelectedRoutineExercisesNames(),
                viewModel.getSelectedRoutineExercisesSetAmount()
        );
        ListView listView = getView().findViewById(R.id.listViewExercise);
        listView.setAdapter(adapter);
    }
}