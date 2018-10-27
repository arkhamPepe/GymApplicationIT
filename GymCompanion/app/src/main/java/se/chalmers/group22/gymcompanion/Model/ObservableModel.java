package se.chalmers.group22.gymcompanion.Model;

/***
 * Title: ObservableModel
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
 * Used by: AbstractObservableViewModel.java
 * Uses: ModelObserver.java
 */

public interface ObservableModel {
    void notifyModelObservers();
    void addModelObserver(ModelObserver observer);
    void removeModelObserver(ModelObserver observer);
}
