package se.chalmers.group22.gymcompanion.View.Statistics;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import se.chalmers.group22.gymcompanion.R;

public class StatisticsStartFragment extends Fragment {

    public static StatisticsStartFragment newInstance() {
        StatisticsStartFragment fragment = new StatisticsStartFragment();
        return fragment;
    }

    LineGraphSeries<DataPoint> series;

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
        x = -5.0;

        GraphView graphView = (GraphView)getView().findViewById(R.id.start_graph);
        series = new LineGraphSeries<DataPoint>();
        for(int i = 0; i < 500; i++) {
            x += 0.1;
            y=Math.sin(x);
            series.appendData(new DataPoint(x, y), true, 500);
        }
        graphView.addSeries(series);
    }
}
