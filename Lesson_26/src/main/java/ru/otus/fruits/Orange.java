package ru.otus.fruits;


public class Orange extends Fruit {
    public Orange(double weight) {
        super(weight);
    }
    @Override
    public String toString() {
        return "Orange{" +
                "weight=" + weight +
                '}';
    }
}
