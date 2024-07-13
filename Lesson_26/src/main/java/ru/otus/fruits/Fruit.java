package ru.otus.fruits;

public abstract class Fruit {
    protected final double weight;
    protected boolean inTheBox = false;

    protected Fruit(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public boolean getIsInTheBox() {
        return inTheBox;
    }

    public void setInTheBox(boolean inTheBox) {
        this.inTheBox = inTheBox;
    }
}
