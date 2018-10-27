package se.chalmers.group22.gymcompanion.View.Browse;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import se.chalmers.group22.gymcompanion.Model.ViewModelObserver;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.ViewModel.BrowseViewModel;

/***
 * Title: BrowseRecommendedFragment
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 18, 2018
 *
 * Purpose: Fragment connected to a xml displaying the Recommended page in the app
 */


public class BrowseRecommendedFragment extends Fragment implements ViewModelObserver {
    private BrowseViewModel viewModel;
    public static BrowseRecommendedFragment getInstance(){ return new BrowseRecommendedFragment(); }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_browse_recommended, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        viewModel = ((BrowseActivity) getActivity()).getViewModel();
        viewModel.addObserver(this);
    }

    @Override
    public void onPause(){
        super.onPause();
        viewModel.removeObserver(this);
    }

    @Override
    public void update() {

    }
}
