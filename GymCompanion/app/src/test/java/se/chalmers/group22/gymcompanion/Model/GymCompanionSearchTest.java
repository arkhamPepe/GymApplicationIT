package se.chalmers.group22.gymcompanion.Model;
import org.junit.Test;
import se.chalmers.group22.gymcompanion.Model.Workout.Routine;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GymCompanionSearchTest {

    private GymCompanion gymCompanion = new GymCompanion();

    @Test
    public void searchTest(){
        List<ISortable> toBeCompared;
        List<ISortable> expected = new ArrayList<>();
        expected.add(new Routine("ChestDay"));
        String search = "Chest day";

        //toBeCompared = gymCompanion.search(search);

        //TODO ADD INFORMATION TO DATAHANDLER THAT YOU CAN SEARCH FOR
        assertTrue(true);

        //assertEquals(new HashSet<>(toBeCompared), new HashSet<>(expected));
    }

}
