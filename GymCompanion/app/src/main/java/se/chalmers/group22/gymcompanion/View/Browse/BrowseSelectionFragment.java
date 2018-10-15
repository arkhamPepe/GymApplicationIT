package se.chalmers.group22.gymcompanion.View.Browse;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.ViewModel.BrowseViewModel;

public class BrowseSelectionFragment extends Fragment {

    private BrowseViewModel viewModel;
    private String type;
    private Button test;
    public static BrowseSelectionFragment getInstance() {
        return new BrowseSelectionFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_browse_selection, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        viewModel = ((BrowseActivity) getActivity()).getViewModel();

        this.test = getView().findViewById(R.id.test);

        test.setText(type);

        ((BrowseActivity) getActivity()).getSupportActionBar().setTitle("Browsing " + type);
    }
}
