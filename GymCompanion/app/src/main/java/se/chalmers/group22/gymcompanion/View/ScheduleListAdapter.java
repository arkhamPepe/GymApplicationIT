package se.chalmers.group22.gymcompanion.View;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.R;

import java.util.List;

public class ScheduleListAdapter extends ArrayAdapter {
    //to reference the Activity
    private final Activity context;

    //to store the list of routine names
    private final List<String> routineList;

    private final String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

    public ScheduleListAdapter(Activity context, List<String> routineArrayParam){
        super(context, R.layout.listitem_history , routineArrayParam);

        this.context = context;
        this.routineList = routineArrayParam;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listitem_schedule, null,true);

        //this code gets references to objects in the listview_row.xml file


        //this code sets the values of the objects to values from the arrays


        return rowView;

    };
}
