package com.project.ToDoList.service;

import com.project.ToDoList.entity.Task;
import com.project.ToDoList.repository.TaskRepository;

import java.util.ArrayList;
import java.util.HashMap;

public class TaskService {
    private TaskRepository taskRepository = new TaskRepository();
    private Task task;

    public void listUserTasks(int userId) {
        ArrayList<String> listUserTasks = taskRepository.getListTasksFromUserId(userId);
        System.out.println("\nСписок заданий пользователя:\n");
        listUserTasks.forEach(System.out::println);
    }

    public int getTaskStatusId(int statusId) {
        return taskRepository.getStatusId(statusId);
    }

    public String getTaskInfoByUserIdAndTaskId(int userId, int taskId) {
        String taskInfo = taskRepository.getTaskInfoFromUserIdAndTaskId(userId, taskId);
        if (taskInfo.length() == 0) {
            return "Проверьте корректность вводимых данных";
        }
        return taskInfo;
    }

    public int getTaskId(int taskId) {
        int taskIdBD = taskRepository.getTaskId(taskId);
        return taskIdBD;
    }

    public void listTaskStatus() {
        HashMap<Integer, String> listTaskStatus = taskRepository.getListStatus();
        ;
        listTaskStatus.forEach((k, v) -> {
            System.out.println("ID - " + k + ", Название статуса - " + v);
        });
    }

    public int updateTaskStatus(int taskId, int statusId) {
        int resultUpdate = taskRepository.updateTaskStatusByTaskIdAndStatusId(taskId, statusId);
        return resultUpdate;
    }

    public String getTaskInfo(int taskId) {
        return taskRepository.getTaskInfoByTaskId(taskId);
    }

    public int getIdForStatusName(String statusName) {
        int idStatus = taskRepository.getIdForStatusName(statusName);
        return idStatus;
    }

    public int getIdForCategoryName(String categoryName) {
        int idCategory = taskRepository.getIdForCategoryName(categoryName);
        return idCategory;
    }

    public int getCategoryId(int categoryId) {
        return taskRepository.getCategoryId(categoryId);
    }

    public void printTasksInfo() {
        ArrayList<String> listTasksInfo = taskRepository.getTasks();
        System.out.println("\nСписок всех task:");
        listTasksInfo.forEach(System.out::println);
    }

    public void printListCategory() {
        HashMap<Integer, String> listCategory = taskRepository.getListCategory();
        System.out.println("\nСписок всех категорий:");
        listCategory.forEach((k, v) -> {
            System.out.println("ID - " + k + ", название категории - " + v);
        });
    }

    public boolean addTaskToDB(String taskName, int userId, int statusId, int categoryId) {
        task = new Task(taskName, userId, statusId, categoryId);
        return taskRepository.addTask(task);
    }

    public boolean checkTaskNameByUser(String taskName, int userId) {
        return taskRepository.checkTaskNameByTaskNameAndUserId(taskName, userId);
    }

    public boolean delTaskByIdTask(int taskId) {
        return taskRepository.delTaskByTaskId(taskId);
    }

    public boolean updateTaskName(int taskId, String newTaskName) {
        return taskRepository.updateTaskName(taskId, newTaskName);
    }

    public boolean updateUserIdForTask(int taskId, int userId) {
        return taskRepository.updateUserIdByTaskIdAndUserId(taskId, userId);
    }

    public boolean updateCategoryIdForTask(int taskId, int categoryId) {
        return taskRepository.updateCategoryIdByTaskIdAndCategoryId(taskId, categoryId);
    }

    public boolean addCategory(String nameCategory) {
        return taskRepository.addCategory(nameCategory);
    }

    public String getNameCategoryForIdCategory(int categoryId) {
        return taskRepository.getNameCategoryForCategoryId(categoryId);
    }

    public boolean delCategory(int categoryId, int defaultCategoryId) {
        return taskRepository.delCategory(categoryId, defaultCategoryId);
    }

    public boolean updateCategoryName(int categoryId, String newNameCategory) {
        return taskRepository.updateCategoryName(categoryId, newNameCategory);
    }
}