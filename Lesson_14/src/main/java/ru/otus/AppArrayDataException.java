package ru.otus;

public class AppArrayDataException extends RuntimeException{
    public int i;
    public int j;

    public AppArrayDataException(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
