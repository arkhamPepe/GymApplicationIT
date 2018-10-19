package se.chalmers.group22.gymcompanion.View.Browse;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.BrowseResultListAdapter;
import se.chalmers.group22.gymcompanion.ViewModel.BrowseViewModel;

public class BrowseResultFragment extends Fragment {

    private BrowseViewModel viewModel;
    private TextView currentMuscleGroup;
    private SearchView searchView;
    public static BrowseSelectionFragment getInstance() {
        return new BrowseSelectionFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_browse_results, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        viewModel = ((BrowseActivity) getActivity()).getViewModel();

        CheckBox cbxRoutines = (CheckBox)getView().findViewById(R.id.cbxRoutines);
        CheckBox cbxExercises = (CheckBox)getView().findViewById(R.id.cbxExercises);

        //Both of the listener onCheckedChanged methods also checks if the other checkbox is unchecked or not,
        //if the other is unchecked, there is a toast message shown and the pressed checkbox isnt getting
        //unchecked. You shouldnt be able to sort on "nothing".
        cbxRoutines.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                   if(cbxExercises.isChecked()) {
                       if(isChecked){
                           viewModel.filterRoutinesExercises(false, 1);
                       } else {
                           viewModel.filterRoutinesExercises(true, 1);
                       }
                   } else {
                       cbxRoutines.setChecked(true);
                       Toast.makeText(getActivity(), "You cant filter on nothing!", Toast.LENGTH_SHORT).show();
                   }
                   onResume();
               }
           }
        );
        cbxExercises.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                   if(cbxRoutines.isChecked()){
                       if(isChecked){
                           viewModel.filterRoutinesExercises(false, 0);
                       } else {
                           viewModel.filterRoutinesExercises(true, 0);
                       }
                   } else {
                       cbxExercises.setChecked(true);
                       Toast.makeText(getActivity(), "You cant filter on nothing!", Toast.LENGTH_SHORT).show();
                   }
                   onResume();
               }
           }
        );

        searchView = getView().findViewById(R.id.searchBar);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
            @Override
            public boolean onQueryTextSubmit(String query) {
                ((BrowseActivity)getActivity()).goToResultFromSearch(query);
                return false;
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        //************************************ACTIONBAR
        ((BrowseActivity) getActivity()).getSupportActionBar().setTitle("Browse Results");

        this.currentMuscleGroup = getView().findViewById(R.id.currentMuscleGroup);
        String t = "Browsing: " + viewModel.getCurrentPage();
        this.currentMuscleGroup.setText(t);


        //************************************LISTVIEW
        BrowseResultListAdapter adapter;
        ListView listView = getView().findViewById(R.id.listViewBrowseResult);
        adapter = new BrowseResultListAdapter(getActivity(),
                viewModel.getRoutineAndExerciseNames(),
                viewModel.getRoutineAndExerciseDifficulties(),
                viewModel.getRoutineAmountExercises(),
                0);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                //((BrowseActivity)getActivity()).scheduleRoutine();
                //Toast.makeText(getActivity(), "ListItem pressed", Toast.LENGTH_SHORT).show();
            }
        });

        //************************************DROPDOWN
        //DropDown menu from xml
        Spinner dropdown = getView().findViewById(R.id.dropdownSpinner);

       //List of items to be shown in the menu
        String[] items = viewModel.getSortFilters();

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(spinnerAdapter);

        //************************************SEARCHBAR
        //Sets the searchbar to what was searched on startfragment (may be empty if coming from muscle group selection)
        searchView.setQuery(viewModel.getQuery(), false);
    }
}
