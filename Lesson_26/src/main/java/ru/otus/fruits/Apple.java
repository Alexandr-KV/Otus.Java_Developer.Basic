package ru.otus.fruits;


public class Apple extends Fruit {
    public Apple(double weight) {
        super(weight);
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                '}';
    }
}
