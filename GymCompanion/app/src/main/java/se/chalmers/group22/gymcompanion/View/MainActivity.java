package se.chalmers.group22.gymcompanion.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import com.google.android.flexbox.FlexboxLayout;
import se.chalmers.group22.gymcompanion.R;


public class MainActivity extends AppCompatActivity implements IView, INavigation {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btnHome = findViewById(R.id.btnMain);
        ImageButton btnSearch = findViewById(R.id.btnBrowse);
        ImageButton btnSchedule = findViewById(R.id.btnSchedule);
        ImageButton btnMyRoutines = findViewById(R.id.btnMyRoutines);
        ImageButton btnStatistics = findViewById(R.id.btnStatistics);

        startActivity(new Intent(this, ScheduleActivity.class));
        startActivity(new Intent(this, StatisticsActivity.class));
        startActivity(new Intent(this, BrowseActivity.class));
        startActivity(new Intent(this, MyRoutinesAcivity.class));

    }

    public void startActivitySchedule(View view){
        Intent intent = new Intent(this, ScheduleActivity.class);

        
        startActivity(intent);
    }

    public void startActivityMyRoutines(View view){
        Intent intent = new Intent(this, MyRoutinesAcivity.class);
        startActivity(intent);
    }

    public void startActivityStatistics(View view){
        Intent intent = new Intent(this, StatisticsActivity.class);
        startActivity(intent);
    }

    public void startActivityBrowse(View view){
        Intent intent = new Intent(this, BrowseActivity.class);
        startActivity(intent);
    }

    public void startActivityMain(View view){
        // NOTHING
    }
}
