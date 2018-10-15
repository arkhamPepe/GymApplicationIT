package se.chalmers.group22.gymcompanion.View.Browse;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.ViewModel.BrowseViewModel;

public class BrowseResultFragment extends Fragment {

    private BrowseViewModel viewModel;
    private TextView dummy;
    public static BrowseSelectionFragment getInstance() {
        return new BrowseSelectionFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_browse_results, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        viewModel = ((BrowseActivity) getActivity()).getViewModel();

        ((BrowseActivity) getActivity()).getSupportActionBar().setTitle("Browse Results");

        this.dummy = getView().findViewById(R.id.dummy);

        this.dummy.setText("Hejsan");
        /*ScheduleListAdapter adapter = new ScheduleListAdapter(getActivity(),
                viewModel.getRoutineNames(),
                viewModel.getRoutineDifficulties(),
                viewModel.getRoutineExercisesAmounts());
        ListView listView = getView().findViewById(R.id.listviewSchedulePick);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                //((BrowseActivity)getActivity()).scheduleRoutine();
            }
        });*/
    }
}
