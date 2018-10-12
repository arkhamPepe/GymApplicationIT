package se.chalmers.group22.gymcompanion.View;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import se.chalmers.group22.gymcompanion.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentOrganizer {

    private List<Fragment> fragments;
    private FragmentManager fragmentManager;
    private NavigationFragment navigationFragment;

    public FragmentOrganizer(List<Fragment> f, FragmentManager fragmentManager, NavigationFragment nf){
        this.fragments.addAll(f);
        this.fragmentManager = fragmentManager;
        this.navigationFragment = nf;
    }

    /*public void performInitTransaction(){
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        int index = 2;
        for (Fragment f : fragments){
            if (f == active){
                transaction.add(R.id.statistics_container, f, "1");
            }
            else {
                transaction.add(R.id.statistics_container, f, String.valueOf(index)).hide(f);
                index++;
            }
        }
        transaction.add(R.id.navigation, navigationFragment);

        transaction.commit();
    }*/

}
