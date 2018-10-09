package se.chalmers.group22.gymcompanion.View.MyRoutines;

import android.app.Activity;
import android.widget.ArrayAdapter;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.R;

public class ExerciseListAdapter extends ArrayAdapter {

    //to reference the activity
    private Activity context;

    //to store exercises
    private Exercise[] exercises;

    public ExerciseListAdapter(Activity context, Exercise[] exercises){
        super(context, R.layout.listitem_my_routines_exercise,exercises);
        this.context = context;
        this.exercises = exercises;
    }
}
