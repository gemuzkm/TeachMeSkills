package com.project.ToDoList.service;

import com.project.ToDoList.entity.User;
import com.project.ToDoList.repository.RoleRepository;
import com.project.ToDoList.repository.UserRepository;

import java.util.ArrayList;

public class UserService {
    private UserRepository userRepository = new UserRepository();
    private RoleRepository repository = new RoleRepository();
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

    public boolean deleteUserFromDB(int idUser) {
        return  userRepository.dellUser(idUser);
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

    public int getUserIDFromBD(String login) {
        int userIDFormBD = userRepository.getUserID(login);
        return userIDFormBD;
    }

    public int getUserIDFromBD(int idUser) {
        int userIDFormBD = userRepository.getUserID(idUser);
        return userIDFormBD;
    }

    public boolean updateAuthorizedUserLogin(String newUserLogin) {
        user.setLogin(newUserLogin);
        if (userRepository.updateUserLogin(user) != -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean updateUserLogin(int idUser, String newLogin) {
        if (userRepository.updateUserLogin(idUser, newLogin) != -1) {
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

    public boolean updateUserPassword(int idUser, String newPassword) {
        if (userRepository.updateUserPassword(idUser, newPassword) != -1) {
            return true;
        } else {
            return false;
        }
    }

    public String getUserInfo(int idUser) {
        return userRepository.getUserInfo(idUser);
    }

    public void printAllUserInfo() {
        ArrayList<String> listAllUserInfo = userRepository.getAllUserInfo();
        System.out.println("\nСписок всех пользователей:");
        listAllUserInfo.forEach(System.out::println);
    }

    public boolean updateUserRole (int idUser, int idNewRole) {
        boolean result = userRepository.updateUserRole(idUser, idNewRole);
        return result;
    }
}
