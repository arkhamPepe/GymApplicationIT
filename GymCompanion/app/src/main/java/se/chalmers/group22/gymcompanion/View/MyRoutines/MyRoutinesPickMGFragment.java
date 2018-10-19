package se.chalmers.group22.gymcompanion.View.MyRoutines;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.ViewModel.MyRoutinesViewModel;

public class MyRoutinesPickMGFragment extends Fragment {
    private MyRoutinesViewModel viewModel;

    public static MyRoutinesPickMGFragment newInstance() {
        MyRoutinesPickMGFragment fragment = new MyRoutinesPickMGFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_routines_pick_musclegroup, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        viewModel = ((MyRoutinesActivity)getActivity()).getViewModel(); //get the viewmodel

        ListView listView = getView().findViewById(R.id.listviewMyRoutinesMG);

        MyRoutinesMGAdapter adapter = new MyRoutinesMGAdapter(getActivity(),
                viewModel.getMuscleGroups());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                viewModel.setSelectedMGIndex(position);
                ((MyRoutinesActivity)getActivity()).onClickPickMG(view);
            }
        });

    }
}
