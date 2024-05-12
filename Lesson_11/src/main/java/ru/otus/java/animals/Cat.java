package ru.otus.java.animals;

public class Cat extends Animal {
    public Cat(String name, int runningSpeed, int stamina) {
        super(name, runningSpeed, stamina);
    }

    @Override
    public double swim(double distance) {
        System.out.println(name + " плавать не умеет");
        return -1;
    }
}
