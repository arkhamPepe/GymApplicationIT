package se.chalmers.group22.gymcompanion.View.Browse;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.BrowseResultListAdapter;
import se.chalmers.group22.gymcompanion.ViewModel.BrowseViewModel;
import se.chalmers.group22.gymcompanion.ViewModel.MyRoutinesViewModel;

public class BrowseExerciseInfoFragment extends Fragment {

    private BrowseViewModel browseViewModel;
    public static BrowseExerciseInfoFragment getInstance() { return new BrowseExerciseInfoFragment(); }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_browse_exercise_info, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        browseViewModel = ((BrowseActivity) getActivity()).getBrowseViewModel();
    }

    @Override
    public void onResume() {
        super.onResume();
        //************************************LISTVIEW
        BrowseResultListAdapter adapter;
        ListView listView = getView().findViewById(R.id.listViewExerciseInfo);
        adapter = new BrowseResultListAdapter(getActivity(),
                browseViewModel.getUserRoutineNames(),
                browseViewModel.getUserRoutineDifficulties(),
                browseViewModel.getUserRoutineAmountExercises());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                //((BrowseActivity)getActivity()).scheduleRoutine();
                //Toast.makeText(getActivity(), "ListItem pressed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
