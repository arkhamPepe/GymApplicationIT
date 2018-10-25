package se.chalmers.group22.gymcompanion.Model;

/***
 * Title: ModelObserver
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 25, 2018
 *
 * Purpose: an interface that allows an object to become an observer to a ObservableModel. It updates as changes are notified.to it.
 * Used by: ObservableModel.java
 * Uses: NA
 */

public interface ModelObserver {
    void updateView();
}
