package com.project.ToDoList.controller;

public class ToDoListLoginMenu {
    private String selectMenu;
    private ReaderDataFromConsole inputUserDataConsole = new ReaderDataFromConsole();

    public void showTitle() {
        System.out.println("Для работы с приложением нужен пользователь");
        System.out.println("Если нет пользователя, то пройдите регистрацию\n");
    }

    public void showMenu() {
        System.out.println("Введите \"1\" для регистрации");
        System.out.println("Введите \"2\" для входа при помощи логина/пароля");
        System.out.println("Нажмите \"3\" для выхода из приложения\n");
        System.out.println("Введите цифру нужного меню:");
    }

    public void selectMenu() {
        selectMenu = inputUserDataConsole.readString();

        if (selectMenu.equals("1")) {
            //authorization.registrationUser();
        } else if (selectMenu.equals("2")) {
            //authorization.loginUser();
        } else if (selectMenu.equals("3")) {
            inputUserDataConsole.readerClose();
            System.exit(0);
        } else {
            System.out.println("\nТакого меню не существует. Выбери только из указанных вариантов\n");
        }
    }
}
