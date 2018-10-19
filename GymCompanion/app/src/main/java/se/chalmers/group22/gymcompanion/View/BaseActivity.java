// Title    :  BaseActivity
// Authors  :  Alexander Bergsten, Marcus Svensson, Erik Bock, Augustas Eidikis, Daniel Olsson
// Created  :  September 20, 2018
//
// Purpose  :  Super-class for all methods and variables that are necessary for our non-setup Activities but are not part
//             of the standard AppCompatActivity
//----------------------------------------------------------------------------------------------

package se.chalmers.group22.gymcompanion.View;

import android.support.v7.app.AppCompatActivity;
import se.chalmers.group22.gymcompanion.ViewModel.BaseViewModel;

public abstract class BaseActivity extends AppCompatActivity {



    abstract public BaseViewModel getViewModel();

}
