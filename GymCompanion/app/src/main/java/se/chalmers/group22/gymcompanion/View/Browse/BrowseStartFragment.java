package se.chalmers.group22.gymcompanion.View.Browse;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.ViewModel.BrowseViewModel;
/***
 * Title: BrowseResultFragment
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 18, 2018
 *
 * Purpose: Fragment connected to a xml displaying the Start page in the application
 */
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
        SearchViewBrowse searchView = getView().findViewById(R.id.searchBar);
        viewModel = ((BrowseActivity) getActivity()).getViewModel();

        //Sets the ActionBar title for this particular fragment
        ((BrowseActivity) getActivity()).getSupportActionBar().setTitle("Search and Browse");

        searchView.setOnQueryTextListener(new SearchViewBrowse.OnQueryTextListener() {
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
            @Override
            public boolean onQueryTextSubmit(String query) {
                ((BrowseActivity)getActivity()).goToResultFromSearch(query);
                return true;
            }
        });
    }
}
