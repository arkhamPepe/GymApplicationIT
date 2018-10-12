package se.chalmers.group22.gymcompanion.View.Schedule;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import se.chalmers.group22.gymcompanion.R;

public class SchedulePickRoutineFragment extends Fragment {

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

}
