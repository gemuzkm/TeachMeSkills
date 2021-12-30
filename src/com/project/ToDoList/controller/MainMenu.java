package com.project.ToDoList.controller;

import com.project.ToDoList.service.RoleService;
import com.project.ToDoList.service.UserService;
import com.project.ToDoList.validator.LoginValidation;
import com.project.ToDoList.validator.PasswordValidation;
import com.project.ToDoList.validator.RoleValidation;

import java.util.HashMap;

public class MainMenu implements Menu {
    private ReaderDataFromConsole inputUserDataConsole = new ReaderDataFromConsole();
    private LoginValidation loginValidation = new LoginValidation();
    private PasswordValidation passwordValidation = new PasswordValidation();
    private RoleValidation  roleValidation = new RoleValidation();
    private UserService userService = new UserService();
    private RoleService roleService = new RoleService();
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
        int idRole = -1;
        String idRoleString = "";
        boolean loginIsFree = false;
        boolean passwordIsValid = false;

        while (true) {
            System.out.println("Введите логин пользователя:");

            login = inputUserDataConsole.readString();
            if (!loginValidation.isValid(login)) {
                System.out.println("\nОшибка. Минимальная дли логина 2 символа, может состоять только из En букв и цифр!\n");
            } else if (userService.getUserIDFromBD(login) != -1) {
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
                passwordIsValid = true;
                break;
            }
        }

        while (true && loginIsFree && passwordIsValid) {
            System.out.println("\nВыберите ID роли пользователя:");
            listRoleUser();
            System.out.println("\nВведите необходимый ID роли");

            idRoleString =  inputUserDataConsole.readString();
            if (roleValidation.isNumeric(idRoleString)) {
                idRole = Integer.parseInt(idRoleString);
            } else {
                System.out.println("\nВведенное ID не существует");
                continue;
            }

            if (!roleValidation.isValid(idRole)) {
                System.out.println("\nВведенное ID не существует");
            } else {
                break;
            }
        }

        if (userService.addUserFromBD(login, password, idRole)) {
            System.out.println("\nПользователь успешно создан");
        } else {
            System.out.println("\nОшибка во время добавления пользователя");
        }
    }

    private void showLoginMenu() {
        String login = "";
        String password = "";
        int idUser = -1;
        int idRole = -1;

        boolean loginIsValid = false; //валидация пройдена, логин есть в базе
        boolean passwordIsValid = false; //валидация пройдена, пароль не проверен в базе

        while (true) {
            System.out.println("\nВведите логин пользователя:");

            login = inputUserDataConsole.readString();
            if (!loginValidation.isValid(login)) {
                System.out.println("\nОшибка. Логин не существует");
            } else if (userService.getUserIDFromBD(login) == -1) {
                System.out.println("\nПользователь с таким логином не существует");
            } else {
                loginIsValid = true;
                break;
            }
        }

        while (true && loginIsValid) { //сделать проверку пароля в БД
            System.out.println("\nВведите пароль:");

            password = inputUserDataConsole.readString();
            if (!passwordValidation.isValid(password)) {
                System.out.println("\nОшибка. Введенный данные не верны\n");
            } else {
                passwordIsValid = true;
                break;
            }
        }

        if (loginIsValid && passwordIsValid) {
            idUser = userService.getUserIDFromBD(login);
            idRole = roleService.getRoleID(login);

            userService.createAuthorizedUser(idUser, login, password, idRole);

            if (roleService.getNameRoleFromID(idRole).toLowerCase().equals("user")) {
                showUserMenuTitle();
                showUserMenu();
            } else if (roleService.getNameRoleFromID(idRole).toLowerCase().equals("manager")) {
                showManagerMenuTitle();
                showManagerMenu();
            }
        }
    }

    private void showManagerMenu() {

    }

    private void showUserMenu() {

    }

    private void showMainTitle() {
        System.out.println("Добро пожаловать в ToDoList. \n\nВыберите нужный пункт меню:");
        System.out.println("Кто бы ты ни был, не нужно клонировать проект! :-) Это все отслеживается");
        System.out.println("C новым 2022 годом");
    }

    private void showRegistrationMenuTitle() {
        System.out.println("\nРегистрация нового пользователя.\n");
    }

    private void showLoginMenuTitle() {
        System.out.println("\nДля работы с приложением нужен пользователь");
        System.out.println("Если нет пользователя, то пройдите регистрацию");
    }

    private void showManagerMenuTitle() {
        System.out.println("\nМеню менеджера\n");
    }

    private void showUserMenuTitle() {
        System.out.println("\nМеню юзера\n");
    }

     private void listRoleUser() {
         HashMap<Integer, String> listUserRole = userService.listUserRole();
         listUserRole.forEach((k, v) -> {
             System.out.println("ID - " + k + ", Название роли - " + v);
         });
     }
}
