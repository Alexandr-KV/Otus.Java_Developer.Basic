package ru.otus;

public class AppArrayDataException extends RuntimeException{
    private int i;
    private int j;

    public AppArrayDataException(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public String getMessage(){
        return "Неверное значение массива, ошибка в ячейке: (" + i + "," + j + ")";
    }
}
