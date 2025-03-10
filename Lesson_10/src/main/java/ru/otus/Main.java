package ru.otus;


public class Main {
    public static void main(String[] args) {
        User[] users = {
                new User("0", "0", "1", 1980, "e-mail1"),
                new User("0", "0", "2", 1999, "e-mail2"),
                new User("0", "0", "3", 1982, "e-mail3"),
                new User("0", "0", "4", 1983, "e-mail4"),
                new User("0", "0", "5", 1984, "e-mail5"),
                new User("0", "0", "6", 1985, "e-mail6"),
                new User("0", "0", "7", 1986, "e-mail7"),
                new User("0", "0", "8", 1970, "e-mail8"),
                new User("0", "0", "9", 1976, "e-mail9"),
                new User("0", "1", "0", 2008, "e-mail10"),
        };
        for (int i = 0; i < users.length; i++) {
            if (2024 - users[i].getYearOfBirth() > 40) {
                users[i].userInfo();
            }
        }
    }
}