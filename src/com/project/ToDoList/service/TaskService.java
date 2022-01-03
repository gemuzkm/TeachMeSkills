package com.project.ToDoList.service;

import com.project.ToDoList.entity.User;
import com.project.ToDoList.repository.TaskRepository;

import java.util.ArrayList;
import java.util.HashMap;

public class TaskService {
    private TaskRepository taskRepository = new TaskRepository();

    public void listTaskUser(User user) {

    }

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
}
