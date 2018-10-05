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
import se.chalmers.group22.gymcompanion.View.MainActivity;

public class StatisticsLifetimeFragment extends Fragment {
    public static StatisticsLifetimeFragment newInstance() {
        StatisticsLifetimeFragment fragment = new StatisticsLifetimeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_statistics_lifetime, container, false);
    }
}
