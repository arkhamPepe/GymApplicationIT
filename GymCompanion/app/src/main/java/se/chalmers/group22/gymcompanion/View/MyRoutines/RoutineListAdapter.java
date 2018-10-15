package se.chalmers.group22.gymcompanion.View.MyRoutines;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.Model.Routine;
import se.chalmers.group22.gymcompanion.R;

import java.util.ArrayList;
import java.util.List;

public class RoutineListAdapter extends ArrayAdapter {

    //to reference the Activity
    private Activity context;

    //to store routines
    private List<String> routineNames;
    private List<Integer> exerciseNumber;

    public RoutineListAdapter(Activity context, List<Routine> routines){
        super(context, R.layout.listitem_my_routines,routines);
        routineNames = new ArrayList<>();
        this.context = context;
        for (Routine routine: routines){
            routineNames.add(routine.getName());
        }
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listitem_my_routines, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView routineName = (TextView) rowView.findViewById(R.id.routineName);
        TextView amountOfExercises = (TextView) rowView.findViewById(R.id.textViewAmountOfExercises);

        //this code sets the values of the objects to values from the arrays
        routineName.setText(routineNames.get(position));
        //amountOfExercises.setText(String.valueOf(exerciseNumber.get(position)));

        return rowView;

    }
}
