package com.project;

import java.io.IOException;

public class Menu {
    private static String selectMenu;

    public static void showTitle() {
        System.out.println("Привет. Это приложение калькулятор. Оно готово к работе.\n");
    }

    public static void showMenu() {
        System.out.println("Нажмите \"1\" для выполнения арифметической опперации");
        System.out.println("Нажмите \"2\" для отображения истории операций");
        System.out.println("Нажмите \"3\" для выхода из приложения\n");
        System.out.println("Введите число:");
    }

    public static void selectMenu() throws IOException {
        selectMenu =  InputData.readerData();

        switch (selectMenu) {
            case "1" :
                Calculator.actions(); break;
            case "2" :
                History.printHistory(); break;
            case "3" :
                System.exit(0);
            default:
                System.out.println("Такого меню не существует. Выбери только из указанных вариантов\n");
        }
    }
}
