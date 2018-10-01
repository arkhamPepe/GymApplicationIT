package se.chalmers.group22.gymcompanion.Presenter;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import se.chalmers.group22.gymcompanion.View.IView;
import se.chalmers.group22.gymcompanion.View.ScheduleActivity;

import java.util.ArrayList;
import java.util.List;

public class SchedulePresenter implements IPresenter {

    private IView IView;
    private ScheduleActivity scheduleActivity;

    public List<String> getWeekdays() {
        return weekdays;
    }

    private List<String> weekdays;

    public SchedulePresenter(ScheduleActivity scheduleActivity){
        this.scheduleActivity = scheduleActivity;
        this.weekdays = new ArrayList<>();
    }

    public void fillList(){
        // Weekdays array
        weekdays.add("Monday");
        weekdays.add("Tuesday");
        weekdays.add("Wednesday");
        weekdays.add("Thursday");
        weekdays.add("Friday");
        weekdays.add("Saturday");
        weekdays.add("Sunday");
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
