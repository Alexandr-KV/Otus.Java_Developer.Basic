package ru.otus.java.animals;

public class Dog extends Animal {
    public Dog(String name, int runningSpeed, int swimmingSpeed, int stamina) {
        super(name, runningSpeed, stamina);
        this.swimmingSpeed = swimmingSpeed;
    }

    @Override
    public double swim(double distance) {
        if (distance * 2 > stamina) {
            stamina = 0;
            System.out.println(name + " устал");
            return -1;
        } else {
            stamina -= distance * 2;
            return distance / swimmingSpeed;
        }
    }
}
