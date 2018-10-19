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
 * Title: BrowseResultListAdapter
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 18, 2018
 *
 * Purpose: Adds the list elements to the Browse Result List GUI
 */

public class BrowseResultListAdapter extends ArrayAdapter {

    //to reference the Activity
    private final Activity context;

    //to store the list of routine names
    private final List<String> names;
    private final List<Double> difficulties;
    private final List<Integer> amount;

    public BrowseResultListAdapter(Activity context, List<String> nameArrayParam, List<Double> difficultyArrayParam,
                                   List<Integer> amountArrayParam){

        super(context, R.layout.listitem_browse , nameArrayParam);

        this.context = context;
        this.names = nameArrayParam;
        this.difficulties = difficultyArrayParam;
        this.amount = amountArrayParam;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listitem_browse, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView browseName = (TextView) rowView.findViewById(R.id.txtName);
        TextView browseAmountExercises = (TextView) rowView.findViewById(R.id.txtBrowsePickAmountNumber);
        TextView browsePickAmountPrefix = (TextView) rowView.findViewById(R.id.txtBrowsePickAmountPrefix);
        TextView browseDifficulty = (TextView) rowView.findViewById(R.id.txtBrowseDifficulty);
        TextView browseType = (TextView) rowView.findViewById(R.id.txtType);

        //this code sets the values of the objects to values from the arrays
        browseName.setText(names.get(position));
        if(amount.get(position) != 0) {
            browsePickAmountPrefix.setText("Exercises: " + amount.get(position).toString());
            browseType.setText("Routine");
        } else {
            browseType.setText("Exercise");
        }
        browseDifficulty.setText(difficulties.get(position).toString());
        return rowView;

    }
}
