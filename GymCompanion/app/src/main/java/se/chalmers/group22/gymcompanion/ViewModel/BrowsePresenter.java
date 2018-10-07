package se.chalmers.group22.gymcompanion.ViewModel;

import se.chalmers.group22.gymcompanion.Model.DataHandler;
import se.chalmers.group22.gymcompanion.Model.ISortable;
import se.chalmers.group22.gymcompanion.View.BrowseActivity;

import java.util.List;

public class BrowsePresenter implements IPresenter {

    BrowseActivity browseActivity;

    List<ISortable> displayList;


    public BrowsePresenter(BrowseActivity browseActivity){
        this.browseActivity = browseActivity;
    }

    public void search(String text){
        displayList = DataHandler.getInstance().search(text);
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }
}
