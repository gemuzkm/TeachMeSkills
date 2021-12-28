package com.project.ToDoList.service;

import com.project.ToDoList.entity.User;
import com.project.ToDoList.repository.DBRepository;

public class UserServiceImpl {
    private DBRepository dbRepository = new DBRepository();
    private User user;

    public boolean addUser(String login, String password) {
        user = new User(login, password);
        int userIDFormBD = dbRepository.addUser(user);
        user.setId(userIDFormBD);

        return true;
    }

    public int getUserID(User user) {
        return user.getId();
    }
}
