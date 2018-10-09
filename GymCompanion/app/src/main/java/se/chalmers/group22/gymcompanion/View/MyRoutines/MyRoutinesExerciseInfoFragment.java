package se.chalmers.group22.gymcompanion.View.MyRoutines;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.R;

public class MyRoutinesExerciseInfoFragment extends Fragment {

    //variables for fragment_routine_exercise_info.xml
    private TextView textViewExerciseDescription;
    private TextView textViewGuideDescription;
    private TextView textViewExerciseName;

    public static MyRoutinesExerciseInfoFragment newInstance() {
        MyRoutinesExerciseInfoFragment fragment = new MyRoutinesExerciseInfoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_routine_exercise_info, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        textViewExerciseDescription = getActivity().findViewById(R.id.exerciseDescription);
        textViewExerciseName = getActivity().findViewById(R.id.exerciseName);
        textViewGuideDescription = getActivity().findViewById(R.id.guideDescription);
    }
}
