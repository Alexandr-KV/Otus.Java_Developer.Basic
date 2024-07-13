package ru.otus.june.chat.server.users;

public class User {
    protected String login;
    protected String password;
    protected String username;
    protected String role;

    protected User(String login, String password, String username, String role) {
        this.login = login;
        this.password = password;
        this.username = username;
        this.role = role;
    }
}
