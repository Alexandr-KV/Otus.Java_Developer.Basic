package ru.otus;

import java.util.ArrayList;
import java.util.List;

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

    public static List<String> employeeNames(List<Employee> list) {
        List<String> names = new ArrayList<>();
        for (Employee emp : list) {
            names.add(emp.name);
        }
        return names;
    }

    public static List<Employee> employeesOverTheMinimumAge(List<Employee> list, int minAge) {
        List<Employee> list2 = new ArrayList<>();
        for (Employee emp : list) {
            if (emp.age >= minAge) {
                list2.add(emp);
            }
        }
        return list2;
    }

    public static boolean averageAge(List<Employee> list, double minAverageAge) {
        int sumOfAges = 0;
        for (Employee emp : list) {
            sumOfAges += emp.age;
        }
        return minAverageAge < (double) sumOfAges / list.size();
    }

    public static Employee youngestEmployee(List<Employee> list) {
        Employee youngestEmployee = list.get(0);
        for (Employee emp : list) {
            if (youngestEmployee.age > emp.age) {
                youngestEmployee = emp;
            }
        }
        return youngestEmployee;
    }

}
