package com.project.ToDoList.repository;

import com.project.ToDoList.entity.User;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class DBRepository {
    private String url = "jdbc:mysql://localhost:3306/users?useUnicode=true&serverTimezone=UTC";
    private String username = "root";
    private String password = "admin";

    public int addUser(User user) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into users (login, password) values (?,?)");
                preparedStatement.setString(1, user.getLogin());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.execute();
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        return 1;
    }

    private int getUserID (User user) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select users.id from users where login = ?");
                preparedStatement.setString(1, user.getLogin());
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    return id;
                } else {
                    return -1;
                }
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private int getUserID (String login) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select users.id from users where login = ?");
                preparedStatement.setString(1, login);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    return id;
                } else {
                    return -1;
                }
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return -1;
    }
}