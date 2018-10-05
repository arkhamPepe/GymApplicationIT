package se.chalmers.group22.gymcompanion.View.Progress;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.Main.MainActivity;
import se.chalmers.group22.gymcompanion.View.Main.MainFinishedFragment;
import se.chalmers.group22.gymcompanion.View.Main.MainStartFragment;

public class ProgressActivity extends AppCompatActivity {

    final FragmentManager fm = getSupportFragmentManager();
    final Fragment fragmentStart = new ProgressStartFragment();
    final Fragment fragmentEditRoutine = new ProgressEditRoutineFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.progress_container, fragmentStart, "1");
        transaction.add(R.id.progress_container, fragmentEditRoutine, "1").hide(fragmentEditRoutine);
        transaction.commit();

    }

    public void goToFinished(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.putExtra("Finished Workout",true);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    //ESCAPE
    public void goToHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.putExtra("Finished Workout",false);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }


}
