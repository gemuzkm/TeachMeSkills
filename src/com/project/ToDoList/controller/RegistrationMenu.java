package com.project.ToDoList.controller;

import com.project.ToDoList.service.UserServiceImpl;
import com.project.ToDoList.validation.LoginValidation;

public class RegistrationMenu implements Menu {
    private ReaderDataFromConsole inputUserDataConsole = new ReaderDataFromConsole();
    private LoginValidation loginValidation = new LoginValidation();

    @Override
    public void show() {
        showTitle();
        showMenu();
    }

    private void showTitle() {
        System.out.println("\nРегистрация нового пользователя.\n");
    }

    private void showMenu() {
        UserServiceImpl userService = new UserServiceImpl();
        String login = "";
        String password = "";
        boolean loginIsFree = false;

        while (true) {
            System.out.println("Введите имя пользователя:");

            login = inputUserDataConsole.readString();
            if (!loginValidation.isValid(login)) {
                System.out.println("\nОшибка. Минимальная дли логина 2 символа, может состоять только из En букв и цифр!\n");
            } else { //добавить проверку на наличие юзера в БД
                loginIsFree = true;
                break;
            }
        }

        while (true && loginIsFree) {
            System.out.println("Введите пароль:");

            password = inputUserDataConsole.readString();
            if (!loginValidation.isValid(password)) {
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
