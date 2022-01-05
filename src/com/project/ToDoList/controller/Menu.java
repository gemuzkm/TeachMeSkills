package com.project.ToDoList.controller;

import com.project.ToDoList.service.RoleService;
import com.project.ToDoList.service.TaskService;
import com.project.ToDoList.service.UserService;
import com.project.ToDoList.validator.LoginValidation;
import com.project.ToDoList.validator.PasswordValidation;
import com.project.ToDoList.validator.RoleValidation;
import com.project.ToDoList.validator.TaskValidation;

public class Menu {

    private ReaderDataFromConsole inputUserDataConsole = new ReaderDataFromConsole();
    private LoginValidation loginValidation = new LoginValidation();
    private PasswordValidation passwordValidation = new PasswordValidation();
    private RoleValidation roleValidation = new RoleValidation();
    private TaskValidation taskValidation = new TaskValidation();
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
            } else if (loginValidation.findLoginToBD(inputUserLogin)) {
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

            idRoleString = inputUserDataConsole.readString();
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

        if (userService.addUserToBD(inputUserLogin, inputUserPassword, idRole)) {
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
            } else if (!loginValidation.findLoginToBD(inputUserLogin)) {
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
            } else if (!passwordValidation.checkPasswordInBD(inputUserLogin, inputUserPassword)) {
                System.out.println("\nПароль введен не верно");
            } else {
                passwordIsValid = true;
                break;
            }
        }

        if (loginIsValid && passwordIsValid) {
            idUser = userService.getUserIDFromBD(inputUserLogin);
            idRole = roleService.getRoleIdFromBD(inputUserLogin);

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
        while (true) {
            System.out.println("\n1 - вывод данных текущего пользователя");
            System.out.println("2 - вывод всех данных (пользователей/task)");
            System.out.println("3 - вывод данные по ID (пользователя/task)");
            System.out.println("4 - работа с пользователями (добавление/удаление/изменение(логин, пароль, role))");
            System.out.println("5 - работа с task (добавление/удаление/изменение статуса)");
            System.out.println("6 - работа с category (добавление/удаление/изменение)");
            System.out.println("7 - завершить сессию пользователя\n");
            System.out.println("Введите цифру нужного меню:");

            inputUserItemMenu = inputUserDataConsole.readString();

            if (inputUserItemMenu.equals("1")) {
                printUserInfo();
            } else if (inputUserItemMenu.equals("2")) {
                showPrintAllUserAndAllTaskInfoMenu();
            } else if (inputUserItemMenu.equals("3")) {
                showPrintUserAndTaskInfoByIdMenu();
            } else if (inputUserItemMenu.equals("4")) {
                showUserAddDelEditMenu();
            } else if (inputUserItemMenu.equals("5")) {
                showTaskAddDelEditMenu();
            } else if (inputUserItemMenu.equals("6")) {

            } else if (inputUserItemMenu.equals("7")) {
                show();
            } else {
                System.out.println("\nТакого меню не существует. Выбери только из указанных вариантов");
            }
        }
    }

    private void showUserMenu() {
        while (true) {
            System.out.println("\n1 - вывод данных текущего пользователя");
            System.out.println("2 - вывод всех task пользователя");
            System.out.println("3 - работа с task");
            System.out.println("4 - изменить данные пользователя");
            System.out.println("5 - завершить сессию пользователя\n");
            System.out.println("Введите цифру нужного меню:");

            inputUserItemMenu = inputUserDataConsole.readString();

            if (inputUserItemMenu.equals("1")) {
                printUserInfo();
            } else if (inputUserItemMenu.equals("2")) {
                taskService.listTaskUser(userService.getAuthorizedUserID());
            } else if (inputUserItemMenu.equals("3")) {
                showTaskUserMenuTitle();
                showTaskUserMenu();
            } else if (inputUserItemMenu.equals("4")) {
                showEditUserMenuTitle();
                showEditUserMenu();
            } else if (inputUserItemMenu.equals("5")) {
                show();
            } else {
                System.out.println("\nТакого меню не существует. Выбери только из указанных вариантов");
            }
        }
    }

    private void showTaskUserMenu() {
        while (true) {
            System.out.println("\n1 - вывод всех task пользователя");
            System.out.println("2 - вывод информации о task по ID task");
            System.out.println("3 - изменение статуса task");
            System.out.println("4 - выход в главное меню пользователя\n");
            System.out.println("Введите цифру нужного меню:");

            inputUserItemMenu = inputUserDataConsole.readString();

            if (inputUserItemMenu.equals("1")) {
                taskService.listTaskUser(userService.getAuthorizedUserID());
            } else if (inputUserItemMenu.equals("2")) {
                printTaskInfoFromIdTaskByUser();
            } else if (inputUserItemMenu.equals("3")) {
                editTaskStatusByIdToUser();
            } else if (inputUserItemMenu.equals("4")) {
                showUserMenuTitle();
                showUserMenu();
            }
        }
    }

    private void showEditUserMenu() {
        System.out.println("\nКакие данные нужно изменить:");

        while (true) {
            System.out.println("\n1 - логин");
            System.out.println("2 - пароль");
            System.out.println("3 - выход в главное меню пользователя");

            System.out.println("\nВведите цифру нужного меню:");
            inputUserItemMenu = inputUserDataConsole.readString();

            if (inputUserItemMenu.equals("1")) {
                changeUserLogin();
            } else if (inputUserItemMenu.equals("2")) {
                changeUserPassword();
            } else if (inputUserItemMenu.equals("3")) {
                showUserMenuTitle();
                showUserMenu();
            } else {
                System.out.println("\nВведите номер меню из списка");
            }
        }
    }

    private void showEditUserForManagerMenu() {
        System.out.println("\nКакие данные нужно изменить:");

        while (true) {
            System.out.println("\n1 - логин");
            System.out.println("2 - пароль");
            System.out.println("3 - Role");
            System.out.println("4 - выход в главное меню пользователя");

            System.out.println("\nВведите цифру нужного меню:");
            inputUserItemMenu = inputUserDataConsole.readString();

            if (inputUserItemMenu.equals("1")) {
                changeUserLoginForManager();
            } else if (inputUserItemMenu.equals("2")) {
                changeUserPasswordForManager();
            } else if (inputUserItemMenu.equals("3")) {
                changeUserRoleForManager();
            } else if (inputUserItemMenu.equals("4")) {
                showManagerMenu();
            } else {
                System.out.println("\nВведите номер меню из списка");
            }
        }
    }

    private void showPrintAllUserAndAllTaskInfoMenu() {
        while (true) {
            System.out.println("\n1 - вывод информации о всех пользователях");
            System.out.println("2 - вывод информации о всех task");
            System.out.println("3 - выход в главное меню пользователя\n");
            System.out.println("Введите цифру нужного меню:");

            inputUserItemMenu = inputUserDataConsole.readString();

            if (inputUserItemMenu.equals("1")) {
                userService.printAllUserInfo();
            } else if (inputUserItemMenu.equals("2")) {
                taskService.printAllTaskInfo();
            } else if (inputUserItemMenu.equals("3")) {
                showManagerMenu();
            } else {
                System.out.println("\nТакого меню не существует. Выбери только из указанных вариантов");
            }
        }
    }

    private void showPrintUserAndTaskInfoByIdMenu() {
        while (true) {
            System.out.println("\n1 - вывод информации о пользователе по ID");
            System.out.println("2 - вывод информации о task по ID");
            System.out.println("3 - выход в главное меню пользователя\n");
            System.out.println("Введите цифру нужного меню:");

            inputUserItemMenu = inputUserDataConsole.readString();

            if (inputUserItemMenu.equals("1")) {
                printUserInfoByID();
            } else if (inputUserItemMenu.equals("2")) {
                printTaskInfoByID();
            } else if (inputUserItemMenu.equals("3")) {
                showManagerMenu();
            } else {
                System.out.println("\nТакого меню не существует. Выбери только из указанных вариантов");
            }
        }
    }

    private void showUserAddDelEditMenu() {
        while (true) {
            System.out.println("\n1 - добавление пользователя");
            System.out.println("2 - удаление пользователя");
            System.out.println("3 - изменение пользователя");
            System.out.println("4 - выход в главное меню пользователя\n");
            System.out.println("Введите цифру нужного меню:");

            inputUserItemMenu = inputUserDataConsole.readString();

            if (inputUserItemMenu.equals("1")) {
                showRegistrationMenuTitle();
                showRegistrationMenu();
            } else if (inputUserItemMenu.equals("2")) {
                deleteUserByID();
            } else if (inputUserItemMenu.equals("3")) {
                showEditUserForManagerMenu();
            } else if (inputUserItemMenu.equals("4")) {
                showManagerMenu();
            } else {
                System.out.println("\nТакого меню не существует. Выбери только из указанных вариантов");
            }
        }
    }

    public void showTaskAddDelEditMenu() {
        while (true) {
            System.out.println("\n1 - добавление task");
            System.out.println("2 - удаление task");
            System.out.println("3 - изменение task");
            System.out.println("4 - выход в главное меню пользователя\n");
            System.out.println("Введите цифру нужного меню:");

            inputUserItemMenu = inputUserDataConsole.readString();

            if (inputUserItemMenu.equals("1")) {
                addTaskForManagerMenu();
            } else if (inputUserItemMenu.equals("2")) {
                delTaskForManagerMenu();
            } else if (inputUserItemMenu.equals("3")) {
                showEditTaskForManagerMenu();
            } else if (inputUserItemMenu.equals("4")) {
                showManagerMenu();
            } else {
                System.out.println("\nТакого меню не существует. Выбери только из указанных вариантов");
            }
        }
    }

    private void showEditTaskForManagerMenu() {
        while (true) {
            System.out.println("\n1 - изменить имя задания");
            System.out.println("2 - изменить владельца задания");
            System.out.println("3 - изменить статус задания");
            System.out.println("4 - изменить категорию задания");
            System.out.println("5 - выход в главное меню пользователя\n");
            System.out.println("Введите цифру нужного меню:");

            inputUserItemMenu = inputUserDataConsole.readString();

            if (inputUserItemMenu.equals("1")) {
                changeTaskNameForTask();
            } else if (inputUserItemMenu.equals("2")) {
                changeUserIdForTask();
            } else if (inputUserItemMenu.equals("3")) {
                changeStatusForTask();
            } else if (inputUserItemMenu.equals("4")) {
                showManagerMenu();
            } else {
                System.out.println("\nТакого меню не существует. Выбери только из указанных вариантов");
            }
        }
    }

    private void showEditUserMenuTitle() {
        System.out.println("\nМеню изменения данных пользователя");
    }

    private void showTaskUserMenuTitle() {
        System.out.println("\nМеню работы с заданиями:");
    }

    private void showMainTitle() {
        System.out.println("\nДобро пожаловать в ToDoList. \n\nВыберите нужный пункт меню:");
    }

    private void showRegistrationMenuTitle() {
        System.out.println("\nРегистрация нового пользователя.\n");
    }

    private void showLoginMenuTitle() {
        System.out.println("\nДля работы с приложением нужен пользователь");
        System.out.println("Если нет пользователя, то пройдите регистрацию");
    }

    private void showManagerMenuTitle() {
        System.out.println("\nГлавное меню менеджера");
        System.out.println("Привет, " + userService.getAuthorizedUserLogin() + ". Для работы выбери нужное меню:");
    }

    private void showUserMenuTitle() {
        System.out.println("\nГлавное меню пользователя.");
        System.out.println("Привет, " + userService.getAuthorizedUserLogin() + ". Для работы выбери нужное меню:");
    }

    private void editTaskStatusByIdToUser() {
        String inputUserIdTaskForEditStatusString = "";
        int inputUserIdTaskForEditStatus = -1;
        String inputNewTaskStatusIdString = "";
        String taskInfoFromId = "";
        int inputNewTaskId = -1;

        System.out.println("\nИзменением статуса task");

        while (true) {
            System.out.println("\nВведите ID task для смены статуса");
            inputUserIdTaskForEditStatusString = inputUserDataConsole.readString();
            if (!taskValidation.isNumeric(inputUserIdTaskForEditStatusString)) {
                System.out.println("\nНеобходимо ввести число");
            } else {
                inputUserIdTaskForEditStatus = Integer.parseInt(inputUserIdTaskForEditStatusString);
                taskInfoFromId = taskService.getTaskInfoFromID(userService.getAuthorizedUserID(), inputUserIdTaskForEditStatus);
                System.out.println("\n" + taskInfoFromId);
                break;
            }
        }

        if (taskInfoFromId.contains("ID")) {
            System.out.println("\nСписок поддерживаемых статусов task:");
            taskService.listTaskStatus();

            while (true) {
                System.out.println("\nВведите новый ID статуса задания");
                inputNewTaskStatusIdString = inputUserDataConsole.readString();
                if (!taskValidation.isNumeric(inputNewTaskStatusIdString)) {
                    System.out.println("\nНеобходимо ввести число");
                } else if (taskService.getTaskStatusIdFromBD(Integer.parseInt(inputNewTaskStatusIdString)) == -1) {
                    System.out.println("\nВведите ID нового статуса из списка");
                } else {
                    inputNewTaskId = Integer.parseInt(inputNewTaskStatusIdString);
                    int resultUpdate = taskService.updateTaskStatus(inputUserIdTaskForEditStatus, inputNewTaskId);

                    if (resultUpdate == -1) {
                        System.out.println("\nОшибка, во время смены статуса задания");
                    } else {
                        System.out.println("\nСтатус задания успешно обновлен");
                    }
                    break;
                }
            }
        }
    }

    private void printTaskInfoFromIdTaskByUser() {
        String inputUserTaskID = "";

        while (true) {
            System.out.println("\nВведите ID задания:");
            inputUserTaskID = inputUserDataConsole.readString();

            if (!taskValidation.isNumeric(inputUserTaskID)) {
                System.out.println("\nВведите ID задания");
            } else {
                break;
            }
        }

        String taskInfoFromId = taskService.getTaskInfoFromID(userService.getAuthorizedUserID(), Integer.parseInt(inputUserTaskID));
        System.out.println("\n" + taskInfoFromId);
    }

    private void printUserInfo() {
        System.out.println("\nВывод информации о пользователе:");
        String userInfo = userService.getUserInfo(userService.getAuthorizedUserID());
        System.out.println(userInfo);
    }

    private void printUserInfoByID() {
        String inputUserIdString = "";
        int inputUserId = -1;

        while (true) {
            System.out.println("\nВведите ID пользователя");
            inputUserIdString = inputUserDataConsole.readString();

            if (!roleValidation.isNumeric(inputUserIdString)) {
                System.out.println("\nВведите число");
                continue;
            } else if (userService.getUserIDFromBD(Integer.parseInt(inputUserIdString)) == -1) {
                System.out.println("\nНет пользователя с таким ID");
                continue;
            } else {
                inputUserId = Integer.parseInt(inputUserIdString);
                System.out.println("\nИнформация о пользователе с ID - " + inputUserId + ":");
                System.out.printf(userService.getUserInfo(inputUserId) + "\n");
                break;
            }
        }
    }

    private void printTaskInfoByID() {
        String inputTaskIdString = "";
        int inputTaskId = -1;

        while (true) {
            System.out.println("\nВведите ID task");
            inputTaskIdString = inputUserDataConsole.readString();

            if (!taskValidation.isNumeric(inputTaskIdString)) {
                System.out.println("\nВведите число");
                continue;
            } else if (taskService.getTaskIDFromBD(Integer.parseInt(inputTaskIdString)) == -1) {
                System.out.println("\nНет task с таким ID");
                continue;
            } else {
                inputTaskId = Integer.parseInt(inputTaskIdString);
                System.out.println("\nИнформация о task с ID - " + inputTaskId + ":");
                System.out.printf(taskService.getTaskInfo(inputTaskId) + "\n");
                break;
            }
        }
    }

    private void changeUserLogin() {
        System.out.println("\nВведите желаемый логин:");
        String newLogin = inputUserDataConsole.readString();
        if (!loginValidation.isValidMinLength(newLogin)) {
            System.out.println("\nОшибка. Минимальная дли логина 2 символа, может состоять только из En букв и цифр!");
        } else if (userService.getUserIDFromBD(newLogin) != -1) {
            System.out.println("\nЛогин занят");
        } else if (userService.updateAuthorizedUserLogin(newLogin)) {
            System.out.println("\nЛогин пользователя успешно изменен");
        } else {
            System.out.println("\nНе удалось изменить логин пользователя");
        }
    }

    private void changeUserLoginForManager() {
        String inputUserIdString = "";
        int inputUserId = -1;
        String newLogin = "";

        while (true) {
            System.out.println("\nВведите ID пользователя");
            inputUserIdString = inputUserDataConsole.readString();

            if (!taskValidation.isNumeric(inputUserIdString)) {
                System.out.println("\nВведите число");
                continue;
            } else if (userService.getUserIDFromBD(Integer.parseInt(inputUserIdString)) == -1) {
                System.out.println("\nНет пользователя с таким ID");
                continue;
            } else {
                inputUserId = Integer.parseInt(inputUserIdString);
                break;
            }
        }

        System.out.println("\n" + userService.getUserInfo(inputUserId));
        System.out.println("\nВведите желаемый логин:");
        newLogin = inputUserDataConsole.readString();

        if (!loginValidation.isValidMinLength(newLogin)) {
            System.out.println("\nОшибка. Минимальная длина логина 2 символа, может состоять только из En букв и цифр!");
        } else if (userService.getUserIDFromBD(newLogin) != -1) {
            System.out.println("\nЛогин занят");
        } else if (userService.updateUserLogin(inputUserId, newLogin)) {
            System.out.println("\nЛогин пользователя успешно изменен");
        } else {
            System.out.println("\nНе удалось изменить логин пользователя");
        }
    }

    private void changeUserPasswordForManager() {
        String inputUserIdString = "";
        int inputUserId = -1;
        String newPassword = "";

        while (true) {
            System.out.println("\nВведите ID пользователя");
            inputUserIdString = inputUserDataConsole.readString();

            if (!taskValidation.isNumeric(inputUserIdString)) {
                System.out.println("\nВведите число");
                continue;
            } else if (userService.getUserIDFromBD(Integer.parseInt(inputUserIdString)) == -1) {
                System.out.println("\nНет пользователя с таким ID");
                continue;
            } else {
                inputUserId = Integer.parseInt(inputUserIdString);
                break;
            }
        }

        System.out.println("\n" + userService.getUserInfo(inputUserId));
        System.out.println("\nВведите желаемый пароль:");
        newPassword = inputUserDataConsole.readString();

        if (!passwordValidation.isValidMinLength(newPassword)) {
            System.out.println("\nОшибка. Минимальная длина пароля 2 символа, может состоять только из En букв и цифр!");
        } else if (userService.updateUserPassword(inputUserId, newPassword)) {
            System.out.println("\nПароль пользователя успешно изменен");
        }
    }

    private void changeUserPassword() {
        System.out.println("\nВведите желаемый пароль:");
        String newPassword = inputUserDataConsole.readString();
        if (!passwordValidation.isValidMinLength(newPassword)) {
            System.out.println("\nОшибка. Минимальная длина пароля 2 символа, может состоять только из En букв и цифр!");
        } else if (userService.updateAuthorizedUserPassword(newPassword)) {
            System.out.println("\nПароль пользователя успешно изменен");
        }
    }

    private void changeUserRoleForManager() {
        String inputUserIdString = "";
        int inputUserId = -1;
        String newIdRoleString = "";
        int newIdRole = -1;

        while (true) {
            System.out.println("\nВведите ID пользователя");
            inputUserIdString = inputUserDataConsole.readString();

            if (!taskValidation.isNumeric(inputUserIdString)) {
                System.out.println("\nВведите число");
                continue;
            } else if (userService.getUserIDFromBD(Integer.parseInt(inputUserIdString)) == -1) {
                System.out.println("\nНет пользователя с таким ID");
                continue;
            } else {
                inputUserId = Integer.parseInt(inputUserIdString);
                break;
            }
        }

        if (userService.getAuthorizedUserRole() == inputUserId) {
            System.out.println("\nЗапрещено менять ID Role текущему пользователю");
        } else {
            while (true) {
                System.out.println("\nВыберите ID роли пользователя:");
                roleService.listRoleUser();
                System.out.println("\nВведите необходимый ID роли");

                newIdRoleString = inputUserDataConsole.readString();
                if (roleValidation.isNumeric(newIdRoleString)) {
                    newIdRole = Integer.parseInt(newIdRoleString);
                } else {
                    System.out.println("\nВведенное ID не существует");
                    continue;
                }

                if (!roleValidation.isValid(newIdRole)) {
                    System.out.println("\nВведенное ID не существует");
                } else {
                    break;
                }
            }

            if (userService.updateUserRole(inputUserId, newIdRole)) {
                System.out.println("\nRole пользователя успешно изменена");
            } else {
                System.out.println("\nОшибка при изменении Role пользователя");
            }
        }
    }

    private void deleteUserByID() {
        System.out.println("\nУдаление пользователя по ID");
        System.out.println("ВНИМАНИЕ! При удалении пользователя удалятся и все его task");

        String inputUserIdString = "";
        int inputUserId = -1;

        while (true) {
            System.out.println("\nВведите ID пользователя");
            inputUserIdString = inputUserDataConsole.readString();

            if (!taskValidation.isNumeric(inputUserIdString)) {
                System.out.println("\nВведите число");
                continue;
            } else if (userService.getUserIDFromBD(Integer.parseInt(inputUserIdString)) == -1) {
                System.out.println("\nНет пользователя с таким ID");
                continue;
            } else if (userService.getAuthorizedUserID() == Integer.parseInt(inputUserIdString)) {
                System.out.println("\nНевозможно удалить самого себя!");
                continue;
            } else {
                inputUserId = Integer.parseInt(inputUserIdString);
                if (userService.deleteUserFromDB(inputUserId)) {
                    System.out.println("\nПользователь с ID - " + inputUserId + " успешно удален");
                } else {
                    System.out.println("\nНе удалось удалить пользователя с ID - " + inputUserId);
                }
                break;
            }
        }
    }

    private void addTaskForManagerMenu() {
        System.out.println("\nДобавление task");

        String inputTaskNameString = "";
        String inputIdUserForTaskString = "";
        int inputIdUserForTask = -1;
        String inputIdStatusForTaskString = "";
        int inputIdStatusForTask = -1;
        String inputIdCategoryForTaskString = "";
        int inputIdCategoryForTask = -1;

        while (true) {
            System.out.println("\nВведите ID пользователя, для которого добавляется task");
            inputIdUserForTaskString = inputUserDataConsole.readString();

            if (!roleValidation.isNumeric(inputIdUserForTaskString)) {
                System.out.println("\nВведите число");
                continue;
            } else if (userService.getUserIDFromBD(Integer.parseInt(inputIdUserForTaskString)) == -1) {
                System.out.println("\nНет пользователя с таким ID");
                continue;
            } else if (roleService.getNameRoleFromID(Integer.parseInt(inputIdUserForTaskString)).toLowerCase().equals("manager")) {
                System.out.println("\n Для Manager нельзя добавлять task");
                continue;
            } else {
                inputIdUserForTask = Integer.parseInt(inputIdUserForTaskString);
                break;
            }
        }

        while (true) {
            System.out.println("\nВведите название task");
            inputTaskNameString = inputUserDataConsole.readString();

            if (taskService.checkTaskNameByUser(inputTaskNameString, inputIdUserForTask)) {
                System.out.println("\nTask с таким названием уже существует у пользователя с ID - " + inputIdUserForTask);
                continue;
            } else {
                break;
            }
        }

        //для всех task начальное значение "to do", если нужно другое, то реализовать ввод id статуса
        inputIdStatusForTaskString = "to do";
        inputIdStatusForTask = taskService.getIdForStatusName(inputIdStatusForTaskString);

        while (true) {
            System.out.println("\nВыберите ID категории:");
            taskService.printAllListCategory();
            System.out.println("\nВведите необходимый ID категории или нажмите Enter (будет назначена категория default):");

            inputIdCategoryForTaskString = inputUserDataConsole.readString();

            if (inputIdCategoryForTaskString.equals("")) {
                inputIdCategoryForTask = taskService.getIdForCategoryName("default");
                break;
            } else if (!taskValidation.isNumeric(inputIdCategoryForTaskString)) {
                System.out.println("\nВведите число");
                continue;
            } else if (taskService.getIdCategory(Integer.parseInt(inputIdCategoryForTaskString)) == -1) {
                System.out.println("\nНет категории с таким ID");
                continue;
            } else {
                inputIdCategoryForTask = Integer.parseInt(inputIdCategoryForTaskString);
                break;
            }
        }

        if (taskService.addTaskToDB(inputTaskNameString, inputIdUserForTask, inputIdStatusForTask, inputIdCategoryForTask)) {
            System.out.println("\nTask успешно создан для пользователя с ID - " + inputIdUserForTask);
        } else {
            System.out.println("\nОшибка при добавлении Task");
        }
    }

    private void delTaskForManagerMenu() {
        System.out.println("\nУдаление task");

        String inputIdTaskString = "";
        int inputIdTask = -1;

        while (true) {
            System.out.println("\nВведите ID task для удаления");
            inputIdTaskString = inputUserDataConsole.readString();

            if (!taskValidation.isNumeric(inputIdTaskString)) {
                System.out.println("\nВведите число");
                continue;
            } else if (taskService.getTaskIDFromBD(Integer.parseInt(inputIdTaskString)) == -1) {
                System.out.println("\nНет task с таким ID");
                continue;
            } else {
                inputIdTask = Integer.parseInt(inputIdTaskString);
                break;
            }
        }

        if (taskService.delTaskFromBdByIdTask(inputIdTask)) {
            System.out.println("\nTask c ID - " + inputIdTask + " успешно удалено");
        } else {
            System.out.println("\nОшибка при удалении Task с ID - " + inputIdTask);
        }
    }

    private void changeTaskNameForTask() {
        System.out.println("\nИзменение название задания");

        String inputIdTaskString = "";
        String inputNewTaskName = "";
        int inputIdTask = -1;

        while (true) {
            System.out.println("\nВведите ID задания, для которого нужно изменить имя");
            inputIdTaskString = inputUserDataConsole.readString();

            if (!taskValidation.isNumeric(inputIdTaskString)) {
                System.out.println("\nВведите число");
                continue;
            } else if (taskService.getTaskIDFromBD(Integer.parseInt(inputIdTaskString)) == -1) {
                System.out.println("\nНет задания с таким ID");
                continue;
            } else {
                inputIdTask = Integer.parseInt(inputIdTaskString);
                break;
            }
        }

        System.out.println("\nВведите новое имя задания:");
        inputNewTaskName = inputUserDataConsole.readString();

        if (taskService.updateTaskName(inputIdTask, inputNewTaskName)) {
            System.out.println("\nИзменение название для задания с ID - " + inputIdTask + " прошло успешно");
        } else {
            System.out.println("\nОшибка изменения названия для задания с ID - " + inputIdTask);
        }
    }

    private void changeUserIdForTask() {
        System.out.println("\nИзменение владельца задания");

        String inputIdTaskString = "";
        String inputIdUserString = "";
        int inputIdTask = -1;
        int inputIdUser = -1;

        while (true) {
            System.out.println("\nВведите ID задания, для которого нужно изменить владельца");
            inputIdTaskString = inputUserDataConsole.readString();

            if (!taskValidation.isNumeric(inputIdTaskString)) {
                System.out.println("\nВведите число");
                continue;
            } else if (taskService.getTaskIDFromBD(Integer.parseInt(inputIdTaskString)) == -1) {
                System.out.println("\nНет задания с таким ID");
                continue;
            } else {
                inputIdTask = Integer.parseInt(inputIdTaskString);
                break;
            }
        }

        while (true) {
            System.out.println("\nВведите ID пользователя, которому нужно добавить задание");
            inputIdUserString = inputUserDataConsole.readString();

            if(!taskValidation.isNumeric(inputIdUserString)) {
                System.out.println("\nВведите число");
                continue;
            } else if (userService.getUserIDFromBD(Integer.parseInt(inputIdUserString)) == -1) {
                System.out.println("\nНет пользователя с таким ID");
                continue;
            }  else if (roleService.getNameRoleFromID(Integer.parseInt(inputIdUserString)).toLowerCase().equals("manager")) {
                System.out.println("\nДля Manager нельзя добавлять задания");
                continue;
            } else {
                inputIdUser = Integer.parseInt(inputIdUserString);
                break;
            }
        }

        if (taskService.updateUserIdForTask(inputIdTask, inputIdUser)) {
            System.out.println("\nИзменение владельца для задания с ID - " + inputIdTask + " прошло успешно");
        } else {
            System.out.println("\nОшибка изменения названия для задания с ID - " + inputIdTask);
        }
    }

    private void changeStatusForTask() {
        String inputUserIdTaskForEditStatusString = "";
        int inputUserIdTaskForEditStatus = -1;
        String inputNewTaskStatusIdString = "";
        String taskInfoFromId = "";
        int inputNewTaskId = -1;

        System.out.println("\nИзменением статуса task");

        while (true) {
            System.out.println("\nВведите ID task для смены статуса");
            inputUserIdTaskForEditStatusString = inputUserDataConsole.readString();
            if (!taskValidation.isNumeric(inputUserIdTaskForEditStatusString)) {
                System.out.println("\nНеобходимо ввести число");
            } else if (taskService.getTaskIDFromBD(Integer.parseInt(inputUserIdTaskForEditStatusString)) == -1) {
                System.out.println("\nЗадания с таким ID не существует");
            } else {
                inputUserIdTaskForEditStatus = Integer.parseInt(inputUserIdTaskForEditStatusString);
                taskInfoFromId = taskService.getTaskInfo(inputUserIdTaskForEditStatus);
                System.out.println("\n" + taskInfoFromId);
                break;
            }
        }

        if (taskInfoFromId.contains("ID")) {
            System.out.println("\nСписок поддерживаемых статусов task:");
            taskService.listTaskStatus();

            while (true) {
                System.out.println("\nВведите новый ID статуса задания");
                inputNewTaskStatusIdString = inputUserDataConsole.readString();
                if (!taskValidation.isNumeric(inputNewTaskStatusIdString)) {
                    System.out.println("\nНеобходимо ввести число");
                } else if (taskService.getTaskStatusIdFromBD(Integer.parseInt(inputNewTaskStatusIdString)) == -1) {
                    System.out.println("\nВведите ID нового статуса из списка");
                } else {
                    inputNewTaskId = Integer.parseInt(inputNewTaskStatusIdString);
                    int resultUpdate = taskService.updateTaskStatus(inputUserIdTaskForEditStatus, inputNewTaskId);

                    if (resultUpdate == -1) {
                        System.out.println("\nОшибка, во время смены статуса задания");
                    } else {
                        System.out.println("\nСтатус задания успешно обновлен");
                    }
                    break;
                }
            }
        }
    }
}