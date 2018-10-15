package se.chalmers.group22.gymcompanion.View.MyRoutines;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import se.chalmers.group22.gymcompanion.Model.Exercises.CardioExercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.StrengthExercise;
import se.chalmers.group22.gymcompanion.Model.Routine;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.Schedule.ScheduleActivity;
import se.chalmers.group22.gymcompanion.ViewModel.MyRoutinesViewModel;

import java.util.ArrayList;
import java.util.List;

public class MyRoutinesStartFragment extends Fragment {
    //Variables for fragment_my_routines_start.xml
    private ListView routineList;

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
        viewModel = ((MyRoutinesActivity)getActivity()).getViewModel(); // Get the ViewModel

        /*routineList = getView().findViewById(R.id.listViewMyRoutines);
        Routine r1 = new Routine("August",10);
        Routine r2 = new Routine("Daniel",100);
        Routine r3 = new Routine("Simodla",5);
        r1.addExercise(new StrengthExercise("Simola Lifter", 9001));
        r2.addExercise(new StrengthExercise("Bock Lifter", 9000.5));
        r3.addExercise(new StrengthExercise("Zorank Destroyer", 1337));
        List<Routine> routines = new ArrayList<>();
        routines.add(r1);
        routines.add(r2);
        routines.add(r3);
        ArrayAdapter adapter = new RoutineListAdapter(getActivity(),routines);
        ListView listView = getView().findViewById(R.id.listViewMyRoutines);
        listView.setAdapter(adapter);*/
    }
}
