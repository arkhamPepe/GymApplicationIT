package se.chalmers.group22.gymcompanion.ViewModel;

import se.chalmers.group22.gymcompanion.Model.Observable;
import se.chalmers.group22.gymcompanion.Model.Observer;

import java.util.ArrayList;
import java.util.List;


/***
 * Title: ObservableViewModel
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 19, 2018
 *
 * Purpose: All Viewmodels that are observable handle observers in the same way,
 * which means that code could be abstracted out of them into a common super class
 */

abstract public class ObservableViewModel extends BaseViewModel implements Observable {

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void notifyObservers() {
        for (Observer o : observers){
            o.update();
        }
    }

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }
}
