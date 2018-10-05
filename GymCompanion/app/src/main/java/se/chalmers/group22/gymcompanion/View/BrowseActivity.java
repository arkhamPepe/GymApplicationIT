package se.chalmers.group22.gymcompanion.View;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import se.chalmers.group22.gymcompanion.Presenter.BrowsePresenter;
import se.chalmers.group22.gymcompanion.R;

public class BrowseActivity extends AppCompatActivity implements INavigation{

    public static final int index = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        Intent intent1 = new Intent(this, MainActivity.class);
        Intent intent2 = new Intent(this, BrowseActivity.class);
        Intent intent3 = new Intent(this, ScheduleActivity.class);
        Intent intent4 = new Intent(this, MyRoutinesActivity.class);
        Intent intent5 = new Intent(this, StatisticsActivity.class);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);

        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(index);
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
                        overridePendingTransition(0, 0);
                        return true;
                    }
                });

        BrowsePresenter browsePresenter = new BrowsePresenter(this);

        SearchView searchView = findViewById(R.id.searchBar);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextChange(String newText) {
                browsePresenter.search(newText);
                return false;
            }
            @Override
            public boolean onQueryTextSubmit(String query) {
                browsePresenter.search(query);
                return false;
            }
        });
    }

    @Override
    public void startActivityBrowse(View view) {
        // NOTHING
    }

    @Override
    public void startActivityMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void startActivityStatistics(View view) {
        Intent intent = new Intent(this, StatisticsActivity.class);
        startActivity(intent);
    }

    @Override
    public void startActivityMyRoutines(View view) {
        Intent intent = new Intent(this, MyRoutinesActivity.class);
        startActivity(intent);
    }

    @Override
    public void startActivitySchedule(View view) {
        Intent intent = new Intent(this, ScheduleActivity.class);
        startActivity(intent);
    }

}
