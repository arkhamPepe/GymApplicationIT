package se.chalmers.group22.gymcompanion.View.Progress;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.BaseActivity;
import se.chalmers.group22.gymcompanion.View.Home.HomeActivity;
import se.chalmers.group22.gymcompanion.ViewModel.ProgressViewModel;

public class ProgressActivity extends BaseActivity {

    private final FragmentManager fm = getSupportFragmentManager();
    private final Fragment fragmentStart = new ProgressStartFragment();
    private final Fragment fragmentEditRoutine = new ProgressEditRoutineFragment();

    private ProgressViewModel progressViewModel = new ProgressViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.progress_container, fragmentStart, "1");
        transaction.add(R.id.progress_container, fragmentEditRoutine, "1").hide(fragmentEditRoutine);
        transaction.commit();

        ListView progStartListView = findViewById(R.id.progStartListView);

        //fillSchedule();

        //progressViewModel.fillList();

        // Adapter takes activity context, type of list view and the array as parameters
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this,
                R.layout.progress_start_list_item);

/*        progStartListView.setAdapter(arrayAdapter);

        progStartListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            // argument position gives the index of item which is clicked
            public void onItemClick(AdapterView<?> arg0, View v,int position, long arg3)
            {

            }
        });

*/

    }

    private void startProgressFillList(){

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

    //Goes back to HomeActivity with an extra boolean so that the Finished Fragment is in focus
    public void goToFinished(View view){
        Intent intent = new Intent(this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_CLEAR_TASK);

        //Currently the value of the boolean doesn't matter, it only matters that it exists
        intent.putExtra("Finished Workout",true);

        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    //ESCAPE
    //Goes back to the start page of HomeActivity
    public void goToHome(View view){
        Intent intent = new Intent(this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    public ProgressViewModel getViewModel(){
        return progressViewModel;
    }

}
