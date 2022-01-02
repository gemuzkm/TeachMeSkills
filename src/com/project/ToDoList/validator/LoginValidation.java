package com.project.ToDoList.validator;

import com.project.ToDoList.service.UserService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginValidation {
    private UserService userService = new UserService();

    public boolean isValidMinLength(String inputUserLogin) {
        Pattern patternLogin = Pattern.compile("^[a-zA-Z0-9]{2,}");
        Matcher matcherLogin = patternLogin.matcher(inputUserLogin);
        if (matcherLogin.find()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean findLoginFromBD(String inputUserLogin) {
        if (userService.getUserIDFromBD(inputUserLogin) != -1) {
            return true;
        } else {
            return false;
        }
    }
}

