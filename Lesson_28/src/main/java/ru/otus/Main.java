package ru.otus;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        try (ExecutorService executor = Executors.newFixedThreadPool(3)) {
            Object monitor = new Object();
            Counter counter = new Counter(0);
            executor.execute(() -> printChar(monitor, counter, 'A', 0, 1));
            executor.execute(() -> printChar(monitor, counter, 'B', 1, 2));
            executor.execute(() -> printChar(monitor, counter, 'C', 2, 0));
        }
    }

    private static void printChar(Object monitor, Counter counter, char symbol, int expectedCount, int nextCount) {
        synchronized (monitor) {
            for (int i = 0; i < 5; i++) {
                while (counter.getCount() != expectedCount) {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new IllegalStateException(e);
                    }
                }
                System.out.print(symbol);
                counter.setCount(nextCount);
                monitor.notifyAll();
            }
        }
    }
}