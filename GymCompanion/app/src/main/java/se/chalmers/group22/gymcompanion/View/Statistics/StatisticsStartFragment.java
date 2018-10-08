package se.chalmers.group22.gymcompanion.View.Statistics;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.*;
import se.chalmers.group22.gymcompanion.R;

public class StatisticsStartFragment extends Fragment {

    public static StatisticsStartFragment newInstance() {
        StatisticsStartFragment fragment = new StatisticsStartFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_statistics_start, container, false);
    }

    public void onStart(){
        super.onStart();
        double x,y;
        x = 0.0;
        y = 0.0;

        //GraphView object
        GraphView graphView = (GraphView)getView().findViewById(R.id.start_graph);


        PointsGraphSeries<DataPoint> seriesPoint = new PointsGraphSeries<DataPoint>();
        LineGraphSeries<DataPoint> seriesLine = new LineGraphSeries<DataPoint>();

        for(int i = 0; i < 7; i++) {
            x += 1;
            y=Math.pow(x, 2.0);

            seriesPoint.appendData(new DataPoint(x, y), true, 7);
            seriesLine.appendData(new DataPoint(x, y), true, 7);
        }

        seriesPoint.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPoint) {
                Toast.makeText(getActivity(), "DataPoint clicked: " + dataPoint, Toast.LENGTH_SHORT).show();
            }
        });

        seriesPoint.setShape(PointsGraphSeries.Shape.POINT);
        graphView.addSeries(seriesPoint);
        graphView.addSeries(seriesLine);
    }
}
