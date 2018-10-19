package se.chalmers.group22.gymcompanion.Model;

public interface Observable {
    void notifyObservers();
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
}
