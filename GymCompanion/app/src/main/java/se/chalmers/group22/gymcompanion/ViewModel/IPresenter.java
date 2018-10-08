package se.chalmers.group22.gymcompanion.ViewModel;

public interface IPresenter {

    public void onCreate();

    public void onPause();

    public void onResume();

    public void onDestroy();
}
