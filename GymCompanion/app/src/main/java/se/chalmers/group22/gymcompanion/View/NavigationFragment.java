package se.chalmers.group22.gymcompanion.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.*;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.Browse.BrowseActivity;
import se.chalmers.group22.gymcompanion.View.Main.MainActivity;
import se.chalmers.group22.gymcompanion.View.MyRoutines.MyRoutinesActivity;
import se.chalmers.group22.gymcompanion.View.Schedule.ScheduleActivity;
import se.chalmers.group22.gymcompanion.View.Statistics.StatisticsActivity;

public class NavigationFragment extends Fragment {
    /** pageIndex
     * @value get set by the bundle "index" argument
     * */
    private int pageIndex;

    public static NavigationFragment newInstance(){
        return new NavigationFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null) {
            //pageIndex = savedInstanceState.getInt("index", 4);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        pageIndex = this.getArguments().getInt("index", 0);
        return inflater.inflate(R.layout.fragment_navigation, container, false);
    }


    /** onStart()
     *  Sets an intent for each activity in the nav bar, uses the index from corresponding activity
     *  to set change the color on the nav bar item you are on.
     *  Starts new activity via onNavigationItemSelected with its intent and overrides the standard android
     *  transition between activities (swipe animation).
     * */
    public void onStart(){
        super.onStart();
        Intent intent1 = new Intent(getActivity(), MainActivity.class);
        Intent intent2 = new Intent(getActivity(), BrowseActivity.class);
        Intent intent3 = new Intent(getActivity(), ScheduleActivity.class);
        Intent intent4 = new Intent(getActivity(), MyRoutinesActivity.class);
        Intent intent5 = new Intent(getActivity(), StatisticsActivity.class);

        BottomNavigationView bottomNavigationView = getView().findViewById(R.id.navigation);

        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(pageIndex);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Intent intent;
                        switch (item.getItemId()) {
                            case R.id.action_item1:
                                intent = intent1;
                                break;
                            case R.id.action_item2:
                                intent = intent2;
                                break;
                            case R.id.action_item3:
                                intent = intent3;
                                break;
                            case R.id.action_item4:
                                intent = intent4;
                                break;
                            case R.id.action_item5:
                                intent = intent5;
                                break;
                            default:
                                intent = intent1;
                                break;
                        }

                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                                Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        getActivity().overridePendingTransition(0, 0);
                        return true;
                    }
                });
    }
}
