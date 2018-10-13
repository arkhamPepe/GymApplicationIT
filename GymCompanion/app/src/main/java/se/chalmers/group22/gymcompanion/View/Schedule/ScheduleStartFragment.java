package se.chalmers.group22.gymcompanion.View.Schedule;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;
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

        CalendarView calendarView = getActivity().findViewById(R.id.calendarSchedule);
        TextView txtBookedRoutineName = getActivity().findViewById(R.id.txtScheduleBookedRoutine);

        txtBookedRoutineName.setText(viewModel.getToday());

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = viewModel.getDateString(year, month, dayOfMonth);
                txtBookedRoutineName.setText(date);
            }
        });
    }
}
