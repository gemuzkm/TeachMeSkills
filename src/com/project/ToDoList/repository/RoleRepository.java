package com.project.ToDoList.repository;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.HashMap;

public class RoleRepository {
    private String url = "jdbc:mysql://localhost:3306/todolist?useUnicode=true&serverTimezone=UTC";
    private String username = "root";
    private String password = "admin";

    public HashMap<Integer, String> getListRole() {
        HashMap<Integer, String> listRole = new HashMap<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from user_role order by id");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    listRole.put(resultSet.getInt(1), resultSet.getString(2));
                }
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        return listRole;
    }

    public int getRoleID(int iDrole) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select user_role.id from user_role where id = ?");
                preparedStatement.setInt(1, iDrole);
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
