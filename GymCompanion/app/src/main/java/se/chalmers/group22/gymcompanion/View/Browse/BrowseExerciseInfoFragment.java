package se.chalmers.group22.gymcompanion.View.Browse;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.ViewModel.BrowseViewModel;

public class BrowseExerciseInfoFragment extends Fragment {

    private BrowseViewModel viewModel;
    public static BrowseExerciseInfoFragment getInstance() { return new BrowseExerciseInfoFragment(); }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_browse_exercise_info, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        viewModel = ((BrowseActivity) getActivity()).getViewModel();
    }
}
