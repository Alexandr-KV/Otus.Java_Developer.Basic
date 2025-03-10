package ru.otus;


public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Alex", 82391465321L);
        phoneBook.add("Alex", 87634521847L);
        phoneBook.add("Dima", 82736194736L);
        phoneBook.find("Alex");
        phoneBook.find("Dima");
        phoneBook.find("Ivan");
        System.out.println(phoneBook.containsPhoneNumber(87634521847L));
        System.out.println(phoneBook.containsPhoneNumber(82736194736L));
        System.out.println(phoneBook.containsPhoneNumber(100000L));
    }
}