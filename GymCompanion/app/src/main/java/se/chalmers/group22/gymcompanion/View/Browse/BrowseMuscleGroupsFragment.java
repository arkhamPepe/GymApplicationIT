package se.chalmers.group22.gymcompanion.View.Browse;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.ViewModel.BrowseViewModel;
/***
 * Title: BrowseMuscleGroupsFragment
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 18, 2018
 *
 * Purpose: Fragment connected to a xml displaying the Muscle Groups fragment in the app
 */
public class BrowseMuscleGroupsFragment extends Fragment {

    private BrowseViewModel viewModel;
    public static BrowseMuscleGroupsFragment getInstance() {
        return new BrowseMuscleGroupsFragment();
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

        //ListView
        ListView listView = getView().findViewById(R.id.listViewBrowseMuscleGroups);

        BrowseMuscleGroupsListAdapter adapter = new BrowseMuscleGroupsListAdapter(getActivity(),
                viewModel.getMuscleGroups());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                String s = listView.getAdapter().getItem(position).toString();
                ((BrowseActivity)getActivity()).goToResult(s);
            }
        });
    }
}
