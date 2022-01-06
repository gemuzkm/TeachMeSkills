package com.project.ToDoList.repository;

import com.project.ToDoList.entity.Task;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class TaskRepository {
    private String url = "jdbc:mysql://localhost:3306/todolist?useUnicode=true&serverTimezone=UTC";
    private String username = "root";
    private String password = "admin";

    public int getTaskId(int taskId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select user_task.task_id from user_task where task_id = ?;");
                preparedStatement.setInt(1, taskId);
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


    public ArrayList<String> getListTasksFromUserId(int userId) {
        ArrayList<String> listTasks = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("" +
                        "select task_id, task_name, task_status.status_name,task_category.category_name from user_task " +
                        "inner join task_status on user_task.task_status = task_status.status_id " +
                        "inner join task_category on user_task.task_category = task_category.category_id " +
                        "where user_task.user_id = ? order by task_id;");
                preparedStatement.setInt(1, userId);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    listTasks.add("ID - " + resultSet.getInt(1) +
                            ", Name - " + resultSet.getString(2) +
                            ", Status - " + resultSet.getString(3) +
                            ", Category - " + resultSet.getString(4));
                }
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return listTasks;
    }

    public String getTaskInfoByTaskId(int taskId) {
        String taskInfo = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("" +
                        "select task_id, task_name, task_status.status_name,task_category.category_name,users.user_login from user_task " +
                        "inner join task_status on user_task.task_status = task_status.status_id " +
                        "inner join task_category on user_task.task_category = task_category.category_id " +
                        "inner join users on user_task.user_id = users.user_id " +
                        "where user_task.task_id = ?");
                preparedStatement.setInt(1, taskId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    taskInfo = "ID - " + resultSet.getInt(1) +
                            ", Name - " + resultSet.getString(2) +
                            ", Status - " + resultSet.getString(3) +
                            ", Category - " + resultSet.getString(4) +
                            ", Owner - " + resultSet.getString(5);
                }
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return taskInfo;
    }

    public ArrayList<String> getTasks() {
        ArrayList<String> listTasks = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("" +
                        "select task_id, task_name, task_status.status_name,task_category.category_name,users.user_login from user_task " +
                        "inner join task_status on user_task.task_status = task_status.status_id " +
                        "inner join task_category on user_task.task_category = task_category.category_id " +
                        "inner join users on user_task.user_id = users.user_id " +
                        "order by task_id;");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    listTasks.add("ID - " + resultSet.getInt(1) +
                            ", Name - " + resultSet.getString(2) +
                            ", Status - " + resultSet.getString(3) +
                            ", Category - " + resultSet.getString(4) +
                            ", Owner - " + resultSet.getString(5));
                }
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return listTasks;
    }

    public String getTaskInfoFromUserIdAndTaskId(int userId, int taskId) {
        String taskInfo = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("" +
                        "select user_task.task_id, user_task.task_name, task_status.status_name, task_category.category_name from user_task " +
                        "inner join task_status on user_task.task_status = task_status.status_id " +
                        "inner join task_category on user_task.task_category = task_category.category_id where user_task.user_id = ? and user_task.task_id = ?;");
                preparedStatement.setInt(1, userId);
                preparedStatement.setInt(2, taskId);
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

    public HashMap<Integer, String> getListStatus() {
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

    public HashMap<Integer, String> getListCategory() {
        HashMap<Integer, String> listCategory = new HashMap<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select category_id,category_name from task_category order by category_id;");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    listCategory.put(resultSet.getInt(1), resultSet.getString(2));
                }
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return listCategory;
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

    public int updateTaskStatusByTaskIdAndStatusId(int taskId, int statusId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("update user_task set task_status = ? where task_id = ?;");
                preparedStatement.setInt(1, statusId);
                preparedStatement.setInt(2, taskId);
                preparedStatement.execute();
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        if (getStatusIdByTaskId(taskId) == statusId) {
            return statusId;
        }
        return -1;
    }

    private int getStatusIdByTaskId(int taskId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select user_task.task_status from user_task where task_id = ?;");
                preparedStatement.setInt(1, taskId);
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

    public int getIdForStatusName(String statusName) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select task_status.status_id from task_status where status_name = ?;");
                preparedStatement.setString(1, statusName);
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

    public int getIdForCategoryName(String categoryName) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select category_id from task_category where category_name = ?;");
                preparedStatement.setString(1, categoryName);
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

    public boolean checkTaskNameByTaskNameAndUserId(String taskName, int userId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select task_id from user_task where user_id = ? and task_name = ?;");
                preparedStatement.setInt(1, userId);
                preparedStatement.setString(2, taskName);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return true;
                }
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkTaskByTaskNameAndTaskId(String taskName, int taskId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select task_id from user_task where task_id = ? and task_name = ?;");
                preparedStatement.setString(1, taskName);
                preparedStatement.setInt(2, taskId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return true;
                }
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkTaskByTaskIdAndUserId(int taskId, int userId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select task_id from user_task where task_id = ? and user_id = ?;");
                preparedStatement.setInt(1, taskId);
                preparedStatement.setInt(2, userId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return true;
                }
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkTaskByTaskIdAndCategoryId(int taskId, int categoryId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select task_id from user_task where task_id = ? and task_category = ?;");
                preparedStatement.setInt(1, taskId);
                preparedStatement.setInt(2, categoryId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return true;
                }
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getCategoryId(int categoryId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select category_id from task_category where category_id = ?;");
                preparedStatement.setInt(1, categoryId);
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

    public boolean addTask(Task task) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into user_task (task_name, user_id, task_status, task_category) values (?,?,?,?);");
                preparedStatement.setString(1, task.getName());
                preparedStatement.setInt(2, task.getIdUser());
                preparedStatement.setInt(3, task.getStatus());
                preparedStatement.setInt(4, task.getIdCategory());
                preparedStatement.execute();
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return checkTaskNameByTaskNameAndUserId(task.getName(),task.getIdUser());
    }

    public boolean delTaskByTaskId(int taskId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("delete from user_task where task_id = ?;");
                preparedStatement.setInt(1, taskId);
                preparedStatement.execute();
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        if (getTaskId(taskId) == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean updateTaskName(int idTask, String newTaskName) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("update user_task set task_name = ? where task_id = ?;");
                preparedStatement.setString(1, newTaskName);
                preparedStatement.setInt(2, idTask);
                preparedStatement.execute();
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return checkTaskByTaskNameAndTaskId(newTaskName, idTask);
    }

    public boolean updateUserIdByTaskIdAndUserId(int taskId, int userId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("update user_task set user_id = ? where task_id = ?;");
                preparedStatement.setInt(1, userId);
                preparedStatement.setInt(2, taskId);
                preparedStatement.execute();
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return checkTaskByTaskIdAndUserId(taskId, userId);
    }

    public boolean updateCategoryIdByTaskIdAndCategoryId(int taskId, int categoryId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("update user_task set task_category = ? where task_id = ?;");
                preparedStatement.setInt(1, categoryId);
                preparedStatement.setInt(2, taskId);
                preparedStatement.execute();
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return checkTaskByTaskIdAndCategoryId(taskId, categoryId);
    }

    public boolean addCategory(String categoryName) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into  task_category (category_name) values (?);");
                preparedStatement.setString(1, categoryName);
                preparedStatement.execute();
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        if (getIdForCategoryName(categoryName) != -1) {
            return true;
        } else {
            return false;
        }
    }

    public String getNameCategoryForCategoryId(int categoryId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select category_name from task_category where category_id = ?;");
                preparedStatement.setInt(1, categoryId);
                preparedStatement.execute();
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return resultSet.getString(1);
                }
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return "";
    }

    public boolean delCategory(int categoryId, int defaultCategoryId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement updateToDefaultCategory = connection.prepareStatement("update user_task set task_category = ? where task_category = ?;");
                updateToDefaultCategory.setInt(1, defaultCategoryId);
                updateToDefaultCategory.setInt(2, categoryId);
                updateToDefaultCategory.execute();
                PreparedStatement deleteCategory = connection.prepareStatement("delete from task_category where category_id = ?;");
                deleteCategory.setInt(1, categoryId);
                deleteCategory.execute();
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        if (getCategoryId(categoryId) == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean updateCategoryName(int categoryId, String newNameCategory) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("update task_category set category_name = ? where category_id = ?;");
                preparedStatement.setString(1, newNameCategory);
                preparedStatement.setInt(2, categoryId);
                preparedStatement.execute();
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        if (getIdForCategoryName(newNameCategory) == categoryId) {
            return true;
        } else {
            return false;
        }
    }
}