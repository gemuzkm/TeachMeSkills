package com.project.ToDoList.validator;

public class TaskValidation {
    public boolean isNumeric(String inputData) {
        try {
            Integer.parseInt(inputData);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
