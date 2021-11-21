package com.lesson10dz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    private ATB atb;
    private User user;
    private String inputDate;

    private GreateUserCardATB greateUserCardATB = new GreateUserCardATB();
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private String readerDataFromConsole() {
        try {
            inputDate = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputDate;
    }

    private void readerCloseStream() {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showTitleMenu() {
        System.out.println("Имитация работы банкомата");
        System.out.println("Данные юзера, карт, банкоматов\n");
    }

    private void showTitleATBMenu() {
        System.out.println("\nМеню работы банкомата");
        System.out.println("Выберите нужный пунки меню. Кадому менб соответствует соотвествующее число\n");
    }

    private void makeATB() {
        atb = greateUserCardATB.getATB();
        System.out.println("Банкомат создан. Параметы банкомата");
        System.out.println(atb.toString());
    }

    private void makeUser() {
        user = greateUserCardATB.getUserCard();;
        System.out.println("\nЮзер создан. Параметры Юзера");
        System.out.println(user.toString());
    }

    private void showMenuATB() {
        String inputSelectedUserMenu;
        while (true) {
            System.out.println("\"1\" - Вставить карту в бакномат");
            System.out.println("\"2\" - Проверить баланс карты");
            System.out.println("\"3\" - Снять деньги");
            System.out.println("\"4\" - Закончить работу с банкоматом\n");

        inputSelectedUserMenu = readerDataFromConsole();

        if (inputSelectedUserMenu.equals("1")) {
            System.out.println("1");
        } else if (inputSelectedUserMenu.equals("2")) {
            System.out.println("2");
        } else if (inputSelectedUserMenu.equals("3")) {
            System.out.println("3");
        } else if (inputSelectedUserMenu.equals("4")) {
            System.out.println("\nРабота с банкоматом завершена");
            readerCloseStream();
            System.exit(0);
        } else {
            System.out.println("\nВвели некорректный пункт меню\n");
        }

        }
    }

    public void show() {
        showTitleMenu();
        makeATB();
        makeUser();
        showTitleATBMenu();
        showMenuATB();

    }
}
