package se.chalmers.group22.gymcompanion.View.MyRoutines;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import se.chalmers.group22.gymcompanion.Model.ViewModelObserver;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.ViewModel.MyRoutinesViewModel;

/***
 * Title: MyRoutinesStartFragment
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 2, 2018
 *
 * Purpose: Fragment connected to a xml displaying the My Routines Start fragment in the app
 * Uses: MyRoutinesViewModel.java, fragment_routine_start.xml, MyRoutinesUserRoutinesListAdapter.java,
 *       MyRoutinesActivity.java
 * Used by: MyRoutinesActivity.java
 */
public class MyRoutinesStartFragment extends Fragment implements ViewModelObserver {

    private MyRoutinesViewModel viewModel;

    public static MyRoutinesStartFragment newInstance() {
        MyRoutinesStartFragment fragment = new MyRoutinesStartFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_routine_start, container, false);
    }

    public void onStart(){
        super.onStart();
        viewModel = ((MyRoutinesActivity)getActivity()).getBrowseViewModel(); // Get the ViewModel

        MyRoutinesUserRoutinesListAdapter adapter = new MyRoutinesUserRoutinesListAdapter
                (getActivity(),viewModel.getRoutineNames(),viewModel.getRoutinesExerciseCount());
        ListView listView = getView().findViewById(R.id.listviewMyRoutines);
        listView.setAdapter(adapter);

        viewModel.addObserver(this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                ((MyRoutinesActivity)getActivity()).onClickEnterRoutine(position);
            }
        });
    }

    @Override
    public void onPause(){
        super.onPause();

        viewModel.removeObserver(this);
    }


    public void update(){
        MyRoutinesUserRoutinesListAdapter adapter = new MyRoutinesUserRoutinesListAdapter
                (getActivity(), viewModel.getRoutineNames(),viewModel.getRoutinesExerciseCount());
        ListView listView = getView().findViewById(R.id.listviewMyRoutines);
        listView.setAdapter(adapter);
    }
}
