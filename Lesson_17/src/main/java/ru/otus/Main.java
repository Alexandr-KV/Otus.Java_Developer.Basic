package ru.otus;


import java.util.Arrays;

import static ru.otus.Sorting.bubbleSort;

public class Main {
    public static void main(String[] args) {
        PersonDataBase dataBase = new PersonDataBase();
        Person person1 = new Person("Alex", Position.BRANCH_DIRECTOR, 96391465321L);
        Person person2 = new Person("Oleg", Position.SENIOR_MANAGER, 87634521847L);
        Person person3 = new Person("Dima", Position.DEVELOPER, 32736194736L);
        Person person4 = new Person("Ivan", Position.ENGINEER, 10180023452L);
        dataBase.add(person1);
        dataBase.add(person2);
        dataBase.add(person3);
        dataBase.add(person4);
        System.out.println(dataBase.findById(96391465321L));
        System.out.println(dataBase.isEmployee(10180023452L));
        System.out.println(dataBase.isEmployee(87634521847L));
        System.out.println(dataBase.isManager(person2));
        System.out.println(dataBase.isManager(person4));

        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(array));
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}