package com.project.ToDoList.service;

import com.project.ToDoList.repository.RoleRepository;

import java.util.HashMap;

public class RoleService {
    private RoleRepository repository = new RoleRepository();

    public int getRoleId(String login) {
        return repository.getRoleID(login);
    }

    public String getNameRole(int roleId) {
        return repository.getRoleNameFromIdRole(roleId);
    }

    public void listUserRole() {
        HashMap<Integer, String> listUserRole = repository.getListRole();;
        listUserRole.forEach((k, v) -> {
            System.out.println("ID - " + k + ", Название роли - " + v);
        });
    }
}
