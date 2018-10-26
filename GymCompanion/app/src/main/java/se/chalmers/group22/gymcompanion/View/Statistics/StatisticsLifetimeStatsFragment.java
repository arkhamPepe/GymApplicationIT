// Title    :  StatisticsLifetimeStatsFragment
// Authors  :  Alexander Bergsten, Marcus Svensson, Erik Bock, Augustas Eidikis, Daniel Olsson
// Created  :  October , 2018
//
// Purpose  :  Fragment connected to a xml displaying the Lifetime Stats Page in the app
//----------------------------------------------------------------------------------------------

package se.chalmers.group22.gymcompanion.View.Statistics;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.ViewModel.StatisticsViewModel;
/***
 * Title: StatisticsLifetimeStatsFragment
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 5, 2018
 *
 * Purpose: Fragment connected to a xml displaying the Statistics Lifetime Stats Page in the app
 */
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
        totalExercisesCompleted.setText("Total Exercises Completed: " + viewModel.getTotalAmountOfCompletedExercises());
        favouriteRoutine.setText("Favourite Routine: " + viewModel.getFavouriteRoutineName());
        favouriteExercise.setText("Favourite Exercise: " + viewModel.getFavouriteExerciseName());
        biggestRoutine.setText("Biggest Routine Completed: " + viewModel.getBiggestCompletedRoutineName());

    }
}
