package com.project.ToDoList.service;

import com.project.ToDoList.entity.User;
import com.project.ToDoList.repository.UserRepository;

public class UserServiceImpl {
    private UserRepository userRepository = new UserRepository();
    private User user;

    public boolean addUser(String login, String password) {
        user = new User(login, password);
        int userResulAddFromBD = userRepository.addUser(user);
        if (userResulAddFromBD != -1) {
            user.setId(userResulAddFromBD);
            return true;
        }
        return false;
    }

    public int getUserID(User user) {
        return user.getId();
    }

    public int getUserID(String login) {
        int userIDFormBD = userRepository.getUserID(login);
        return userIDFormBD;
    }
}
