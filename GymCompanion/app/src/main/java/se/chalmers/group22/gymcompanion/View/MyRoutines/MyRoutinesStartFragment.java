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

public class MyRoutinesStartFragment extends Fragment {
    //Variables for fragment_my_routines_start.xml
    private ListView routineList;

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
        routineList = getView().findViewById(R.id.listViewMyRoutines);
        Routine r1 = new Routine("August",10);
        Routine r2 = new Routine("Daniel",100);
        Routine r3 = new Routine("Simodla",5);
        r1.addExercise(new StrengthExercise("Simola Lifter", 9001));
        r2.addExercise(new StrengthExercise("Bock Lifter", 9000.5));
        r3.addExercise(new StrengthExercise("Zorank Destroyer", 1337));
        Routine[] routines = {r1, r2, r3};
        ArrayAdapter adapter = new RoutineListAdapter(getActivity(),routines);
        /*ListView listView = getView().findViewById(R.id.listViewMyRoutines);
        listView.setAdapter(adapter);*/
    }
}
