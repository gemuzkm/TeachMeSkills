package com.project.Calculator;

public class AuthorizationMenu implements Menu {

    private String selectMenu;
    private InputData inputUserDataConsole = new InputData();
    private Authorization authorization = new Authorization();

    @Override
    public void showTitle() {
        System.out.println("Для работы с приложением нужен пользователь");
        System.out.println("Если нет пользователя, то пройдите регистрацию\n");
    }

    @Override
    public void showMenu() {
        System.out.println("Введите \"1\" для регистрации");
        System.out.println("Введите \"2\" для входа при помощи логина/пароля");
        System.out.println("Нажмите \"3\" для выхода из приложения\n");
        System.out.println("Введите цифру нужного меню:");
    }

    @Override
    public void selectMenu() {
        selectMenu = inputUserDataConsole.readerDataString();

        if (selectMenu.equals("1")) {
            authorization.registrationUser();
        } else if (selectMenu.equals("2")) {
            authorization.loginUser();
        } else if (selectMenu.equals("3")) {
            inputUserDataConsole.readerClose();
            System.exit(0);
        } else {
            System.out.println("\nТакого меню не существует. Выбери только из указанных вариантов\n");
        }
    }
}
