package se.chalmers.group22.gymcompanion.View.Browse;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import se.chalmers.group22.gymcompanion.Model.Observer;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.ViewModel.BrowseViewModel;

public class BrowseAddExerciseFragment extends Fragment implements Observer {

    private BrowseViewModel viewModel;
    public static BrowseAddExerciseFragment getInstance() { return new BrowseAddExerciseFragment(); }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_browse_add_exercise, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        viewModel = ((BrowseActivity) getActivity()).getViewModel();

        viewModel.addObserver(this);

        //************************************LISTVIEW
        BrowseAddExerciseListAdapter adapter;
        ListView listView = getView().findViewById(R.id.listViewBrowseAddExercise);
        adapter = new BrowseAddExerciseListAdapter(getActivity(),
                viewModel.getUserRoutineNames(),
                viewModel.getUserRoutineDifficulties(),
                viewModel.getUserRoutineAmountExercises());
        listView.setAdapter(adapter);
    }

    @Override
    public void onPause() {
        super.onPause();
        viewModel.removeObserver(this);
    }

    @Override
    public void update() {
        //************************************LISTVIEW
        BrowseAddExerciseListAdapter adapter;
        ListView listView = getView().findViewById(R.id.listViewBrowseAddExercise);
        adapter = new BrowseAddExerciseListAdapter(getActivity(),
                viewModel.getUserRoutineNames(),
                viewModel.getUserRoutineDifficulties(),
                viewModel.getUserRoutineAmountExercises());
        listView.setAdapter(adapter);
    }
}
