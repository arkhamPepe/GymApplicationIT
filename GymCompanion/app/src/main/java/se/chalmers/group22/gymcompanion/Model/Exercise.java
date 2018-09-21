package se.chalmers.group22.gymcompanion.Model;

public abstract class Exercise {
    private int repetitions;
    private int sets;
    private String name;

    //Might need a class

    public Exercise(){}

    public int getRepetitions() {
        return repetitions;
    }

    public int getSets() {
        return sets;
    }

    public String getName() {
        return name;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public void setName(String name) {
        this.name = name;
    }
}
