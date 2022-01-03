package com.project.ToDoList.service;

import com.project.ToDoList.entity.User;
import com.project.ToDoList.repository.TaskRepository;

import java.util.ArrayList;

public class TaskService {
    private TaskRepository taskRepository = new TaskRepository();

    public void listTaskUser(User user) {

    }

    public void listTaskUser(int userID) {
        ArrayList<String> listUserTask = taskRepository.getListTask(userID);
        System.out.println("\nСписок заданий пользователя:\n");
        listUserTask.forEach(System.out::println);
    }
}
