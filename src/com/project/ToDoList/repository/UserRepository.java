package com.project.ToDoList.repository;

import com.project.ToDoList.entity.User;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class UserRepository {
    private String url = "jdbc:mysql://localhost:3306/todolist?useUnicode=true&serverTimezone=UTC";
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

        // -1 - если узер не добавился, значит и не найден в БД, иначе возврат ID в BD юзера
        int userID = getUserID(user);
        if (userID != -1) {
            return userID;
        } else {
            return -1;
        }
    }

    public int dellUser(User user) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("delete from users where id = ?");
                preparedStatement.setInt(1, user.getId());
                preparedStatement.execute();
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }

//        // -1 - если узер не добавился, значит и не найден в БД, иначе возврат ID в BD юзера
//        int userID = getUserID(user);
//        if (userID != -1) {
//            return userID;
//        } else {
//            return -1;
//        }
        return 1;
    }

    public int getUserID (User user) {
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

    public int getUserID (String login) {
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