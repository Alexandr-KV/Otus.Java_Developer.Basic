package ru.otus;

public class AppArraySizeException extends RuntimeException{
    public String getMessage(){
        return "Неверный размер массива";
    }
}
