package ru.otus;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Object monitor = new Object();
        Counter counter = new Counter(0);
        executor.execute(() -> {
            synchronized (monitor) {
                for (int i = 0; i < 5; i++) {
                    while (counter.getCount() != 0) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("A");
                    counter.setCount(1);
                    monitor.notifyAll();
                }
            }
        });

        executor.execute(() -> {
            synchronized (monitor) {
                for (int i = 0; i < 5; i++) {
                    while (counter.getCount() != 1) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("B");
                    counter.setCount(2);
                    monitor.notifyAll();
                }
            }
        });

        executor.execute(() -> {
            synchronized (monitor) {
                for (int i = 0; i < 5; i++) {
                    while (counter.getCount() != 2) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("C");
                    counter.setCount(0);
                    monitor.notifyAll();
                }
            }
        });
        executor.close();
    }
}