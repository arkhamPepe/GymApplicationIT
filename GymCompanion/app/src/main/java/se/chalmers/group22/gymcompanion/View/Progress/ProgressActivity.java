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

    public void goToStart(View view){
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.show(fragmentStart);
        transaction.hide(fragmentEditRoutine);
        transaction.commit();
    }

    public void goToEditRoutine(View view){
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.hide(fragmentStart);
        transaction.show(fragmentEditRoutine);
        transaction.commit();
    }

    //Goes back to MainActivity with an extra boolean so that the Finished Fragment is in focus
    public void goToFinished(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_CLEAR_TASK);

        //Currently the value of the boolean doesn't matter, it only matters that it exists
        intent.putExtra("Finished Workout",true);

        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    //ESCAPE
    //Goes back to the start page of MainActivity
    public void goToHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }


}
