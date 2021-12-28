package com.project.ToDoList.controller;

import com.project.ToDoList.service.UserServiceImpl;
import com.project.ToDoList.validator.LoginValidation;

public class LoginMenu implements Menu {
    private String inputUserItemMenu;
    private ReaderDataFromConsole inputUserDataConsole = new ReaderDataFromConsole();
    private LoginValidation loginValidation = new LoginValidation();
    private UserServiceImpl userService = new UserServiceImpl();

    @Override
    public void show() {
        showTitle();
        showMenu();
    }

    private void showTitle() {
        System.out.println("\nДля работы с приложением нужен пользователь");
        System.out.println("Если нет пользователя, то пройдите регистрацию");
    }

    private void showMenu() {
        String login = "";
        String password = "";
        boolean loginIsTrue = false;

        while (true) {
            System.out.println("\nВведите логин пользователя:");

            login = inputUserDataConsole.readString();
            if (!loginValidation.isValid(login)) {
                System.out.println("\nОшибка. Логин не существует");
            } else if (userService.getUserID(login) == -1) {
                System.out.println("\nПользователь с таким логином не существует");
            } else {
                loginIsTrue = true;
                break;
            }
        }

        while (true && loginIsTrue) {
            System.out.println("\nВведите пароль:");

            password = inputUserDataConsole.readString();
            if (!loginValidation.isValid(password)) {
                System.out.println("\nОшибка. Введенный данные не верны\n");
            } else {
                break;
            }
        }
    }
}
