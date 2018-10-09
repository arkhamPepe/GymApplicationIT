package se.chalmers.group22.gymcompanion.View.MyRoutines;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.R;

public class MyRoutinesRoutineInfoFragment extends Fragment {

    //variables for fragment_routine_routine_info.xml
    private TextView textViewRoutineName;
    private TextView textViewAmountOfExercises;
    private ListView exerciseList;
    private Button addExercise;

    public static MyRoutinesRoutineInfoFragment newInstance() {
        MyRoutinesRoutineInfoFragment fragment = new MyRoutinesRoutineInfoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_routine_routine_info, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        textViewRoutineName = getView().findViewById(R.id.routineName);
        textViewAmountOfExercises = getView().findViewById(R.id.textViewAmountOfExercises);
        exerciseList = getView().findViewById(R.id.listViewExercise);
        addExercise = getView().findViewById(R.id.addExercise);

    }

}