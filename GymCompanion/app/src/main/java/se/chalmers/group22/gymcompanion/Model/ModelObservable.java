package se.chalmers.group22.gymcompanion.Model;

/***
 * Title: ModelObservable
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 25, 2018
 *
 * Purpose: an interface that lets an object become observable of the model, letting it notify those subscribed to it.
 * Used by: ObservableViewModel.java
 * Uses: ModelObserver.java
 */

public interface ModelObservable {
    void notifyObservers();
    void addObserver(ModelObserver observer);
    void removeObserver(ModelObserver observer);
}
