package ru.otus.java;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        satiety = false;
    }

    public void eat(Plate plate) {
        satiety = plate.reducingTheAmountOfFood(appetite);
    }

    public void info() {
        if (satiety) {
            System.out.println(name + " сыт");
        } else {
            System.out.println(name + " голоден");
        }
    }

}
