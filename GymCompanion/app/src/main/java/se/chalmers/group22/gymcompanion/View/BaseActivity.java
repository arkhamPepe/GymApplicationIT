package se.chalmers.group22.gymcompanion.View;

import android.support.v7.app.AppCompatActivity;
import se.chalmers.group22.gymcompanion.ViewModel.BaseViewModel;

/***
 * Title: BaseActivity
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: September 20, 2018
 *
 * Purpose: Super-class for all methods and variables that are necessary for our non-setup Activities
 * but are not part of the standard AppCompatActivity
 */

public abstract class BaseActivity extends AppCompatActivity {
    abstract public BaseViewModel getViewModel();

}
