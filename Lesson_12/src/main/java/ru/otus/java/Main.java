package ru.otus.java;


public class Main {
    public static void main(String[] args) {

        Plate plate = new Plate(100);

        Cat[] cats = {
                new Cat("Барсик", 15),
                new Cat("Мурзик", 20),
                new Cat("Тихон", 25),
                new Cat("Леопольд", 30),
                new Cat("Кузя", 35),
                new Cat("Феликс", 40)
        };

        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
            cats[i].info();
        }
    }
}