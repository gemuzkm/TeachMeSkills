package com.project.ToDoList.service;

import com.project.ToDoList.entity.Task;
import com.project.ToDoList.entity.User;
import com.project.ToDoList.repository.TaskRepository;

import java.util.ArrayList;
import java.util.HashMap;

public class TaskService {
    private TaskRepository taskRepository = new TaskRepository();
    private Task task;

    public void listTaskUser(int userID) {
        ArrayList<String> listUserTask = taskRepository.getListTask(userID);
        System.out.println("\nСписок заданий пользователя:\n");
        listUserTask.forEach(System.out::println);
    }

    public int getTaskStatusIdFromBD(int idStatus) {
        return taskRepository.getStatusId(idStatus);
    }

    public String getTaskInfoFromID(int idUser, int idTask) {
        String taskInfo = taskRepository.getTaskInfoFromID(idUser, idTask);
        if (taskInfo.length() == 0) {
            return  "Проверьте корректность вводимых данных";
        }
        return taskInfo;
    }

    public int getTaskIDFromBD(int idTask) {
        int userIDFormBD = taskRepository.getTaskID(idTask);
        return userIDFormBD;
    }

    public void listTaskStatus() {
        HashMap<Integer, String> listUserRole = taskRepository.getListStatus();;
        listUserRole.forEach((k, v) -> {
            System.out.println("ID - " + k + ", Название статуса - " + v);
        });
    }

    public int updateTaskStatus(int idTask, int idStatus) {
        int resultUpdate =  taskRepository.updateTaskStatus(idTask, idStatus);
        return resultUpdate;
    }

    public String getTaskInfo(int idTask) {
        return taskRepository.getTaskInfo(idTask);
    }

    public int getIdForStatusName(String statusName) {
        int idStatus = taskRepository.getIdForStatusName(statusName);
        return idStatus;
    }

    public int getIdForCategoryName(String categoryName) {
        int idCategory = taskRepository.getIdForCategoryName(categoryName);
        return idCategory;
    }

    public int getIdCategory(int idCategory) {
         return taskRepository.getIdCategory(idCategory);
    }

    public void printAllTaskInfo() {
        ArrayList<String> listAllTaskInfo =  taskRepository.getAllListTask();
        System.out.println("\nСписок всех task:");
        listAllTaskInfo.forEach(System.out::println);
    }

    public void printAllListCategory() {
        HashMap<Integer, String> listUserCategory = taskRepository.getListCategory();
        System.out.println("\nСписок всех категорий:");
        listUserCategory.forEach((k,v) -> {
            System.out.println("ID - " + k + ", название категории - " + v);
        });
    }

    public boolean addTaskToDB(String taskName, int idUser, int idStatus, int idCategory) {
        task = new Task(taskName, idUser, idStatus, idCategory);
        return taskRepository.addTaskToDB(task);
    }

    public boolean checkTaskNameByUser(String taskName, int idUser) {
        return taskRepository.checkTaskNameByUser(taskName, idUser);
    }

    public boolean delTaskFromBdByIdTask(int idTask) {
        return taskRepository.delTaskFromBdByIdTask(idTask);
    }

    public boolean updateTaskName(int idTask, String newTaskName) {
        return taskRepository.updateTaskName(idTask, newTaskName);
    }

    public boolean updateUserIdForTask(int idTask, int idUser) {
        return taskRepository.updateUserIdForTask(idTask, idUser);
    }

    public boolean updateCategoryIdForTask(int idTask, int idCategory) {
        return taskRepository.updateCategoryIdForTask(idTask, idCategory);
    }

    public boolean addCategoryToBD(String nameCategory) {
        return taskRepository.addCategoryToBD(nameCategory);
    }

    public String getNameCategoryForIdCategory(int idCategory) {
        return taskRepository.getNameCategoryForIdCategory(idCategory);
    }

    public boolean delCategoryFromBD(int idCategory, int idDefaultCategory) {
        return taskRepository.delCategoryFromBD(idCategory, idDefaultCategory);
    }

    public boolean updateCategoryName(int idCategory, String newNameCategory) {
        return taskRepository.updateCategoryName(idCategory, newNameCategory);
    }

}
