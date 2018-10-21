package se.chalmers.group22.gymcompanion.Model;


/***
 * Title: Observable
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
 * Used by: ObservableViewModel.java
 * Uses: Observer.java
 */

public interface Observable {
    void notifyObservers();
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
}
