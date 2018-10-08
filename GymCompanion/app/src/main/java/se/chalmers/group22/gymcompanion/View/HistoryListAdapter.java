package se.chalmers.group22.gymcompanion.View;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.R;

public class HistoryListAdapter extends ArrayAdapter {

    public HistoryListAdapter(Activity context, String[] routineArrayParam, String[] dateArrayParam){

        super(context, R.layout.listitem_history , routineArrayParam);

        this.context = context;
        this.routineArray = routineArrayParam;
        this.dateArray = dateArrayParam;

    }

    //to reference the Activity
    private final Activity context;

    //to store the list of routine names
    private final String[] routineArray;

    //to store the list of dates
    private final String[] dateArray;

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listitem_history, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView routineNameTextField = (TextView) rowView.findViewById(R.id.txtHistoryRoutineName);
        TextView dateTextField = (TextView) rowView.findViewById(R.id.txtHistoryDate);

        //this code sets the values of the objects to values from the arrays
        routineNameTextField.setText(routineArray[position]);
        dateTextField.setText(dateArray[position]);

        return rowView;

    };
}
