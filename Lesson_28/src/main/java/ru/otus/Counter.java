package ru.otus;

public class Counter {
    private volatile int count;

    public Counter(int count) {
        this.count = count;
    }

    public synchronized void setCount(int count) {
        this.count = count;
    }

    public synchronized int getCount() {
        return count;
    }
}
