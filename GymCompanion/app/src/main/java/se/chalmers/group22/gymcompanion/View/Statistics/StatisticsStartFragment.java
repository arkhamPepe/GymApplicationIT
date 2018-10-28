package se.chalmers.group22.gymcompanion.View.Statistics;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import se.chalmers.group22.gymcompanion.Model.ViewModelObserver;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.ViewModel.StatisticsViewModel;

/***
 * Title: StatisticsStartFragment
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 5, 2018
 *
 * Purpose: Fragment connected to a xml displaying the Statistics Start Page in the app
 * Uses: StatisticsViewModel.java, fragment_statistics_start.xml
 * Used by: FragmentFactory.java
 */
public class StatisticsStartFragment extends Fragment implements ViewModelObserver {

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
        viewModel.addObserver(this);

        drawGraph();
        updateWeekLabel();
    }

    @Override
    public void onPause(){
        viewModel.removeObserver(this);
        super.onPause();
    }

    @Override
    public void update() {
        drawGraph();
        updateWeekLabel();
    }

    /** drawGraph
     * Purpose: Draw the graph from scratch
     */
    private void drawGraph(){
        GraphView graph = getView().findViewById(R.id.start_graph);
        graph.removeAllSeries();

        DataPoint[] dataPoints = viewModel.getDataPoints(); // Points in graph

        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dataPoints);

        graph.addSeries(series);

        graph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(getActivity()));
        graph.getGridLabelRenderer().setTextSize(40);
        //graph.getGridLabelRenderer().setNumHorizontalLabels(1); // only 3 because of the space

        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(dataPoints[0].getX());
        graph.getViewport().setMaxX(dataPoints[6].getX());

        graph.getGridLabelRenderer().setHumanRounding(false);
    }

    private void updateWeekLabel(){
        TextView week = getView().findViewById(R.id.txtStatisticsWeekNumber);
        week.setText(viewModel.getDisplayedWeek());
    }
}
