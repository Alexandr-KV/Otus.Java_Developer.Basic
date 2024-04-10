
//Задание со звездочкой

package ru.otus.java;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int entered_value = scanner.nextInt();
        if (entered_value == 1){
            greetings();
        } else if (entered_value == 2){
            int first_argument = (int) (Math.random()*101);
            int second_argument = (int) -(Math.random()*101);
            int third_argument = (int) (Math.random()*101);
            checkSign(first_argument,second_argument,third_argument);
        } else if (entered_value == 3){
            selectColor();
        } else if (entered_value == 4){
            compareNumbers();
        } else if (entered_value == 5){
            int first_argument = (int) (Math.random()*101);
            int second_argument = (int) -(Math.random()*101);
            boolean third_argument = Math.random() < 0.5;
            addOrSubtractAndPrint(first_argument,second_argument,third_argument);
        }
    }


    public static void greetings(){
        System.out.println("Hello");
        System.out.println("World");
        System.out.println("from");
        System.out.print("Java");
    }

    public static void checkSign(int a, int b, int c){
        if (a + b + c >= 0){
            System.out.print("Сумма положительная");
        } else {
            System.out.print("Сумма отрицательная");
        }
    }

    public static void selectColor(){
        int data = (int) (Math.random()*31);
        if (data <= 10){
            System.out.print("Красный");
        } else if (data <= 20) {
            System.out.print("Желтый");
        } else {
            System.out.print("Зеленый");
        }
    }

    public static void compareNumbers(){
        int a = (int) (Math.random()*101);
        int b = (int) (Math.random()*101);
        if (a >= b){
            System.out.print("a >= b");
        } else {
            System.out.print("a < b");
        }
    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment){
        if (increment){
            System.out.print(initValue + delta);
        } else {
            System.out.print(initValue - delta);
        }
    }
}
