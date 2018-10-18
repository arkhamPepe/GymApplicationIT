package se.chalmers.group22.gymcompanion.View.Browse;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.ViewModel.BrowseViewModel;

public class BrowseSelectionFragment extends Fragment /*implements View.OnClickListener*/ {

    private BrowseViewModel viewModel;
    private TextView currentIndex;
    public static BrowseSelectionFragment getInstance() {
        return new BrowseSelectionFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_browse_selection, container, false);
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        viewModel = ((BrowseActivity) getActivity()).getViewModel();
    }

    @Override
    public void onResume() {
        super.onResume();
        this.currentIndex = getView().findViewById(R.id.currentIndex);

        String current = "Category: " + viewModel.getCurrentPage();
        this.currentIndex.setText(current);

        ((BrowseActivity) getActivity()).getSupportActionBar().setTitle("Search and Browse");
    }
}
