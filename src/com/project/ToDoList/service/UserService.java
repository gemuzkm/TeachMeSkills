package com.project.ToDoList.service;

import com.project.ToDoList.entity.User;
import com.project.ToDoList.repository.RoleRepository;
import com.project.ToDoList.repository.UserRepository;

import java.util.HashMap;

public class UserService {
    private UserRepository userRepository = new UserRepository();
    private RoleRepository repository = new RoleRepository();
    private User user;

    public boolean addUserFromBD(String login, String password, int role) {
        user = new User(login, password, role);
        int userResulAddFromBD = userRepository.addUser(user);
        if (userResulAddFromBD != -1) {
            user.setId(userResulAddFromBD);
            return true;
        }
        return false;
    }

    public void createAuthorizedUser(String login, String password, int role) {
        user = new User(login, password, role);
    }

    public void createAuthorizedUser(int idUser, String login, String password, int role) {
        user = new User(login, password, role);
        user.setId(idUser);
    }

    public String getAuthorizedUserLogin() {
        return user.getLogin();
    }

    public int getAuthorizedUserID() {
        return user.getId();
    }

    public int getAuthorizedUserRole() {
        return user.getRole();
    }

    public int getUserIDFromBD(User user) {
        return user.getId();
    }

    public int getUserIDFromBD(String login) {
        int userIDFormBD = userRepository.getUserID(login);
        return userIDFormBD;
    }

    public HashMap<Integer, String> listUserRole() {
        return repository.getListRole();
    }
}
