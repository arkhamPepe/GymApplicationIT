package se.chalmers.group22.gymcompanion.View.MyRoutines;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.ViewModel.MyRoutinesViewModel;
/***
 * Title: MyRoutinesExerciseInfoFragment
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 2, 2018
 *
 * Purpose: Fragment connected to a xml displaying the Exercise Info fragment in the app
 */
public class MyRoutinesExerciseInfoFragment extends Fragment {

    //variables for fragment_routine_exercise_info.xml
    private TextView textViewExerciseDescription;
    private TextView textViewGuideDescription;
    private TextView textViewExerciseName;

    private MyRoutinesViewModel viewModel;

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
        viewModel = ((MyRoutinesActivity)getActivity()).getBrowseViewModel(); //get the viewmodel

    }

    public void update(){
        textViewExerciseDescription = getView().findViewById(R.id.textViewDescription);
        textViewExerciseName = getView().findViewById(R.id.txtEditMyRoutinesInfoRoutineName);
        textViewGuideDescription = getView().findViewById(R.id.textViewGuide);

        textViewExerciseName.setText(viewModel.getExerciseName());

    }
}
