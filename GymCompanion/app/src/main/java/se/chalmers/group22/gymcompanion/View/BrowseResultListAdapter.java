// Title    :  BrowseResultListAdapter
// Authors  :  Alexander Bergsten, Marcus Svensson, Erik Bock, Augustas Eidikis, Daniel Olsson
// Created  :  October 18, 2018
//
// Purpose  :  Adds the list elements to the Browse Result List GUI
//----------------------------------------------------------------------------------------------

package se.chalmers.group22.gymcompanion.View;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.R;

import java.util.List;

public class BrowseResultListAdapter extends ArrayAdapter {

    //to reference the Activity
    private final Activity context;

    //to store the list of routine names
    private final List<String> names;
    private final List<Double> difficulties;
    private final List<String> amount;
    private final List<String> type;

    public BrowseResultListAdapter(Activity context, List<String> nameArrayParam, List<Double> difficultyArrayParam,
                                   List<String> amountArrayParam, List<String> typeArrayParam){

        super(context, R.layout.listitem_browse , nameArrayParam);

        this.context = context;
        this.names = nameArrayParam;
        this.difficulties = difficultyArrayParam;
        this.type = typeArrayParam;
        this.amount = amountArrayParam;
    }

    public BrowseResultListAdapter(Activity context, List<String> nameArrayParam,
                                   List<Double> difficultyArrayParam, List<String> typeArrayParam){

        super(context, R.layout.listitem_browse , nameArrayParam);

        this.context = context;
        this.names = nameArrayParam;
        this.difficulties = difficultyArrayParam;
        this.type = typeArrayParam;
        this.amount = null;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listitem_browse, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView browseName = (TextView) rowView.findViewById(R.id.txtName);
        TextView browseAmountExercises = (TextView) rowView.findViewById(R.id.txtSchedulePickAmountNumber);
        TextView browsePickAmountPrefix = (TextView) rowView.findViewById(R.id.txtBrowsePickAmountPrefix);
        TextView browseDifficulty = (TextView) rowView.findViewById(R.id.txtBrowseDifficulty);
        TextView browseType = (TextView) rowView.findViewById(R.id.txtType);

        //this code sets the values of the objects to values from the arrays
        browseName.setText(names.get(position));
        if(amount != null) {
            browseAmountExercises.setText(amount.get(position));
            browsePickAmountPrefix.setText("Exercises:  ");
        }
        browseDifficulty.setText(difficulties.get(position).toString());
        browseType.setText(type.get(position));
        return rowView;

    }
}
