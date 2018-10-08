package se.chalmers.group22.gymcompanion.View.Statistics;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.HistoryListAdapter;
import se.chalmers.group22.gymcompanion.View.MainActivity;

public class StatisticsHistoryFragment extends Fragment {
    /** TEMPORARY DATA */
    private String[] routineNames = {"Chest demolisher", "Leg killer", "Back attack"};
    private String[] dates = {"Monday w.42", "Tuesday w.42", "Thursday w.42"};

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

        ArrayAdapter adapter = new HistoryListAdapter(getActivity(), routineNames, dates);
        ListView listView = getActivity().findViewById(R.id.listviewHistory);
        listView.setAdapter(adapter);
    }
}
