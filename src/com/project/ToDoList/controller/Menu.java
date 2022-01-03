package com.project.ToDoList.controller;

import com.project.ToDoList.service.RoleService;
import com.project.ToDoList.service.TaskService;
import com.project.ToDoList.service.UserService;
import com.project.ToDoList.validator.LoginValidation;
import com.project.ToDoList.validator.PasswordValidation;
import com.project.ToDoList.validator.RoleValidation;

public class Menu {
    private ReaderDataFromConsole inputUserDataConsole = new ReaderDataFromConsole();
    private LoginValidation loginValidation = new LoginValidation();
    private PasswordValidation passwordValidation = new PasswordValidation();
    private RoleValidation  roleValidation = new RoleValidation();
    private UserService userService = new UserService();
    private RoleService roleService = new RoleService();
    private TaskService taskService = new TaskService();
    private String inputUserItemMenu = "";

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
        String inputUserLogin = "";
        String inputUserPassword = "";
        int idRole = -1;
        String idRoleString = "";
        boolean loginIsFree = false;
        boolean passwordIsValid = false;

        while (true) {
            System.out.println("Введите логин пользователя:");

            inputUserLogin = inputUserDataConsole.readString();
            if (!loginValidation.isValidMinLength(inputUserLogin)) {
                System.out.println("\nОшибка. Минимальная дли логина 2 символа, может состоять только из En букв и цифр!\n");
            } else if (loginValidation.findLoginFromBD(inputUserLogin)) {
                System.out.println("\nВведенный логин пользователя уже занят!\n");
            } else {
                loginIsFree = true;
                break;
            }
        }

        while (true && loginIsFree) {
            System.out.println("\nВведите пароль:");

            inputUserPassword = inputUserDataConsole.readString();
            if (!passwordValidation.isValidMinLength(inputUserPassword)) {
                System.out.println("\nОшибка. Минимальная дли пароля 2 символа, может состоять только из En букв и цифр!\n");
            } else {
                passwordIsValid = true;
                break;
            }
        }

        while (true && loginIsFree && passwordIsValid) {
            System.out.println("\nВыберите ID роли пользователя:");
            roleService.listRoleUser();
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

        if (userService.addUserFromBD(inputUserLogin, inputUserPassword, idRole)) {
            System.out.println("\nПользователь успешно создан");
        } else {
            System.out.println("\nОшибка во время добавления пользователя");
        }
    }

    private void showLoginMenu() {
        String inputUserLogin = "";
        String inputUserPassword = "";
        int idUser = -1;
        int idRole = -1;

        boolean loginIsValid = false; //валидация пройдена, логин есть в базе
        boolean passwordIsValid = false; //валидация пройдена, пароль не проверен в базе

        while (true) {
            System.out.println("\nВведите логин пользователя:");

            inputUserLogin = inputUserDataConsole.readString();
            if (!loginValidation.isValidMinLength(inputUserLogin)) {
                System.out.println("\nЛогин не существует или введен неверно!");
            } else if (!loginValidation.findLoginFromBD(inputUserLogin)) {
                System.out.println("\nПользователь с введенным логином не существует!");
            } else {
                loginIsValid = true;
                break;
            }
        }

        while (true && loginIsValid) { //сделать проверку пароля в БД
            System.out.println("\nВведите пароль:");
            inputUserPassword = inputUserDataConsole.readString();

            if (!passwordValidation.isValidMinLength(inputUserPassword)) {
                System.out.println("\nПароль введен не верно");
            } else if (!passwordValidation.checkPasswordFromBD(inputUserLogin, inputUserPassword)) {
                System.out.println("\nПароль введен не верно");
            } else {
                passwordIsValid = true;
                break;
            }
        }

        if (loginIsValid && passwordIsValid) {
            idUser = userService.getUserIDFromBD(inputUserLogin);
            idRole = roleService.getRoleID(inputUserLogin);

            userService.createAuthorizedUser(idUser, inputUserLogin, inputUserPassword, idRole);

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
        while (true) {
            System.out.println("\n1 - вывод всех task");
            System.out.println("2 - работа с task");
            System.out.println("3 - изменить данные пользователя");
            System.out.println("4 - завершить сессию пользователя\n");
            System.out.println("Введите цифру нужного меню:");

            inputUserItemMenu = inputUserDataConsole.readString();

            if (inputUserItemMenu.equals("1")) {
                taskService.listTaskUser(userService.getAuthorizedUserID());
            } else if (inputUserItemMenu.equals("2")) {
                showTaskUserMenuTitle();
                showTaskUserMenu();
            } else if (inputUserItemMenu.equals("3")) {
                showEditUserMenuTitle();
                showEditUserMenu();
            } else if (inputUserItemMenu.equals("4")) {
                show();
            } else {
                System.out.println("\nТакого меню не существует. Выбери только из указанных вариантов");
            }
        }
    }

    private void showTaskUserMenu() {
        System.out.println("1 - ");
    }

    private void showEditUserMenu() {
        System.out.println();

    }

    private void showEditUserMenuTitle() {
        System.out.println("\nМеню изменения данных пользователя:\n");
    }

    private void showTaskUserMenuTitle() {
        System.out.println("\nМеню работы с заданиями:\n");
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

    private void showManagerMenuTitle() {
        System.out.println("\nМеню менеджера\n");
    }

    private void showUserMenuTitle() {
        System.out.println("\nГлавное меню пользователя.");
        System.out.println("Привет, " + userService.getAuthorizedUserLogin() + ". Для работы выбери нужное меню:");
    }
}
