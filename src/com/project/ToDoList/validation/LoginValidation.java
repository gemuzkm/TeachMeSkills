package com.project.ToDoList.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginValidation {
    public boolean isValid(String userInputLogin) {
        if (userInputLogin.length() <= 2) {
            return false;
        } else {
            Pattern patternLogin = Pattern.compile("[a-zA-Z0-9]]");
            Matcher matcherLogin = patternLogin.matcher(userInputLogin);
            if (matcherLogin.find()) {
                return true;
            } else {
                return false;
            }
        }
    }
}
