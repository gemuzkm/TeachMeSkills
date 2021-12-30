package com.project.ToDoList.service;

import com.project.ToDoList.repository.RoleRepository;

public class RoleService {
    private RoleRepository repository = new RoleRepository();

    public int getRoleID(String login) {
        return repository.getRoleID(login);
    }

    public String getNameRoleFromID(int idRole) {
        return repository.getRoleNameFromIdRole(idRole);
    }
}
