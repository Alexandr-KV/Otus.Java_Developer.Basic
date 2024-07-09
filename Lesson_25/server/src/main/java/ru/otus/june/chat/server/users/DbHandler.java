package ru.otus.june.chat.server.users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DbHandler {
    public static Connection connection;
    public static Statement statement;
    public static ResultSet resSet;

    public static void Connect() throws ClassNotFoundException, SQLException {
        connection = null;
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:D:/users.db");
        System.out.println("База Подключена!");
        statement = connection.createStatement();
    }

    public static List<User> ReadDB() throws SQLException {
        resSet = statement.executeQuery("SELECT * FROM users");
        List<User> users = new ArrayList<>();
        while (resSet.next()) {
            String login = resSet.getString("login");
            String password = resSet.getString("password");
            String username = resSet.getString("username");
            String role = resSet.getString("role");
            users.add(new User(login, password, username, role));
        }
        return users;
    }

    public static void WriteDB(String login, String password, String username, String role) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("insert into users (login, password, username, role) values (?, ?, ?, ?)");
        ps.setString(1, login);
        ps.setString(2, password);
        ps.setString(3, username);
        ps.setString(4, role);
        ps.executeUpdate();
    }

    public static void CloseDB() throws SQLException {
        connection.close();
        statement.close();
        resSet.close();
        System.out.println("Соединения закрыты");
    }
}
