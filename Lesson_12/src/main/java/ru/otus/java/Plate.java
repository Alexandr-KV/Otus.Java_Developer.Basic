package ru.otus.java;

public class Plate {
    private int currentAmountOfFood;
    private final int maximumAmountOfFood;

    public Plate(int maximumAmountOfFood) {
        this.maximumAmountOfFood = maximumAmountOfFood;
        this.currentAmountOfFood = maximumAmountOfFood;
    }

    public void addFood(int amountOfFood) {
        currentAmountOfFood += amountOfFood;
        if (currentAmountOfFood > maximumAmountOfFood) {
            currentAmountOfFood = maximumAmountOfFood;
        }
    }

    public boolean reducingTheAmountOfFood(int amountOfFood) {
        if (currentAmountOfFood > amountOfFood) {
            currentAmountOfFood -= amountOfFood;
            return true;
        }
        return false;
    }

}
