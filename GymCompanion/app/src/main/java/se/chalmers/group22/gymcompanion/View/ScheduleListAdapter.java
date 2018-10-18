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
    private final List<String> routineNames;
    private final List<Double> routineDifficulties;
    private final List<Integer> routineExercisesAmounts;

    public ScheduleListAdapter(Activity context, List<String> routineNames, List<Double> routineDifficulties, List<Integer> routineExercisesAmounts){
        super(context, R.layout.listitem_schedule , routineNames);

        this.context = context;
        this.routineNames = routineNames;
        this.routineDifficulties = routineDifficulties;
        this.routineExercisesAmounts = routineExercisesAmounts;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listitem_schedule, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView routineName = rowView.findViewById(R.id.txtSchedulePickRoutineName);
        TextView routineDifficulty = rowView.findViewById(R.id.txtSchedulePickDifficultyNumber);
        TextView routineExercisesAmount = rowView.findViewById(R.id.txtSchedulePickAmountNumber);

        //this code sets the values of the objects to values from the arrays
        routineName.setText(routineNames.get(position));
        routineDifficulty.setText(String.valueOf(routineDifficulties.get(position)));
        routineExercisesAmount.setText(String.valueOf(routineExercisesAmounts.get(position)));

        return rowView;

    };
}
