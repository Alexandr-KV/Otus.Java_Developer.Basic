package ru.otus;


import ru.otus.fruits.Fruit;

import java.util.ArrayList;


public class Box<T extends Fruit> {

    private final ArrayList<T> fruits = new ArrayList<>();

    public ArrayList<T> getFruits() {
        return fruits;
    }

    public void add(T fruit) {
        if (fruit.getIsInTheBox()) {
            System.out.println("Фрукт " + fruit + " уже находится в какой-то коробке");
        } else {
            fruit.setInTheBox(true);
            fruits.add(fruit);
        }
    }

    public void get(T fruit) {
        if (fruits.contains(fruit)) {
            fruit.setInTheBox(false);
            fruits.remove(fruit);
        } else {
            System.out.println("Такого фрукта нет в этой коробке");
        }
    }

    public double weight() {
        double weightOfFruits = 0;
        for (Fruit f : fruits) {
            weightOfFruits += f.getWeight();
        }
        return weightOfFruits;
    }

    public boolean compare(Box<? extends Fruit> box) {
        return Math.abs(this.weight() - box.weight()) < 0.0001;
    }

    public void pourOver(Box<T> box) {
        if (box != null && !box.equals(this)) {
            box.fruits.addAll(this.fruits);
            this.fruits.clear();
        } else {
            System.out.println("Нельзя пересыпать фрукты в эту же " +
                    "или несуществующую коробку");
        }
    }

    @Override
    public String toString() {
        return "Box{" +
                "fruits=" + fruits +
                '}';
    }

}
