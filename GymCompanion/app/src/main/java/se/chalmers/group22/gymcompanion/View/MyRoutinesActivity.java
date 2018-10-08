package se.chalmers.group22.gymcompanion.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.Model.DataHandler;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.Main.MainActivity;
import se.chalmers.group22.gymcompanion.View.Browse.BrowseStartFragment;
import se.chalmers.group22.gymcompanion.View.MyRoutines.MyRoutinesExerciseInfoFragment;
import se.chalmers.group22.gymcompanion.View.MyRoutines.MyRoutinesRoutineInfoFragment;
import se.chalmers.group22.gymcompanion.View.MyRoutines.MyRoutinesStartFragment;
import se.chalmers.group22.gymcompanion.View.MyRoutines.MyRoutinesStrengthExerciseFragment;

public class MyRoutinesActivity extends AppCompatActivity {

    public static final int index = 3;

    final Fragment navigationFragment = new NavigationFragment();
    final FragmentManager fm = getSupportFragmentManager();

    private final Fragment fragmentStart = new MyRoutinesStartFragment();
    private final Fragment fragmentRoutineInfo = new MyRoutinesRoutineInfoFragment();
    private final Fragment fragmentExerciseInfo = new MyRoutinesExerciseInfoFragment();
    private final Fragment fragmentStrengthExercise = new MyRoutinesStrengthExerciseFragment();
    private Fragment active = fragmentStart;
    private DataHandler dataHandler = DataHandler.getInstance();

    //Variables for fragment_my_routines_start.xml
    private ListView routineList;

    //Variables for listitem_my_routines.xml
    private TextView routineName;
    private TextView amountOfExercises;

    //Variables for listitem_my_routines_sets.xml
    private TextView setNumber;
    private NumberPicker setReps;
    private NumberPicker setWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_routines);

        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.my_routines_container, fragmentExerciseInfo, "2").hide(fragmentExerciseInfo);
        transaction.add(R.id.my_routines_container, fragmentRoutineInfo, "2").hide(fragmentRoutineInfo);
        transaction.add(R.id.my_routines_container, fragmentStrengthExercise, "2").hide(fragmentStrengthExercise);
        transaction.add(R.id.my_routines_container, fragmentStart, "1");

        routineList = findViewById(R.id.routineList);

        routineName = findViewById(R.id.routineName);
        amountOfExercises = findViewById(R.id.amountOfExercises);

        setNumber = findViewById(R.id.setNumber);
        setReps = findViewById(R.id.setReps);
        setWeight = findViewById(R.id.setWeight);

        //Sends the activity index to NavigationFragment via Bundle
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        navigationFragment.setArguments(bundle);

        transaction.add(R.id.navigation,navigationFragment);

        transaction.commit();
    }
    public void createRoutine(View view){
        dataHandler.createRoutine();
    }

    public void addExercise(View view){

    }

    public void setRoutineName(){

    }
}
