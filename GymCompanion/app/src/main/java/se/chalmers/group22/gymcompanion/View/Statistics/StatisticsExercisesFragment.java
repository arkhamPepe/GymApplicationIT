package se.chalmers.group22.gymcompanion.View.Statistics;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import se.chalmers.group22.gymcompanion.R;
//import se.chalmers.group22.gymcompanion.View.MainActivity;

public class StatisticsExercisesFragment extends Fragment {
    public static StatisticsExercisesFragment newInstance() {
        StatisticsExercisesFragment fragment = new StatisticsExercisesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_statistics_exercises, container, false);
    }
}
