package com.project.ToDoList.controller;

import com.project.ToDoList.service.UserServiceImpl;
import com.project.ToDoList.validator.LoginValidation;
import com.project.ToDoList.validator.PasswordValidation;

public class RegistrationMenu implements Menu {
    private ReaderDataFromConsole inputUserDataConsole = new ReaderDataFromConsole();
    private LoginValidation loginValidation = new LoginValidation();
    private PasswordValidation passwordValidation = new PasswordValidation();
    private UserServiceImpl userService = new UserServiceImpl();

    @Override
    public void show() {
        showTitle();
        showMenu();
    }

    private void showTitle() {
        System.out.println("\nРегистрация нового пользователя.\n");
    }

    private void showMenu() {
        String login = "";
        String password = "";
        boolean loginIsFree = false;

        while (true) {
            System.out.println("Введите логин пользователя:");

            login = inputUserDataConsole.readString();
            if (!loginValidation.isValid(login)) {
                System.out.println("\nОшибка. Минимальная дли логина 2 символа, может состоять только из En букв и цифр!\n");
            } else if (userService.getUserID(login) != -1) {
                System.out.println("\nВведенный логин пользователя уже занят!\n");
            } else {
                loginIsFree = true;
                break;
            }
        }

        while (true && loginIsFree) {
            System.out.println("\nВведите пароль:");

            password = inputUserDataConsole.readString();
            if (!passwordValidation.isValid(password)) {
                System.out.println("\nОшибка. Минимальная дли пароля 2 символа, может состоять только из En букв и цифр!\n");
            } else {
                break;
            }
        }

        if (userService.addUser(login, password)) {
            System.out.println("\nПользователь успешно создан");
        } else {
            System.out.println("\nОшибка во время добавления пользователя");
        }
    }
}
