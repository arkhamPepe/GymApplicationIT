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
import se.chalmers.group22.gymcompanion.Model.Observer;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.ViewModel.StatisticsViewModel;

/** StatisticsActivityFragment
 *  Purpose: Initial fragment of StatisticActivity
 *  Authors: Alexander Bergsten, Marcus Svensson, Erik Bock, Augustas Eidikis, Daniel Olsson
 * */

public class StatisticsStartFragment extends Fragment implements Observer {

    private StatisticsViewModel viewModel;

    public static StatisticsStartFragment newInstance() {
        StatisticsStartFragment fragment = new StatisticsStartFragment();
        return fragment;
    }

    /** onCreate(Bundle)
     *  Purpose: Initiates this fragment
     * */
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }

    /** onCreateView(LayoutInflater, ViewGroup, Bundle)
     *  @return View [fragment_statistics_start]
     * */
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_statistics_start, container, false);
    }

    /** onStart
     *  Purpose: Initiates the graph with values
     * */
    public void onStart(){
        super.onStart();

        viewModel = ((StatisticsActivity)getActivity()).getViewModel();


        double x = 0.0;
        int amountOfDots = 7;

        drawGraph(x,amountOfDots);

    }

    @Override
    public void update() {
        drawGraph(0, 7);
    }

    private void drawGraph(double x,int dots){
        //GraphView object
        GraphView graphView = getView().findViewById(R.id.start_graph);

        double y;

        PointsGraphSeries<DataPoint> seriesPoint = new PointsGraphSeries<DataPoint>();
        LineGraphSeries<DataPoint> seriesLine = new LineGraphSeries<DataPoint>();

        for(int i = 0; i < dots; i++) {
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
