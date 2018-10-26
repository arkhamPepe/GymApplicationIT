package se.chalmers.group22.gymcompanion.View.Statistics;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.Model.Observer;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.ViewModel.StatisticsViewModel;

import java.util.List;
/***
 * Title: StatisticsHistoryDetailsFragment
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 5, 2018
 *
 * Purpose: Fragment connected to a xml displaying the History Details Page in the app
 */
public class StatisticsHistoryDetailsFragment extends Fragment implements Observer {

    private StatisticsViewModel viewModel;

    public static StatisticsHistoryDetailsFragment newInstance() {
        StatisticsHistoryDetailsFragment fragment = new StatisticsHistoryDetailsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_statistics_history_details, container, false);
    }

    public void onStart(){
        super.onStart();
        viewModel = ((StatisticsActivity)getActivity()).getViewModel();
        viewModel.addObserver(this);

        update();
    }

    @Override
    public void onPause(){
        super.onPause();
        viewModel.removeObserver(this);
    }

    public void update(){
        List<String> names = viewModel.getHistoryExerciseNames();
        List<Boolean> performances = viewModel.getHistoryExercisePerformedValues();

        TextView routineName = getActivity().findViewById(R.id.txtHistoryDetailsTitle);

        StatisticsHistoryInfoListAdapter adapter = new StatisticsHistoryInfoListAdapter(getActivity(), names, performances);
        ListView exerciseList = getActivity().findViewById(R.id.listviewHistoryDetails);
        exerciseList.setAdapter(adapter);

        /*exerciseList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                //((StatisticsActivity)getActivity()).goToHistoryDetails();
            }
        });*/
    }
}
