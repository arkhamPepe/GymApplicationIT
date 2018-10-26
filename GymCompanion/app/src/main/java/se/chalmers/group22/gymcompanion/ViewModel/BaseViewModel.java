package se.chalmers.group22.gymcompanion.ViewModel;

import android.arch.lifecycle.ViewModel;
import se.chalmers.group22.gymcompanion.Model.GymCompanion;
/***
 * Title: BaseViewModel
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 12, 2018
 *
 * Purpose: Gives access to the model for all viewmodels
 */
public abstract class BaseViewModel extends ViewModel {
    private final static GymCompanion model = new GymCompanion();

    public static GymCompanion getModel() {
        return model;
    }

}
