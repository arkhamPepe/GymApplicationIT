package se.chalmers.group22.gymcompanion.View;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.Model.Routine;
import se.chalmers.group22.gymcompanion.R;

public class RoutineListAdapter extends ArrayAdapter {

    //to reference the Activity
    private Activity context;

    //to store routines
    private Routine[] routines;

    public RoutineListAdapter(Activity context, Routine[] routines){
        super(context, R.layout.listitem_my_routines,routines);
        this.context = context;
        this.routines = routines;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listitem_my_routines, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView routineName = (TextView) rowView.findViewById(R.id.routineName);
        TextView amountOfExercises = (TextView) rowView.findViewById(R.id.amountOfExercises);

        //this code sets the values of the objects to values from the arrays
        routineName.setText(routines[position].getName());
        amountOfExercises.setText(routines[position].getExercises().size());

        return rowView;

    }
}
