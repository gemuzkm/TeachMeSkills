package com.project.ToDoList.repository;

import com.lesson17.A;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class TaskRepository {
    private String url = "jdbc:mysql://localhost:3306/todolist?useUnicode=true&serverTimezone=UTC";
    private String username = "root";
    private String password = "admin";

    public ArrayList<String> getListTask(int userID) {
       ArrayList<String> listTaskByUser = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("" +
                        "select task_id, task_name, task_status.status_name,task_category.category_name from user_task " +
                        "inner join task_status on user_task.task_status = task_status.status_id " +
                        "inner join task_category on user_task.task_category = task_category.category_id " +
                        "where user_task.user_id = ?;");
                preparedStatement.setInt(1, userID);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    listTaskByUser.add("ID - " + resultSet.getInt(1) +
                            ", Name - " + resultSet.getString(2) +
                            ", Status - " + resultSet.getString(3) +
                            ", Category - " + resultSet.getString(4));
                }
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        return listTaskByUser;
    }
}
