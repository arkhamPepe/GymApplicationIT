package se.chalmers.group22.gymcompanion.View.Browse;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.BrowseResultListAdapter;
import se.chalmers.group22.gymcompanion.ViewModel.BrowseViewModel;

public class BrowseResultFragment extends Fragment {

    private BrowseViewModel viewModel;
    private TextView currentMuscleGroup;
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

        CheckBox cbxRoutines = (CheckBox)getView().findViewById(R.id.cbxRoutines);
        CheckBox cbxExercises = (CheckBox)getView().findViewById(R.id.cbxExercises);

        cbxRoutines.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                   //viewModel.filterRoutines();
                   Toast.makeText(getActivity(),"Routines",Toast.LENGTH_SHORT).show();
               }
           }
        );
        cbxExercises.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                   //viewModel.filterExercises();
                   Toast.makeText(getActivity(),"Exercises",Toast.LENGTH_SHORT).show();
               }
           }
        );
    }

    @Override
    public void onResume(){
        super.onResume();
        ((BrowseActivity) getActivity()).getSupportActionBar().setTitle("Browse Results");

        this.currentMuscleGroup = getView().findViewById(R.id.currentMuscleGroup);
        String t = "Browsing: " + viewModel.getCurrentPage();

        this.currentMuscleGroup.setText(t);


        //ListView
        BrowseResultListAdapter adapter;
        ListView listView = getView().findViewById(R.id.listViewBrowseResult);
        adapter = new BrowseResultListAdapter(getActivity(),
                viewModel.getRoutineAndExerciseNames(),
                viewModel.getRoutineAndExerciseDifficulties(),
                viewModel.getType());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                //((BrowseActivity)getActivity()).scheduleRoutine();
            }
        });
    }
}
