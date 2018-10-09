package se.chalmers.group22.gymcompanion.View.MyRoutines;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.StrengthExercise;
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

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listitem_my_routines_exercise, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView exerciseName = (TextView) rowView.findViewById(R.id.exerciseNameList);
        TextView amountOfSets = (TextView) rowView.findViewById(R.id.amountOfSetsList);

        //this code sets the values of the objects to values from the arrays
        exerciseName.setText(exercises[position].getName());
        return rowView;

    }
}
