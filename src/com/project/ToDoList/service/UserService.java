package com.project.ToDoList.service;

import com.project.ToDoList.entity.User;
import com.project.ToDoList.repository.UserRepository;

import java.util.ArrayList;

public class UserService {
    private UserRepository userRepository = new UserRepository();
    private User user;

    public boolean addUserToBD(String login, String password, int role) {
        user = new User(login, password, role);
        int userResulAddFromBD = userRepository.addUser(user);
        if (userResulAddFromBD != -1) {
            user.setId(userResulAddFromBD);
            return true;
        }
        return false;
    }

    public boolean deleteUser(int userId) {
        return userRepository.delUser(userId);
    }

    public void createAuthorizedUser(int userId, String login, String password, int roleId) {
        user = new User(login, password, roleId);
        user.setId(userId);
    }

    public String getAuthorizedUserLogin() {
        return user.getLogin();
    }

    public int getAuthorizedUserId() {
        return user.getId();
    }

    public int getAuthorizedUserRole() {
        return user.getRole();
    }

    public int getUserId(String login) {
        return userRepository.getUserId(login);
    }

    public int getUserId(int userId) {
        return userRepository.getUserId(userId);
    }

    public boolean updateAuthorizedUserLogin(String newUserLogin) {
        user.setLogin(newUserLogin);
        if (userRepository.updateUserLogin(user) != -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean updateUserLogin(int userId, String newLogin) {
        if (userRepository.updateUserLogin(userId, newLogin) != -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean updateAuthorizedUserPassword(String newPassword) {
        user.setPassword(newPassword);
        if (userRepository.updateUserLogin(user) != -1 && userRepository.checkUserPassword(user.getLogin(), user.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean updateUserPassword(int userId, String newPassword) {
        if (userRepository.updateUserPassword(userId, newPassword) != -1) {
            return true;
        } else {
            return false;
        }
    }

    public String getUserInfo(int userId) {
        return userRepository.getUserInfo(userId);
    }

    public void printUsersInfo() {
        ArrayList<String> listUsersInfo = userRepository.getUsersInfo();
        System.out.println("\nСписок всех пользователей:");
        listUsersInfo.forEach(System.out::println);
    }

    public boolean updateUserRole(int userId, int newRoleId) {
        boolean result = userRepository.updateUserRole(userId, newRoleId);
        return result;
    }
}