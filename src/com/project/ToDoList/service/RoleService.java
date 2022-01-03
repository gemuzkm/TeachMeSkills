package com.project.ToDoList.service;

import com.project.ToDoList.repository.RoleRepository;

import java.util.HashMap;

public class RoleService {
    private RoleRepository repository = new RoleRepository();

    public int getRoleID(String login) {
        return repository.getRoleID(login);
    }

    public String getNameRoleFromID(int idRole) {
        return repository.getRoleNameFromIdRole(idRole);
    }

    public void listRoleUser() {
        HashMap<Integer, String> listUserRole = repository.getListRole();;
        listUserRole.forEach((k, v) -> {
            System.out.println("ID - " + k + ", Название роли - " + v);
        });
    }
}
