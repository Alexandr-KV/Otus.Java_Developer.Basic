package ru.otus.java;

public class Main {
    public static void main(String[] args) {

        long time1 = System.currentTimeMillis();
        double[] array1 = new double[100_000_000];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
        long time2 = System.currentTimeMillis() - time1;
        System.out.println("Время выполнения реализации 1: " + time2);

        double[] array2 = new double[100_000_000];
        Thread first = new Thread(() -> {
            for (int i = 0; i < array2.length / 4; i++) {
                array2[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
        });
        Thread second = new Thread(() -> {
            for (int i = 25_000_000; i < array2.length / 2; i++) {
                array2[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
        });
        Thread third = new Thread(() -> {
            for (int i = 50_000_000; i < array2.length * 0.75; i++) {
                array2[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
        });
        Thread fourth = new Thread(() -> {
            for (int i = 75_000_000; i < array2.length; i++) {
                array2[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
        });
        first.start();
        second.start();
        third.start();
        fourth.start();
        try {
            first.join();
            second.join();
            third.join();
            fourth.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Время выполнения реализации 2: " + (System.currentTimeMillis() - time1 - time2));
    }
}
