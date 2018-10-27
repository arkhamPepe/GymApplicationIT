package se.chalmers.group22.gymcompanion.View;

import se.chalmers.group22.gymcompanion.ViewModel.AbstractObservableViewModel;

/***
 * Title: ObserverActivity
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 25, 2018
 *
 * Purpose: Makes sure all subclasses to this class tells their viewModel to remove itself from Models observer list
 *
 * Used by: BrowseActivity.java, MyRoutinesActivity.java, ProgressActivity.java, ScheduleActivity.java
 * StatisticsActivity.java
 *
 * Uses: AbstractObservableViewModel.java, BaseActivity.java
 *
 */

public abstract class ObserverActivity extends BaseActivity{
    @Override
    abstract public AbstractObservableViewModel getViewModel();

    @Override
    public void onPause() {
        super.onPause();
        AbstractObservableViewModel.getModel().removeModelObserver(getViewModel());
    }
}
