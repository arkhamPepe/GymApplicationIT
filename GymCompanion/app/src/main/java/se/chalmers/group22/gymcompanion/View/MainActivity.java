package se.chalmers.group22.gymcompanion.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import se.chalmers.group22.gymcompanion.View.Home.HomeActivity;
import se.chalmers.group22.gymcompanion.ViewModel.BaseViewModel;
import se.chalmers.group22.gymcompanion.ViewModel.MainViewModel;

/***
 * Title: MainActivity
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: September 20, 2018
 *
 * Purpose: Used for initial setup of the application. Is not used again after setup
 *
 * Used by: N/A
 *
 * Uses: HomeActivity.java, BaseActivity.java, MainViewModel.java
 */

public class MainActivity extends BaseActivity {

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.viewModel = new MainViewModel();
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public MainViewModel getViewModel() {
        return viewModel;
    }
}
