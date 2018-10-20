package se.chalmers.group22.gymcompanion.Model;

import se.chalmers.group22.gymcompanion.Model.Exercises.CardioExercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.StrengthExercise;

public interface ExerciseVisitor {
    void visit(StrengthExercise exercise);
    void visit(CardioExercise exercise);
}
