package se.chalmers.group22.gymcompanion.View.Main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.MainActivity;

public class MainHomeFragment extends Fragment {
    public static MainHomeFragment newInstance() {
        MainHomeFragment fragment = new MainHomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /*@Override
    public void onStart(){
        super.onStart();
        Button showProgress = (Button)getView().findViewById(R.id.btnGotoProgress);

        showProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProgress();
            }
        });
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_home, container, false);
    }
}
