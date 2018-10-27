package se.chalmers.group22.gymcompanion.View;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.R;

import java.util.List;

/***
 * Title: HistoryListAdapter
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 8, 2018
 *
 * Purpose: Adds the list elements to the Statistics History List GUI
 *
 * Used by: StatisticsHistoryFragment.java
 *
 * Uses: N/A
 *
 */

public class HistoryListAdapter extends ArrayAdapter {
    private final Activity context; //to reference the Activity
    private List<String> routineNames;
    private List<String> routineDates;

    public HistoryListAdapter(Activity context, List<String> routineNames, List<String> routineDates){
        super(context, R.layout.listitem_history , routineNames);

        this.context = context;
        this.routineNames = routineNames;
        this.routineDates = routineDates;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listitem_history, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView routineNameTextField = rowView.findViewById(R.id.txtHistoryRoutineName);
        TextView dateTextField = rowView.findViewById(R.id.txtHistoryDate);

        //this code sets the values of the objects to values from the arrays
        routineNameTextField.setText(routineNames.get(position));
        dateTextField.setText(routineDates.get(position));

        return rowView;

    };
}
