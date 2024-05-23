package ru.otus.java;


import ru.otus.java.transport.*;

public class Main {
    public static void main(String[] args) {
        Bike bike = new Bike();
        AllTerrainVehicle allTerrainVehicle = new AllTerrainVehicle(10,3);
        Car car = new Car(6,2);
        Horse horse = new Horse(5,1);
        Human human = new Human("Sasha", 10,1);
        System.out.println(human.getName());
        human.getOnTransport(bike);
        System.out.println(human.ride(10,TypeOfGround.SWAMP));
        human.getOutOfTransport();
        human.getOnTransport(allTerrainVehicle);
        System.out.println(human.ride(3,TypeOfGround.PLAIN));
        human.getOutOfTransport();
        human.getOnTransport(car);
        System.out.println(human.ride(100,TypeOfGround.PLAIN));
        human.getOutOfTransport();
        human.getOnTransport(horse);
        System.out.println(human.ride(2,TypeOfGround.FOREST));
        human.getOutOfTransport();
        System.out.println(human.ride(10,TypeOfGround.SWAMP));
    }
}