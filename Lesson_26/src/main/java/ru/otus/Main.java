package ru.otus;


import ru.otus.fruits.Apple;
import ru.otus.fruits.Fruit;
import ru.otus.fruits.Orange;

public class Main {
    public static void main(String[] args) {
        Box<Fruit> fruitBox = new Box<>();
        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Apple apple1 = new Apple(3);
        Apple apple2 = new Apple(2);
        Orange orange1 = new Orange(3);
        Orange orange2 = new Orange(5);

        appleBox.add(apple1);
        orangeBox.add(orange1);
        fruitBox.add(apple2);
        fruitBox.add(orange2);

        System.out.println(appleBox);
        System.out.println(orangeBox);
        System.out.println(fruitBox);

        System.out.println(appleBox.weight());
        System.out.println(orangeBox.weight());
        System.out.println(fruitBox.weight());

        System.out.println(appleBox.compare(orangeBox));
        System.out.println(fruitBox.compare(appleBox));

        Box<Apple> appleBox1 = new Box<>();
        appleBox1.add(apple1);
        appleBox1.get(apple1);
        fruitBox.get(apple2);
        appleBox1.add(apple2);

        appleBox.pourOver(appleBox1);

        System.out.println(appleBox);
        System.out.println(appleBox1);
    }
}