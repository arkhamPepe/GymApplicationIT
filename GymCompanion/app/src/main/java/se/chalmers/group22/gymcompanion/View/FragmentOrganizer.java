package se.chalmers.group22.gymcompanion.View;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentContainer;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import se.chalmers.group22.gymcompanion.R;

import java.util.ArrayList;
import java.util.List;

/***
 * Title: FragmentOrganizer
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 12, 2018
 *
 * Purpose: Help-class for Activities that aids the in setting up and changing between their fragments
 */

public class FragmentOrganizer {

    private List<Fragment> fragments = null;
    private FragmentManager fm;
    private Fragment navigationFragment;
    private int id;

    public FragmentOrganizer(List<Fragment> fragments, FragmentManager fragmentManager,
                             Fragment navigationFragment, int id){
        this.fragments = new ArrayList<>(fragments);
        this.fm = fragmentManager;
        this.navigationFragment = navigationFragment;
        this.id = id;
    }

    public FragmentOrganizer(List<Fragment> fragments, FragmentManager fragmentManager, int id){
        this.fragments = new ArrayList<>(fragments);
        this.fm = fragmentManager;
        this.navigationFragment = null;
        this.id = id;
    }

    public void setUpFragments(Fragment startFocus){

        FragmentTransaction transaction = fm.beginTransaction();

        for (Fragment f:fragments) {
            transaction.add(id,f).hide(f);
        }

        if(navigationFragment != null){
            transaction.add(R.id.navigation,navigationFragment);
        }

        transaction.show(startFocus);
        transaction.commit();
    }

    public void changeToFragment(Fragment changeFocus){
        FragmentTransaction transaction = fm.beginTransaction();

        for (Fragment f:fragments) {
           transaction.hide(f);
        }
        transaction.show(changeFocus);
        transaction.commit();
    }

}
