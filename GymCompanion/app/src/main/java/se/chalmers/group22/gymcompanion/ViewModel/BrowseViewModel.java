package se.chalmers.group22.gymcompanion.ViewModel;

import se.chalmers.group22.gymcompanion.Model.LocalDatabase;
import se.chalmers.group22.gymcompanion.Model.User;

public class BrowseViewModel extends BaseViewModel {
    public BrowseViewModel(){
        init();
    }

    private void init(){
        LocalDatabase localDatabase = LocalDatabase.getInstance();
        User loadedUser = localDatabase.loadUser();
        //getModel().setUser(loadedUser);
    }
}
