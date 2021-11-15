package com.project.Calculator;

import java.io.IOException;

public class AuthorizationMenu implements Menu {

    private String selectMenu;
    private InputData inputData = new InputData();

    @Override
    public void showTitle() {
        System.out.println("Для работы с приложением нужен пользователь.");
        System.out.println("Если нет пользователя, то пройдите регистрацию.\n");
    }

    @Override
    public void showMenu () {
            System.out.println("Введите \"1\" для регистрации введите ");
            System.out.println("Введите \"2\" для входа при помощи логина/пароля");
            System.out.println("Нажмите \"3\" для выхода из приложения\n");
            System.out.println("Введите цифру нужного меню:");
        }

    @Override
    public void selectMenu() throws IOException {
        selectMenu =  inputData.readerDataString();

        switch (selectMenu) {
            case "1" :
                new Authorization().registration();
                break;
            case "2" :
                new Authorization().login();
                break;
            case "3" :
                inputData.readerClose();
                System.exit(0);
            default:
                System.out.println("\nТакого меню не существует. Выбери только из указанных вариантов\n");
        }
    }
}
