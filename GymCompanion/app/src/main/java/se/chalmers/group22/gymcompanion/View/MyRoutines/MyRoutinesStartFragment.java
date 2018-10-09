package se.chalmers.group22.gymcompanion.View.MyRoutines;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import se.chalmers.group22.gymcompanion.Model.Routine;
import se.chalmers.group22.gymcompanion.R;

public class MyRoutinesStartFragment extends Fragment {

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
        return inflater.inflate(R.layout.fragment_my_routines_start, container, false);
    }

    public void onStart(){
        super.onStart();
        Routine[] routines = {new Routine("Simodla",5),new Routine("August",10), new Routine("Daniel",100)};
        ArrayAdapter adapter = new RoutineListAdapter(getActivity(),routines);
        ListView listView = (ListView) getActivity().findViewById(R.id.routineList);
        listView.setAdapter(adapter);
    }
}
