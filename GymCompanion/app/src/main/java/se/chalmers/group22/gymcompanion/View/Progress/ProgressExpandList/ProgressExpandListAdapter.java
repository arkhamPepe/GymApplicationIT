package se.chalmers.group22.gymcompanion.View.Progress.ProgressExpandList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.R;

import java.util.ArrayList;

public class ProgressExpandListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<ProgressExpandListGroup> groups;

    public ProgressExpandListAdapter(Context context, ArrayList<ProgressExpandListGroup> groups) {
        this.context = context;
        this.groups = groups;
    }

    public void addItem(ProgressExpandListChild item, ProgressExpandListGroup group) {

        if (!groups.contains(group)) {
            groups.add(group);
        }

        int index = groups.indexOf(group);
        ArrayList<ProgressExpandListChild> ch = groups.get(index).getItems();
        ch.add(item);
        groups.get(index).setItems(ch);
    }

    public Object getChild(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        ArrayList<ProgressExpandListChild> chList = groups.get(groupPosition).getItems();

        return chList.get(childPosition);
    }

    public long getChildId(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        return childPosition;
    }

    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup parent) {

        ProgressExpandListChild child = (ProgressExpandListChild) getChild(groupPosition, childPosition);

        if (view == null) {
            LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = infalInflater.inflate(R.layout.expand_list_child_progress, null);
        }

        TextView setNumber = view.findViewById(R.id.expandableListSetNumber);
        TextView reps = view.findViewById(R.id.expandableListReps);
        TextView kilograms = view.findViewById(R.id.expandableListKilograms);
        reps.setText("Repetitions: " + child.getReps());
        kilograms.setText("Kilograms: " + child.getWeight());
        setNumber.setText("Set " + childPosition + ":");
        // TODO Auto-generated method stub

        Log.d("Hello","Creating Child Views");
        return view;
    }

    public int getChildrenCount(int groupPosition) {
        // TODO Auto-generated method stub
        ArrayList<ProgressExpandListChild> chList = groups.get(groupPosition).getItems();

        return chList.size();
    }

    public Object getGroup(int groupPosition) {
        // TODO Auto-generated method stub
        return groups.get(groupPosition);
    }

    public int getGroupCount() {
        // TODO Auto-generated method stub
        return groups.size();
    }

    public long getGroupId(int groupPosition) {
        // TODO Auto-generated method stub
        return groupPosition;
    }

    public View getGroupView(int groupPosition, boolean isLastChild, View view, ViewGroup parent) {

        ProgressExpandListGroup group = (ProgressExpandListGroup) getGroup(groupPosition);

        if (view == null) {
            LayoutInflater inf = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inf.inflate(R.layout.expand_list_group_progress, null);
        }

        TextView exerciseName = view.findViewById(R.id.expandableListExerciseName);
        TextView extraInfo = view.findViewById(R.id.expandableListExtraInfo);
        exerciseName.setText(group.getExerciseName());
        extraInfo.setText(group.getExtraInfo());
        // TODO Auto-generated method stub
        Log.d("Hello","Creating Group Views");
        return view;
    }

    public boolean hasStableIds() {
        // TODO Auto-generated method stub
        return true;
    }

    public boolean isChildSelectable(int arg0, int arg1) {
        // TODO Auto-generated method stub
        return true;
    }

}
