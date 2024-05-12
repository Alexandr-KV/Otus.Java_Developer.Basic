package ru.otus.java.animals;

public class Horse extends Animal {
    public Horse(String name, int runningSpeed, int swimmingSpeed, int stamina) {
        super(name, runningSpeed, stamina);
        this.swimmingSpeed = swimmingSpeed;
    }

    @Override
    public double swim(double distance) {
        if (distance * 4 > stamina) {
            stamina = 0;
            System.out.println(name + " устал");
            return -1;
        } else {
            stamina -= distance * 4;
            return distance / swimmingSpeed;
        }
    }
}
