package se.chalmers.group22.gymcompanion.View.Browse;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.ViewModel.BrowseViewModel;

public class BrowseStartFragment extends Fragment {

    private BrowseViewModel viewModel;

    public static BrowseStartFragment getInstance() {
        return new BrowseStartFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_browse_start, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        SearchView searchView = getView().findViewById(R.id.searchBar);

        viewModel = ((BrowseActivity) getActivity()).getViewModel();

        //Sets the ActionBar title for this particular fragment
        ((BrowseActivity) getActivity()).getSupportActionBar().setTitle("Search and Browse");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(getActivity(),viewModel.search(query),Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        ((BrowseActivity) getActivity()).getSupportActionBar().setTitle("Search and Browse");

    }
}
