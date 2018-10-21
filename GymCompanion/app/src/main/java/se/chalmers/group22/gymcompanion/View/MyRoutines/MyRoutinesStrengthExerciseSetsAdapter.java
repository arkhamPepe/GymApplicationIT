package se.chalmers.group22.gymcompanion.View.MyRoutines;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.Model.Observer;
import se.chalmers.group22.gymcompanion.R;

import java.util.List;

public class MyRoutinesStrengthExerciseSetsAdapter extends ArrayAdapter {
    private Activity context;

    private List<Double> kilograms;
    private List<Integer> reps;

    public MyRoutinesStrengthExerciseSetsAdapter(Activity context, List<Double> kilograms, List<Integer> reps){
        super(context, R.layout.listitem_my_routines_sets, kilograms);
        this.context = context;
        this.kilograms = kilograms;
        this.reps = reps;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listitem_my_routines_sets, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView setNumber = rowView.findViewById(R.id.textViewSetNumber);
        NumberPicker setWeight = (NumberPicker) rowView.findViewById(R.id.numberPickerSetWeight);
        NumberPicker setReps = (NumberPicker) rowView.findViewById(R.id.numberPickerSetReps);

        setWeight.setMinValue(1);
        setWeight.setMaxValue(200);
        setReps.setMinValue(1);
        setReps.setMaxValue(20);


        //this code sets the values of the objects to values from the arrays
        setNumber.setText(String.valueOf(position + 1));
        setWeight.setValue(kilograms.get(position).intValue());
        setReps.setValue(reps.get(position));

        setWeight.setTag(position);
        setReps.setTag(position);

        setWeight.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                ((MyRoutinesActivity) context).updateSelectedExerciseKilogramInSet(position, newVal);
            }
        });

        setReps.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                ((MyRoutinesActivity) context).updateSelectedExerciseRepsInSet(position, newVal);
            }
        });

        return rowView;
    }

}
