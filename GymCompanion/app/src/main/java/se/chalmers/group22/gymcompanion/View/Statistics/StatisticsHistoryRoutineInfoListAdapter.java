package se.chalmers.group22.gymcompanion.View.Statistics;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.R;

import java.util.ArrayList;

public class StatisticsHistoryRoutineInfoListAdapter extends ArrayAdapter {
    public StatisticsHistoryRoutineInfoListAdapter(Activity context){

        super(context, R.layout.listitem_history , new ArrayList());

        this.context = context;
    }

    //to reference the Activity
    private final Activity context;

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listitem_history, null,true);

        return rowView;

    };
}
