package se.chalmers.group22.gymcompanion.View.Progress;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ListView;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.Progress.ProgressExpandList.ProgressExpandListAdapter;
import se.chalmers.group22.gymcompanion.View.Progress.ProgressExpandList.ProgressExpandListChild;
import se.chalmers.group22.gymcompanion.View.Progress.ProgressExpandList.ProgressExpandListGroup;
import se.chalmers.group22.gymcompanion.ViewModel.ProgressViewModel;

import java.util.ArrayList;

public class ProgressStartFragment extends Fragment {

    private ProgressViewModel viewModel;

    private ProgressExpandListAdapter progAdapter;
    private ArrayList<ProgressExpandListGroup> listItems;
    private ExpandableListView exListView;

    public static ProgressStartFragment newInstance() {
        ProgressStartFragment fragment = new ProgressStartFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_progress_start, container, false);
    }

    public void onStart(){
        super.onStart();

        viewModel = ((ProgressActivity)getActivity()).getViewModel();

        exListView = getView().findViewById(R.id.ProgressExpList);
        listItems = SetStandardGroups();
        progAdapter = new ProgressExpandListAdapter(getActivity(), listItems);
        exListView.setAdapter(progAdapter);
    }

    //TODO Optimize this method (The names of the method calls are too long, find a solution)
    public ArrayList<ProgressExpandListGroup> SetStandardGroups() {
        ArrayList<ProgressExpandListGroup> exercises = new ArrayList<>();
        ArrayList<ProgressExpandListChild> sets = new ArrayList<>();

        for (int i = 0; i< viewModel.getAmountOfExercisesInAR();i++) {

            viewModel.setActiveExercise(i);

            ProgressExpandListGroup exercise = new ProgressExpandListGroup();
            exercise.setExerciseName(viewModel.getAEName());

            if(viewModel.isExerciseInARStrengthExercise()) {

                exercise.setExtraInfo("Sets: " + viewModel.getAmountOfSetsInAE());

                for (int j = 0; j < viewModel.getAmountOfSetsInAE(); j++) {
                    ProgressExpandListChild set = new ProgressExpandListChild();
                    set.setReps(viewModel.getAmountOfRepsFromARExerciseSetWithIndex(j));
                    set.setWeight(viewModel.getAmountWeightFromARExerciseSetWithIndex(j));
                    sets.add(set);
                }
            }
            else{
                exercise.setExtraInfo("Time: " + viewModel.getTimeInAE());
            }

            exercises.add(exercise);
            sets.clear();
        }

        return exercises;
    }

}
