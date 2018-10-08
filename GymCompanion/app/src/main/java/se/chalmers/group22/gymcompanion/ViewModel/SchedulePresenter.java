package se.chalmers.group22.gymcompanion.ViewModel;

import se.chalmers.group22.gymcompanion.Model.DataHandler;
import se.chalmers.group22.gymcompanion.View.IView;
import se.chalmers.group22.gymcompanion.View.Schedule.ScheduleActivity;

import java.util.*;

public class SchedulePresenter implements IPresenter {

    private IView IView;
    private ScheduleActivity scheduleActivity;
    private DataHandler dataHandler = DataHandler.getInstance();

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
        /*Map<Calendar, Routine> schedule = dataHandler.getSchedule();

        Iterator<Map.Entry<Calendar, Routine>> it = schedule.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Calendar, Routine> pair = it.next();
            weekdays.add(getDayOfWeek(pair.getKey().get(Calendar.DAY_OF_WEEK)) + ", " +
                    pair.getValue().getName());
        }*/

        weekdays.add("Monday");
        weekdays.add("Tuesday");
        weekdays.add("Wednesday");
        weekdays.add("Thursday");
        weekdays.add("Friday");
        weekdays.add("Saturday");
        weekdays.add("Sunday");
    }

    private String getDayOfWeek(int value) {
        String d = "";
        switch (value) {
            case 1:
                d = "Sunday";
                break;
            case 2:
                d = "Monday";
                break;
            case 3:
                d = "Tuesday";
                break;
            case 4:
                d = "Wednesday";
                break;
            case 5:
                d = "Thursday";
                break;
            case 6:
                d = "Friday";
                break;
            case 7:
                d = "Saturday";
                break;
        }
        return d;
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
