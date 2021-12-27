package com.project.ToDoList.controller;

public class MainMenu implements Menu {
    private ReaderDataFromConsole inputUserDataConsole = new ReaderDataFromConsole();
    private LoginMenu loginMenu = new LoginMenu();
    private RegistrationMenu registrationMenu = new RegistrationMenu();
    private String inputUserItemMenu = "";

    @Override
    public void show() {
        showTitle();
        showMenu();
    }

    private void showTitle() {
        System.out.println("Добропожаловть в ToDoList. \n\nВыберите нужный пункт меню:");
    }

    private void showMenu() {
        while (true) {
            System.out.println("\n1 - для регистрации");
            System.out.println("2 - для входа при помощи логина/пароля");
            System.out.println("3 - для выхода из приложения\n");
            System.out.println("Введите цифру нужного меню:");

            inputUserItemMenu = inputUserDataConsole.readString();

            if (inputUserItemMenu.equals("1")) {
                registrationMenu.show();
            } else if (inputUserItemMenu.equals("2")) {
                loginMenu.show();
            } else if (inputUserItemMenu.equals("3")) {
                inputUserDataConsole.readerClose();
                System.exit(0);
            } else {
                System.out.println("\nТакого меню не существует. Выбери только из указанных вариантов");
            }
        }
    }
}
