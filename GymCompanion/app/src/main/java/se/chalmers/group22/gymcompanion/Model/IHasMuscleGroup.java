package se.chalmers.group22.gymcompanion.Model;

import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;

public interface IHasMuscleGroup {

    boolean containsMuscleGroup(MUSCLE_GROUP mg);

    String getName();

    Double getDifficulty();
}
