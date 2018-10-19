package se.chalmers.group22.gymcompanion.View.Schedule;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.ScheduleListAdapter;
import se.chalmers.group22.gymcompanion.ViewModel.ScheduleViewModel;

import java.util.List;

public class SchedulePickRoutineFragment extends Fragment {

    private ScheduleViewModel viewModel;

    public static SchedulePickRoutineFragment getInstance() {
        return new SchedulePickRoutineFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_schedule_pick_routine, container, false);
    }

    public void onStart(){
        super.onStart();

        viewModel = ((ScheduleActivity)getActivity()).getBrowseViewModel();

        List<String> routineNames = viewModel.getRoutineNames();
        List<Double> routineDifficulties = viewModel.getRoutineDifficulties();
        List<Integer> routineExercisesAmounts = viewModel.getRoutineExercisesAmounts();

        ScheduleListAdapter adapter = new ScheduleListAdapter(getActivity(), routineNames, routineDifficulties, routineExercisesAmounts);
        ListView listView = getView().findViewById(R.id.listviewSchedulePick);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                ((ScheduleActivity)getActivity()).scheduleRoutine(routineNames.get(position));
                Toast.makeText(getActivity(), "Added!", Toast.LENGTH_SHORT).show();
                ((ScheduleActivity) getActivity()).goToStart(view);
            }
        });
    }

}
