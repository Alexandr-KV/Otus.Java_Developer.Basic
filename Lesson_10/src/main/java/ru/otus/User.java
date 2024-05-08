package ru.otus;

public class User {
    //Поля класса
    private String surname;
    private String name;
    private String nameOfFather;
    private int yearOfBirth;
    private String email;

    //Конструктор
    public User(String surname, String name, String nameOfFather, int yearOfBirth, String email) {
        this.surname = surname;
        this.name = name;
        this.nameOfFather = nameOfFather;
        this.yearOfBirth = yearOfBirth;
        this.email = email;
    }

    //getters/setters
    public int getYearOfBirth() {
        return yearOfBirth;
    }

    //Метод, выводящий информацию о пользователе
    public void userInfo() {
        System.out.println("ФИО: " + surname + " " + name + " " + nameOfFather);
        System.out.println("Год рождения: " + yearOfBirth);
        System.out.println("e-mail: " + email);
    }

}