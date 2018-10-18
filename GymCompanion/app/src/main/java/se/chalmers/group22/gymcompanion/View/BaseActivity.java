package se.chalmers.group22.gymcompanion.View;

import android.support.v7.app.AppCompatActivity;
import se.chalmers.group22.gymcompanion.ViewModel.BaseViewModel;

public abstract class BaseActivity extends AppCompatActivity {

    abstract public BaseViewModel getViewModel();

}
