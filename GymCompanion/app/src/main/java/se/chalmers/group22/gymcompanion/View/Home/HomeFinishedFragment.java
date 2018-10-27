package se.chalmers.group22.gymcompanion.View.Home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.ViewModel.HomeViewModel;

import java.util.Map;

/***
 * Title: HomeFinishedFragment
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 2, 2018
 *
 * Purpose: Fragment connected to a xml displaying the Finished Page in the app
 *
 * Used by: HomeActivity.java, fragment_home_finished.xml
 *
 * Uses: HomeViewModel.java, fragment_home_finished.xml
 *
 */

public class HomeFinishedFragment extends Fragment {
    private TextView textViewRoutineName;
    private TextView textViewTotalExercises;
    private TextView textViewCompletedExercises;
    private Button btnGotoHome;

    private HomeViewModel viewModel;

    public static HomeFinishedFragment newInstance() {
        HomeFinishedFragment fragment = new HomeFinishedFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_finished, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        viewModel = ((HomeActivity)getActivity()).getViewModel();

        this.textViewRoutineName = getView().findViewById(R.id.textViewRoutineName);
        this.textViewCompletedExercises = getView().findViewById(R.id.textViewExercisesCompleted);
        this.textViewTotalExercises = getView().findViewById(R.id.textViewTotalExercises);
        this.btnGotoHome = getView().findViewById(R.id.btnGotoHome);

        Map<String, String> finishedRoutineStats = viewModel.getFinishedRoutineStats();

        textViewRoutineName.setText(finishedRoutineStats.get("exerciseName"));
        textViewTotalExercises.setText(finishedRoutineStats.get("totalExercises"));
        textViewCompletedExercises.setText(finishedRoutineStats.get("completedExercises"));
    }
}
