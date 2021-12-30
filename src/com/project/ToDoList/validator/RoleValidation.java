package com.project.ToDoList.validator;

import com.project.ToDoList.repository.RoleRepository;

public class RoleValidation {
    public boolean isValid(int inputUserIdRole) {
        RoleRepository repository = new RoleRepository();
        int idFromBD = repository.getRoleID(inputUserIdRole);
        if (idFromBD == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isNumeric(String inputData) {
        try {
            Integer.parseInt(inputData);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
