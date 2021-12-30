package com.project.ToDoList.controller;

import com.project.ToDoList.service.UserServiceImpl;
import com.project.ToDoList.validator.LoginValidation;
import com.project.ToDoList.validator.PasswordValidation;

public class MainMenu implements Menu {
    private ReaderDataFromConsole inputUserDataConsole = new ReaderDataFromConsole();
    private LoginValidation loginValidation = new LoginValidation();
    private PasswordValidation passwordValidation = new PasswordValidation();
    private UserServiceImpl userService = new UserServiceImpl();
    private String inputUserItemMenu = "";

    @Override
    public void show() {
        showMainTitle();
        showMainMenu();
    }

    private void showMainMenu() {
        while (true) {
            System.out.println("\n1 - для регистрации");
            System.out.println("2 - для входа при помощи логина/пароля");
            System.out.println("3 - для выхода из приложения\n");
            System.out.println("Введите цифру нужного меню:");

            inputUserItemMenu = inputUserDataConsole.readString();

            if (inputUserItemMenu.equals("1")) {
                showRegistrationMenuTitle();
                showRegistrationMenu();
            } else if (inputUserItemMenu.equals("2")) {
                showLoginMenuTitle();
                showLoginMenu();
            } else if (inputUserItemMenu.equals("3")) {
                inputUserDataConsole.readerClose();
                System.exit(0);
            } else {
                System.out.println("\nТакого меню не существует. Выбери только из указанных вариантов");
            }
        }
    }

    private void showRegistrationMenu() {
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

    private void showLoginMenu() {
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
            if (!passwordValidation.isValid(password)) {
                System.out.println("\nОшибка. Введенный данные не верны\n");
            } else {
                break;
            }
        }
    }

    private void showMainTitle() {
        System.out.println("Добро пожаловать в ToDoList. \n\nВыберите нужный пункт меню:");
    }

    private void showRegistrationMenuTitle() {
        System.out.println("\nРегистрация нового пользователя.\n");
    }

    private void showLoginMenuTitle() {
        System.out.println("\nДля работы с приложением нужен пользователь");
        System.out.println("Если нет пользователя, то пройдите регистрацию");
    }



}
