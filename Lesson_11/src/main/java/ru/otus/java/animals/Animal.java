package ru.otus.java.animals;

public abstract class Animal {
    protected String name;
    protected double runningSpeed;
    protected double swimmingSpeed;
    protected double stamina;
    //я выбрал тип double, потому что чтобы найти время, нужно
    //расстояние (distance) поделить на скорость (runningSpeed или swimmingSpeed)
    //и если скорость будет больше расстояния, то метод по нахождению времени будет возвращать 0(при типе int)

    public Animal(String name, int runningSpeed, int stamina) {
        this.name = name;
        this.runningSpeed = runningSpeed;
        this.stamina = stamina;
    }

    public double run(double distance) {
        if (distance > stamina) {
            stamina = 0;
            System.out.println(name + " устал");//Не совсем понял фразу:
            //если выносливости не хватает, то указываем что у животного появилось состояние усталости
            //Нужно вывести это сообщение в консоль или сделать что-то другое?
            return -1;
        } else {
            stamina -= distance;
            return distance / runningSpeed;
        }
    }

    public abstract double swim(double distance);

    public void info() {
        if (stamina > 0) {
            System.out.println(name + " бодр");
        } else {
            System.out.println(name + " устал");
        }
    }
}
