package se.chalmers.group22.gymcompanion.View.Schedule;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.ScheduleListAdapter;
import se.chalmers.group22.gymcompanion.ViewModel.ScheduleViewModel;

import java.util.ArrayList;
import java.util.List;

public class ScheduleStartFragment extends Fragment {

    private ScheduleViewModel viewModel;

    public static ScheduleStartFragment getInstance() {
        return new ScheduleStartFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_schedule_start, container, false);
    }

    public void onStart(){
        super.onStart();

        viewModel = ((ScheduleActivity)getActivity()).getViewModel();

        /** TEMPORARY LOCAL LIST OF ROUTINE NAMES */
        List<String> routineNames = new ArrayList<>();
        routineNames.add("Chest");
        routineNames.add("Legs");
        routineNames.add("Back");
        routineNames.add("Arms");
        routineNames.add("Cardio");
        routineNames.add("Chest");
        routineNames.add("Legs");

        // Create and show the list in GUI
        updateList(routineNames);

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                ((ScheduleActivity)getActivity()).goToPickRoutine(view);
            }
        });
    }

    private void updateList(List<String> data){
        // Create and show the list in GUI
        ScheduleListAdapter adapter = new ScheduleListAdapter(getActivity(), data);
        ListView listView = getListView();
        listView.setAdapter(adapter);
    }

    public ListView getListView(){
        return getActivity().findViewById(R.id.listviewSchedule);
    }
}
