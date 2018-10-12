package se.chalmers.group22.gymcompanion.View.Home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.R;

public class HomeStartFragment extends Fragment {
    public static HomeStartFragment newInstance() {
        HomeStartFragment fragment = new HomeStartFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_start, container, false);
    }

    public void onStart(){
        super.onStart();

        TextView routineOfToday = getView().findViewById(R.id.textViewRoutineOfToday);
        routineOfToday.setText(((HomeActivity)getActivity()).getScheduledRoutineName());
    }
}
