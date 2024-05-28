package ru.otus;

import java.util.ArrayList;

public class Employee {
    private final String name;
    private final int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static ArrayList<String> employeeNames(ArrayList<Employee> list) {
        ArrayList<String> names = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            names.add(list.get(i).name);
        }
        return names;
    }

    public static ArrayList<Employee> employeesOverTheMinimumAge(ArrayList<Employee> list, int minAge) {
        ArrayList<Employee> list2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).age >= minAge) {
                list2.add(list.get(i));
            }
        }
        return list2;
    }

    public static boolean averageAge(ArrayList<Employee> list, double minAverageAge) {
        int sumOfAges = 0;
        for (int i = 0; i < list.size(); i++) {
            sumOfAges += list.get(i).age;
        }
        return minAverageAge < (double) sumOfAges / list.size();
    }

    public static Employee youngestEmployee(ArrayList<Employee> list) {
        Employee youngestEmployee = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (youngestEmployee.age > list.get(i).age) {
                youngestEmployee = list.get(i);
            }
        }
        return youngestEmployee;
    }

}
