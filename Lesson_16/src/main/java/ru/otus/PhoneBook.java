package ru.otus;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PhoneBook {

    public PhoneBook() {
    }

    Map<String, HashSet<Long>> phoneBook = new HashMap<>();

    public void add(String name, Long number) {
        HashSet<Long> values = new HashSet<>();
        if (phoneBook.get(name) != null) {
            values = phoneBook.get(name);
        }
        values.add(number);
        phoneBook.put(name, values);
    }

    public void find(String name) {
        System.out.print(name + ": ");
        if (phoneBook.get(name) == null) {
            System.out.println("number missing");
            return;
        }
        for (Long number : phoneBook.get(name)) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    public boolean containsPhoneNumber(Long number) {
        for (Map.Entry<String, HashSet<Long>> entry : phoneBook.entrySet()) {
            for (Long num : entry.getValue()) {
                if (num.equals(number)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "phoneBook=" + phoneBook +
                '}';
    }

}
