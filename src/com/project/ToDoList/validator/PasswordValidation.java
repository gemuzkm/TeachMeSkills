package com.project.ToDoList.validator;

import com.project.ToDoList.repository.UserRepository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidation {
    private UserRepository userRepository = new UserRepository();

    public boolean isValidMinLength(String inputUserPassword) {
        Pattern patternPassword = Pattern.compile("^[a-zA-Z0-9]{2,}");
        Matcher matcherPassword = patternPassword.matcher(inputUserPassword);
        if (matcherPassword.find()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkPasswordInBD(String inputUserLogin, String inputUserPassword) {
        if (userRepository.checkUserPassword(inputUserLogin, inputUserPassword)) {
            return true;
        } else {
            return  false;
        }
    }
}
