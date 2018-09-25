package se.chalmers.group22.gymcompanion.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.R;

public class ScheduleActivity extends AppCompatActivity implements IView {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        TextView ScheduleTitle = findViewById(R.id.ScheduleTitle);

        ScheduleTitle.setAllCaps(true);
    }
}
