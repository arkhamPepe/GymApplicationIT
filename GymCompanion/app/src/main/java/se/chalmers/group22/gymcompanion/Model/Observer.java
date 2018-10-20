package se.chalmers.group22.gymcompanion.Model;

/***
 * Title: Observer
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 19, 2018
 *
 * Purpose: an interface that allows an object to become an observer to an observable. It updates as changes are notified.
 */
public interface Observer {
    void update();
}
