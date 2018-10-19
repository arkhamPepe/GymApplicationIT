package se.chalmers.group22.gymcompanion.View;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.R;

import java.util.List;

/***
 * Title: BrowseMuscleGroupsListAdapter
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 18, 2018
 *
 * Purpose: Adds the list elements to the Browse Muscle Groups List GUI
 */

public class BrowseMuscleGroupsListAdapter extends ArrayAdapter {
    //to reference the Activity
    private final Activity context;

    //to store the list of routine names
    private final List<String> names;

    public BrowseMuscleGroupsListAdapter(Activity context, List<String> nameArrayParam){
        super(context, R.layout.listitem_musclegroup, nameArrayParam);

        this.context = context;
        this.names = nameArrayParam;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listitem_musclegroup, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView muscleGroupName = (TextView) rowView.findViewById(R.id.txtMuscleGroup);

        //this code sets the values of the objects to values from the arrays
        muscleGroupName.setText(names.get(position));

        return rowView;

    }
}
