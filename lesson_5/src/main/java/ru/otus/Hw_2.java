package ru.otus;


import java.util.Arrays;

public class Hw_2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        lineOutput((int) (Math.random()*10), "Hello world!");
        sumOfTheElementsGreaterThan5(arr);
        fillingTheArray((int)(Math.random()*10),arr);
        System.out.println(Arrays.toString(arr));
        incrementEachArrayElement((int)(Math.random()*10),arr);
        System.out.println(Arrays.toString(arr));
        arr[(int)(Math.random()*9)] = (int)(Math.random()*10);
        //изменение рандомного элемента массива на рандомное число, чтобы вывод последнего метода не был одинаковым в каждом запуске
        comparingHalvesOfArray(arr);
    }

//реализация первого метода
    public static void lineOutput(int number, String sentence) {
        for (int i = 0; i < number; i++) {
            System.out.println(sentence);
        }
    }

//реализация второго метода
    public static void sumOfTheElementsGreaterThan5(int[] arr) {
        int summa = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 5) {
                summa += arr[i];
            }
        }
        System.out.println(summa);
    }

//реализация третьего метода
    public static void fillingTheArray(int number, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = number;
        }
    }

//реализация четвертого метода
    public static void incrementEachArrayElement(int number, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += number;
        }
    }

//реализация пятого метода
    public static void comparingHalvesOfArray(int[] arr) {
        int summa1 = 0;
        int summa2 = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            summa1 += arr[i];
        }
        for (int i = arr.length / 2; i < arr.length; i++) {
            summa2 += arr[i];
        }
        if (summa1 > summa2) {
            System.out.println("Сумма элементов первой половины массива больше суммы элементов второй половины");
        } else if (summa1 < summa2) {
            System.out.println("Сумма элементов второй половины массива больше суммы первой");
        } else if (summa1 == summa2) {
            System.out.println("Сумма элементов первой половины массива равна сумме элементов второй половины массива");
        }
    }

}