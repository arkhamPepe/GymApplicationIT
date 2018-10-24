package se.chalmers.group22.gymcompanion.View.MyRoutines;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.Model.Workout.Routine;
import se.chalmers.group22.gymcompanion.R;

import java.util.ArrayList;
import java.util.List;

public class MyRoutinesUserRoutinesListAdapter extends ArrayAdapter {

    //to reference the Activity
    private Activity context;

    //to store routines
    private List<String> routineNames;
    private List<Integer> exerciseCount;

    public MyRoutinesUserRoutinesListAdapter(Activity context, List<String> routineNames, List<Integer> exerciseCount){
        super(context, R.layout.listitem_my_routines,routineNames);
        this.context = context;
        this.routineNames = routineNames;
        this.exerciseCount = exerciseCount;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listitem_my_routines, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView routineName = rowView.findViewById(R.id.routineName);
        TextView routineExerciseAmount = rowView.findViewById(R.id.listItemAmountOfExercises);

        //this code sets the values of the objects to values from the arrays
        routineName.setText(routineNames.get(position));
        routineExerciseAmount.setText(String.valueOf(exerciseCount.get(position)));

        ImageButton btnremoveRoutine = rowView.findViewById(R.id.btnRemoveRoutine);
        btnremoveRoutine.setTag(position);

        return rowView;

    }

}
