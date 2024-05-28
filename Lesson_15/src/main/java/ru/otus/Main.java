package ru.otus;


import java.util.ArrayList;
import java.util.List;

import static ru.otus.Employee.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = createAList(1, 10);
        System.out.println(list);
        System.out.println(sumOfElementsGreaterThanFive(list));
        incrementEachListItem(3, list);
        System.out.println(list);
        fillingOutTheList(5, list);
        System.out.println(list);
        System.out.println();

        Employee employee1 = new Employee("Alex", 15);
        Employee employee2 = new Employee("Vladimir", 24);
        Employee employee3 = new Employee("Dmitriy", 18);
        Employee employee4 = new Employee("Vlad", 21);
        Employee employee5 = new Employee("Sergey", 12);
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);

        System.out.println(employeeNames(employees));
        System.out.println(employeesOverTheMinimumAge(employees, 18));
        System.out.println(youngestEmployee(employees));
        System.out.println(averageAge(employees, 15));
        System.out.println(averageAge(employees, 18));
    }

    public static ArrayList<Integer> createAList(int min, int max) { //ArrayList возвращает по условию
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            list.add(i);
        }
        return list;
    }

    public static int sumOfElementsGreaterThanFive(List<Integer> list) {
        int summa = 0;
        for (Integer elem : list) {
            if (elem > 5) {
                summa += elem;
            }
        }
        return summa;
    }

    public static void fillingOutTheList(int number, List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, number);
        }
    }

    public static void incrementEachListItem(int number, List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, number + list.get(i));
        }
    }

}