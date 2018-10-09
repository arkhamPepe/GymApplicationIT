package se.chalmers.group22.gymcompanion.View.MyRoutines;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import se.chalmers.group22.gymcompanion.R;

public class MyRoutinesStrengthExerciseFragment extends Fragment {

    public static MyRoutinesStrengthExerciseFragment newInstance() {
        MyRoutinesStrengthExerciseFragment fragment = new MyRoutinesStrengthExerciseFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_routine_setstrengthexercise, container, false);
    }
}