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
 * Used by: Observable.java, ObservableViewModel.java, BrowseAddExerciseFragment.java,
 *      BrowseRecommendedFragment.java, MyRoutinesCardioExerciseFragment.java, MyRoutinesPickExerciseFragment.java,
 *      MyRoutinesRoutineInfoFragment.java, MyRoutinesStartFragment.java, MyRoutinesStrengthExerciseFragment.java,
 *      StatisticsHistoryDetailsFragment.java, StatisticsStartFragment.java, BrowseResultFragment.java,
 *      MyRoutinesStrengthExerciseSetsAdapter.java
 * Uses: NA
 */
public interface Observer {
    void update();
}
