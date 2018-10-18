package se.chalmers.group22.gymcompanion.View.Statistics;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.ViewModel.StatisticsViewModel;

public class StatisticsLifetimeStatsFragment extends Fragment {

    TextView totalRoutinesCompleted;
    TextView totalExercisesCompleted;
    TextView favouriteExercise;
    TextView favouriteRoutine;
    TextView biggestRoutine;

    private StatisticsViewModel viewModel;

    public static StatisticsLifetimeStatsFragment newInstance() {
        StatisticsLifetimeStatsFragment fragment = new StatisticsLifetimeStatsFragment();
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

    @Override
    public void onStart(){
        super.onStart();

        viewModel = ((StatisticsActivity)getActivity()).getViewModel();

        totalRoutinesCompleted = getView().findViewById(R.id.totalRoutinesCompleted);
        totalExercisesCompleted = getView().findViewById(R.id.totalExercisesCompleted);
        favouriteRoutine = getView().findViewById(R.id.favouriteRoutine);
        favouriteExercise = getView().findViewById(R.id.favouriteExercise);
        biggestRoutine = getView().findViewById(R.id.biggestRoutine);

        totalRoutinesCompleted.setText("Total Routines Completed: " + viewModel.getTotalAmountOfCompletedRoutines());

    }
}
