package ru.otus;


public class Hw_2 {
    public static void main(String[] args) {

    }

//реализация первого метода
    public static void line_output(int number, String sentence) {
        for (int i = 0; i < number; i++) {
            System.out.println(sentence);
        }
    }

//реализация второго метода
    public static void sum_of_the_elements_greater_than_5(int[] arr) {
        int summa = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 5) {
                summa += arr[i];
            }
        }
        System.out.println(summa);
    }

//реализация третьего метода
    public static void filling_the_array(int number, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = number;
        }
    }

//реализация четвертого метода
    public static void increment_each_array_element(int number, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += number;
        }
    }

//реализация пятого метода
    public static void comparing_halves_of_array(int[] arr) {
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