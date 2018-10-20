package se.chalmers.group22.gymcompanion.Model;

public interface ExerciseElement {
    void accept(ExerciseVisitor visitor);
}
