package se.chalmers.group22.gymcompanion.View;

import android.support.v4.app.Fragment;
import se.chalmers.group22.gymcompanion.View.Home.HomeFinishedFragment;
import se.chalmers.group22.gymcompanion.View.Home.HomeStartFragment;

public class FragmentFactory {

    public static Fragment createHomeStartFragment(){
        return new HomeStartFragment();
    }

    public static Fragment createHomeFinishedFragment(){
        return new HomeFinishedFragment();
    }

}
