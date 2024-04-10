
// Задания 1-6

package ru.otus.java;

public class Task1 {
    public static void main(String[] args) {
        greetings();
        checkSign(1, 2, 3);
        selectColor();
        compareNumbers();
        addOrSubtractAndPrint(314, 27, false);
    }
        public static void greetings(){
        System.out.println("Hello");
        System.out.println("World");
        System.out.println("from");
        System.out.println("Java");
    }

    public static void checkSign(int a, int b, int c){
        if (a + b + c >= 0){
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void selectColor(){
        int data = (int) (Math.random()*31);
        if (data <= 10){
            System.out.println("Красный");
        } else if (data <= 20) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers(){
        int a = (int) (Math.random()*101);
        int b = (int) (Math.random()*101);
        if (a >= b){
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment){
        if (increment){
            System.out.println(initValue + delta);
        } else {
            System.out.println(initValue - delta);
        }
    }
}