package com.project.ToDoList.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidation {
    public boolean isValid(String userInputPassword) {
        Pattern patternPassword = Pattern.compile("^[a-zA-Z0-9]{2,}");
        Matcher matcherPasswrd = patternPassword.matcher(userInputPassword);
        if (matcherPasswrd.find()) {
            return true;
        } else {
            return false;
        }
    }
}
