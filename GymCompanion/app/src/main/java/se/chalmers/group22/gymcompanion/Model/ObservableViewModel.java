package se.chalmers.group22.gymcompanion.Model;


/***
 * Title: AbstractObservableViewModel
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 19, 2018
 *
 * Purpose: an interface that lets an object become observable, letting it notify those subscribed to it.
 * Used by: AbstractObservableViewModel.java
 * Uses: ViewModelObserver.java
 */

public interface ObservableViewModel {
    void notifyObservers();
    void addObserver(ViewModelObserver viewModelObserver);
    void removeObserver(ViewModelObserver viewModelObserver);
}
