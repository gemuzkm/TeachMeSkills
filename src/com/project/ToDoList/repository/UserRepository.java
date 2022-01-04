package com.project.ToDoList.repository;

import com.project.ToDoList.entity.User;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;

public class UserRepository {
    private String url = "jdbc:mysql://localhost:3306/todolist?useUnicode=true&serverTimezone=UTC";
    private String username = "root";
    private String password = "admin";

    public int addUser(User user) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into users (user_login, user_password, user_role ) values (?,?,?)");
                preparedStatement.setString(1, user.getLogin());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setInt(3, user.getRole());
                preparedStatement.execute();
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        // -1 - если юзер не добавился, значит и не найден в БД, иначе возврат ID в BD юзера
        int userID = getUserID(user);
        if (userID != -1) {
            return userID;
        } else {
            return -1;
        }
    }

    public int updateUser(User user) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("update users set user_login = ?, user_password = ? where user_id = ?;");
                preparedStatement.setString(1, user.getLogin());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setInt(3, user.getId());
                preparedStatement.execute();
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        // -1 - если юзер не обновился, значит и не найден в БД, иначе возврат ID
        int userID = getUserID(user.getLogin());
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
                PreparedStatement preparedStatement = connection.prepareStatement("delete from users where user_id = ?");
                preparedStatement.setInt(1, user.getId());
                preparedStatement.execute();
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return 1;
    }

    public int getUserID(User user) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select users.user_id from users where user_login = ?");
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

    public int getUserID(String login) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select users.user_id from users where user_login = ?");
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

    public int getUserID(int idUser) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select users.user_id from users where users.user_id = ?");
                preparedStatement.setInt(1, idUser);
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

    public boolean checkUserPassword(String userLogin, String userPassword) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select user_login, user_password from users where user_login = ?");
                preparedStatement.setString(1, userLogin);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String userLoginFromDB = resultSet.getString(1);
                    String userPasswordFromDB = resultSet.getString(2);
                    if (userLogin.equals(userLoginFromDB) && userPassword.equals(userPasswordFromDB))
                    return true;
                }
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getUserInfo(int idUser) {
        String userInfo = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("" +
                        "select users.user_id, users.user_login, users.user_password, user_role.role_name from users\n" +
                        "inner join user_role on users.user_role = user_role.role_id where users.user_id = ?;");
                preparedStatement.setInt(1, idUser);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    userInfo = "ID - " + resultSet.getInt(1) +
                            ", Login - " + resultSet.getString(2) +
                            ", Password - " + resultSet.getString(3) +
                            ", Role - " + resultSet.getString(4);
                }
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return userInfo;
    }

    public ArrayList<String> getAllUserInfo() {
        ArrayList<String> listAllUserInfo = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("" +
                        "select users.user_id, users.user_login, users.user_password, user_role.role_name from users\n" +
                        "inner join user_role on users.user_role = user_role.role_id;");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    listAllUserInfo.add("ID - " + resultSet.getInt(1) +
                            ", Login - " + resultSet.getString(2) +
                            ", Password - " + resultSet.getString(3) +
                            ", Role - " + resultSet.getString(4));
                }
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return listAllUserInfo;
    }
}