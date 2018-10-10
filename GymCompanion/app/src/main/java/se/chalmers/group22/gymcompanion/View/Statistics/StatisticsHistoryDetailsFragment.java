package se.chalmers.group22.gymcompanion.View.Statistics;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.R;

public class StatisticsHistoryDetailsFragment extends Fragment {
        public static StatisticsHistoryDetailsFragment newInstance() {
            StatisticsHistoryDetailsFragment fragment = new StatisticsHistoryDetailsFragment();
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_statistics_history_details, container, false);
        }

        public void onStart(){
            super.onStart();

            update();
        }

        private void update(){
            // TODO: Use ViewModel here
            String newRoutineName;
            String[] exerciseNames;
            int[] exerciseSets;


            TextView routineName = (TextView) getActivity().findViewById(R.id.txtHistoryDetailsTitle);
            ListView exerciseList = (ListView) getActivity().findViewById(R.id.listviewHistoryDetails);
        }
}
