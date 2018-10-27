package se.chalmers.group22.gymcompanion.View;

import android.support.v4.app.Fragment;
import se.chalmers.group22.gymcompanion.View.Browse.*;
import se.chalmers.group22.gymcompanion.View.Home.HomeFinishedFragment;
import se.chalmers.group22.gymcompanion.View.Home.HomeStartFragment;
import se.chalmers.group22.gymcompanion.View.MyRoutines.*;
import se.chalmers.group22.gymcompanion.View.Progress.ProgressStartFragment;
import se.chalmers.group22.gymcompanion.View.Schedule.SchedulePickRoutineFragment;
import se.chalmers.group22.gymcompanion.View.Schedule.ScheduleStartFragment;
import se.chalmers.group22.gymcompanion.View.Statistics.StatisticsHistoryDetailsFragment;
import se.chalmers.group22.gymcompanion.View.Statistics.StatisticsHistoryFragment;
import se.chalmers.group22.gymcompanion.View.Statistics.StatisticsLifetimeStatsFragment;
import se.chalmers.group22.gymcompanion.View.Statistics.StatisticsStartFragment;

/***
 * Title: FragmentFactory
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 27, 2018
 *
 * Purpose: Factory-class for creating all the fragments needed for the activities. Mostly useful for fragments
 * used by several activities, like navigationfragment
 *
 * Used by: HomeActivity.java, ProgressActivity.java, StatisticsActivity.java, MyRoutinesActivity.java
 * ScheduleActivity.java, BrowseActivity.java
 *
 * Uses: NavigationFragment.java, HomeStartFragment.java, HomeFinishedFragment.java, ProgressStartFragment.java
 * StatisticsHistoryDetailsFragment.java, StatisticsStartFragment.java, StatisticsHistoryFragment.java,
 * StatisticsLifetimeStatsFragment.java, ScheduleStartFragment.java, SchedulePickRoutineFragment.java,
 * MyRoutinesCardioExerciseFragment.java, MyRoutinesExerciseInfoFragment.java, MyRoutinesPickMGFragment.java,
 * MyRoutinesPickExerciseFragment.java, MyRoutinesRoutineInfoFragment.java, MyRoutinesStartFragment.java,
 * MyRoutinesStrengthExerciseFragment.java, BrowseAddExerciseFragment.java, BrowseMuscleGroupsFragment.java,
 * BrowseRecommendedFragment.java, BrowseResultFragment.java, BrowseStartFragment.java
 *
 */

public class FragmentFactory {

    //Navigation

    public static Fragment createNavigationFragment(){
        return new NavigationFragment();
    }

    //HomeActivity
    public static Fragment createHomeStartFragment(){
        return new HomeStartFragment();
    }

    public static Fragment createHomeFinishedFragment(){
        return new HomeFinishedFragment();
    }

    //ProgressActivity
    public static Fragment createProgressStartFragment(){
        return new ProgressStartFragment();
    }

    //StatisticsActivity
    public static Fragment createStatisticsHistoryDetailsFragment(){
        return new StatisticsHistoryDetailsFragment();
    }

    public static Fragment createStatisticsStartFragment(){
        return new StatisticsStartFragment();
    }

    public static Fragment createStatisticsHistoryFragment(){
        return new StatisticsHistoryFragment();
    }

    public static Fragment createStatisticsLifetimeStatsFragment(){
        return new StatisticsLifetimeStatsFragment();
    }

    //ScheduleActivity
    public static Fragment createScheduleStartFragment(){
        return new ScheduleStartFragment();
    }

    public static Fragment createSchedulePickRoutineFragment(){
        return new SchedulePickRoutineFragment();
    }

    //BrowseActivity

    public static Fragment createMyRoutinesCardioExerciseFragment(){
        return new MyRoutinesCardioExerciseFragment();
    }

    public static Fragment createMyRoutinesExerciseInfoFragment(){
        return new MyRoutinesExerciseInfoFragment();
    }

    public static Fragment createMyRoutinesPickExerciseFragment(){
        return new MyRoutinesPickExerciseFragment();
    }

    public static Fragment createMyRoutinesPickMGFragment(){
        return new MyRoutinesPickMGFragment();
    }

    public static Fragment createMyRoutinesRoutineInfoFragment(){
        return new MyRoutinesRoutineInfoFragment();
    }

    public static Fragment createMyRoutinesStartFragment(){
        return new MyRoutinesStartFragment();
    }

    public static Fragment createMyRoutinesStrengthExerciseFragment(){
        return new MyRoutinesStrengthExerciseFragment();
    }

    //BrowseActivity

    public static Fragment createBrowseAddExerciseFragment(){
        return new BrowseAddExerciseFragment();
    }

    public static Fragment createBrowseMuscleGroupsFragment(){
        return new BrowseMuscleGroupsFragment();
    }

    public static Fragment createBrowseRecommendedFragment(){
        return new BrowseRecommendedFragment();
    }

    public static Fragment createBrowseResultFragment(){
        return new BrowseResultFragment();
    }

    public static Fragment createBrowseStartFragment(){
        return new BrowseStartFragment();
    }
}
