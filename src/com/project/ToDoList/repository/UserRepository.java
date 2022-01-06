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

        int userID = getUserId(user);
        if (userID != -1) {
            return userID;
        } else {
            return -1;
        }
    }

    public int updateUserLogin(User user) {
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
        int userID = getUserId(user.getLogin());
        if (userID != -1) {
            return userID;
        } else {
            return -1;
        }
    }

    public int updateUserLogin(int userId, String newLogin) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("update users set user_login = ? where user_id = ?;");
                preparedStatement.setString(1, newLogin);
                preparedStatement.setInt(2, userId);
                preparedStatement.execute();
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        int userID = getUserId(userId);
        if (userID != -1) {
            return userID;
        } else {
            return -1;
        }
    }

    public int updateUserPassword(int userId, String newPassword) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("update users set user_password = ? where user_id = ?;");
                preparedStatement.setString(1, newPassword);
                preparedStatement.setInt(2, userId);
                preparedStatement.execute();
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        int userID = getUserId(userId);
        if (userID != -1) {
            return userID;
        } else {
            return -1;
        }
    }

    public boolean updateUserRole(int userId, int newRoleId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("update users set user_role = ? where user_id = ?;");
                preparedStatement.setInt(1, newRoleId);
                preparedStatement.setInt(2, userId);
                preparedStatement.execute();
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        if (checkUserRole(userId, newRoleId)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean delUser(int idUser) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("delete from users where user_id = ?");
                preparedStatement.setInt(1, idUser);
                preparedStatement.execute();
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        int userID = getUserId(idUser);
        if (userID == -1) {
            return true;
        } else {
            return false;
        }
    }

    public int getUserId(User user) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select users.user_id from users where user_login = ?");
                preparedStatement.setString(1, user.getLogin());
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    return id;
                }
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int getUserId(String login) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select users.user_id from users where user_login = ?");
                preparedStatement.setString(1, login);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    return id;
                }
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int getUserId(int userId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select users.user_id from users where users.user_id = ?");
                preparedStatement.setInt(1, userId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    return id;
                }
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public boolean checkUserRole(int userId, int roleId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select user_id, user_role from users where user_id = ?;");
                preparedStatement.setInt(1, userId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    int userIdBD = resultSet.getInt(1);
                    int roleIdBD = resultSet.getInt(2);
                    if (userId == userIdBD && roleId == roleIdBD)
                        return true;
                }
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkUserPassword(String login, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, this.password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select user_login, user_password from users where user_login = ?");
                preparedStatement.setString(1, login);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String loginBD = resultSet.getString(1);
                    String passwordBD = resultSet.getString(2);
                    if (login.equals(loginBD) && password.equals(passwordBD))
                        return true;
                }
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getUserInfo(int userId) {
        String userInfo = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("" +
                        "select users.user_id, users.user_login, users.user_password, user_role.role_name from users " +
                        "inner join user_role on users.user_role = user_role.role_id where users.user_id = ?;");
                preparedStatement.setInt(1, userId);
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

    public ArrayList<String> getUsersInfo() {
        ArrayList<String> listUsersInfo = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("" +
                        "select users.user_id, users.user_login, users.user_password, user_role.role_name from users " +
                        "inner join user_role on users.user_role = user_role.role_id order by users.user_id;");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    listUsersInfo.add("ID - " + resultSet.getInt(1) +
                            ", Login - " + resultSet.getString(2) +
                            ", Password - " + resultSet.getString(3) +
                            ", Role - " + resultSet.getString(4));
                }
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return listUsersInfo;
    }
}