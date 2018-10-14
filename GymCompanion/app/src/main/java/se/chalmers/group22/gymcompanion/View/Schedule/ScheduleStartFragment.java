package se.chalmers.group22.gymcompanion.View.Schedule;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.ViewModel.ScheduleViewModel;

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
        TextView txtDate = getActivity().findViewById(R.id.txtScheduleDate);
        TextView txtRoutineName = getActivity().findViewById(R.id.txtScheduleRoutineName);
        Button btnBook = getActivity().findViewById(R.id.btnScheduleBook);

        // set initial texts
        txtDate.setText(viewModel.getToday());
        btnBook.setText(viewModel.getBookingButtonText());
        txtRoutineName.setText(viewModel.getSelectedDateRoutineName());

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                viewModel.setDate(year, month + 1, dayOfMonth); // month +1 since month is between 0 and 11
                String date = viewModel.getSelectedDate();
                String routineName = viewModel.getSelectedDateRoutineName();

                viewModel.setSelectedDateRoutine(routineName);
                txtDate.setText(date);
                txtRoutineName.setText(routineName);
                btnBook.setText(viewModel.getBookingButtonText());
            }
        });
    }
}
