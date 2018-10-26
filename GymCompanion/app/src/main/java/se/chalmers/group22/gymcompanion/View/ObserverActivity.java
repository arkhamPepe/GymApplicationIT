package se.chalmers.group22.gymcompanion.View;

import se.chalmers.group22.gymcompanion.ViewModel.AbstractObservableViewModel;

public abstract class ObserverActivity extends BaseActivity{
    @Override
    abstract public AbstractObservableViewModel getViewModel();

    @Override
    public void onPause() {
        super.onPause();
        AbstractObservableViewModel.getModel().removeModelObserver(getViewModel());
    }
}
