package se.chalmers.group22.gymcompanion.View.Browse;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.R;

import java.util.List;

public class BrowseAddExerciseListAdapter extends ArrayAdapter {

    //to reference the Activity
    private final Activity context;

    //to store the list of routine names
    private final List<String> names;
    private final List<Double> difficulties;
    private final List<Integer> amount;

    public BrowseAddExerciseListAdapter(Activity context, List<String> nameArrayParam, List<Double> difficultyArrayParam,
                                        List<Integer> amountArrayParam){

        super(context, R.layout.listitem_browse_add_exercise , nameArrayParam);

        this.context = context;
        this.names = nameArrayParam;
        this.difficulties = difficultyArrayParam;
        this.amount = amountArrayParam;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listitem_browse_add_exercise, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView browseName = (TextView) rowView.findViewById(R.id.txtName);
        TextView browsePickAmountPrefix = (TextView) rowView.findViewById(R.id.txtBrowsePickAmountPrefix);
        TextView browseDifficulty = (TextView) rowView.findViewById(R.id.txtBrowseDifficulty);
        TextView browseType = (TextView) rowView.findViewById(R.id.txtType);
        ImageButton browseAdd = (ImageButton) rowView.findViewById(R.id.btnAddExercise);

        //this code sets the values of the objects to values from the arrays
        browseName.setText(names.get(position));

        browsePickAmountPrefix.setText(" , Exercises: " + amount.get(position).toString());
        browseType.setText("Routine");
        browseDifficulty.setText("Difficulty: " + difficulties.get(position).toString());
        //browseAdd.setTag(names.get(position));
        browseAdd.setTag(position);

        return rowView;

    }
}
