package se.chalmers.group22.gymcompanion.View.Statistics;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.HistoryListAdapter;
import se.chalmers.group22.gymcompanion.ViewModel.StatisticsViewModel;

import java.util.Calendar;
import java.util.List;
/***
 * Title: StatisticsHistoryFragment
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 5, 2018
 *
 * Purpose: Fragment connected to a xml displaying the Statistics History Page in the app
 * Uses: StatisticsViewModel.java, HistoryListAdapter.java, fragment_statistics_history.xml
 * Used by: FragmentFactory.java
 */
public class StatisticsHistoryFragment extends Fragment {

    private StatisticsViewModel viewModel;

    public static StatisticsHistoryFragment newInstance() {
        StatisticsHistoryFragment fragment = new StatisticsHistoryFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_statistics_history, container, false);
    }

    public void onStart(){
        super.onStart();
        viewModel = ((StatisticsActivity)getActivity()).getViewModel();

        HistoryListAdapter adapter = new HistoryListAdapter(getActivity(), viewModel.getRoutineNames(), viewModel.getRoutineDatesFormatted());
        ListView listView = getListView();
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                ((StatisticsActivity)getActivity()).onRoutineClick(viewModel.getRoutineDates().get(position));
            }
        });


    }

    public ListView getListView(){
        return getActivity().findViewById(R.id.listviewHistory);
    }
}
