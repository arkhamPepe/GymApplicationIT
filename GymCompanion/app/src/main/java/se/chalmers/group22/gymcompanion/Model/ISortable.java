package se.chalmers.group22.gymcompanion.Model;

import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;

public interface ISortable {

    boolean containsMuscleGroup(MUSCLE_GROUP mg);

    String getName();

    Double getDifficulty();
}
