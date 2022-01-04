package com.project.ToDoList.repository;

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
                        "where user_task.user_id = ? order by task_id;");
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

    public ArrayList<String> getAllListTask() {
        ArrayList<String> listTaskByUser = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("" +
                        "select task_id, task_name, task_status.status_name,task_category.category_name,users.user_login from user_task\n" +
                        "inner join task_status on user_task.task_status = task_status.status_id\n" +
                        "inner join task_category on user_task.task_category = task_category.category_id\n" +
                        "inner join users on user_task.user_id = users.user_id\n" +
                        "order by task_id;");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    listTaskByUser.add("ID - " + resultSet.getInt(1) +
                            ", Name - " + resultSet.getString(2) +
                            ", Status - " + resultSet.getString(3) +
                            ", Category - " + resultSet.getString(4) +
                            ", Owner - " + resultSet.getString(5));
                }
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        return listTaskByUser;
    }

    public String getTaskInfoFromID(int idUser, int idTask) {
        String taskInfo = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("" +
                        "select user_task.task_id, user_task.task_name, task_status.status_name, task_category.category_name from user_task " +
                        "inner join task_status on user_task.task_status = task_status.status_id " +
                        "inner join task_category on user_task.task_category = task_category.category_id where user_task.user_id = ? and user_task.task_id = ?;");
                preparedStatement.setInt(1, idUser);
                preparedStatement.setInt(2, idTask);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    taskInfo = "ID - " + resultSet.getInt(1) +
                            ", Task - " + resultSet.getString(2) +
                            ", Status - " + resultSet.getString(3) +
                            ", Category - " + resultSet.getString(4);
                }
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        return taskInfo;
    }

    public HashMap<Integer, String> getListStatus () {
        HashMap<Integer, String> listStatus = new HashMap<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from task_status order by status_id");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    listStatus.put(resultSet.getInt(1), resultSet.getString(2));
                }
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return listStatus;
    }

    public int getStatusId(int idStatus) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select task_status.status_id from task_status where status_id = ?;");
                preparedStatement.setInt(1, idStatus);
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

    public int updateTaskStatus(int idTask, int idStatus) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("update user_task set task_status = ? where task_id = ?;");
                preparedStatement.setInt(1, idStatus);
                preparedStatement.setInt(2, idTask);
                preparedStatement.execute();
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        if (getStatusIdByTask(idTask) == idStatus) {
            return idStatus;
        }
        return -1;
    }

    private int getStatusIdByTask(int idTask) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select user_task.task_status from user_task where task_id = ?;");
                preparedStatement.setInt(1, idTask);
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
