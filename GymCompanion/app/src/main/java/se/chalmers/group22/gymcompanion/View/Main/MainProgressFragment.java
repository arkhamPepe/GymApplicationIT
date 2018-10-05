package se.chalmers.group22.gymcompanion.View.Main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import se.chalmers.group22.gymcompanion.R;

public class MainProgressFragment extends Fragment {
    public static MainProgressFragment newInstance() {
        MainProgressFragment fragment = new MainProgressFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /*@Override
    public void onStart(){
        super.onStart();
        Button goToProgress = (Button)getView().findViewById(R.id.btnGotoHome);

        goToProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });
    }
*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_progress, container, false);
    }
}
