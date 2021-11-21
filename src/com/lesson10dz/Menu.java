package com.lesson10dz;

public class Menu {
    private ATB atb;
    private User user;

    GreateATBUserCard greateATBUserCard = new GreateATBUserCard();


    private void showTitle () {
        System.out.println("Имитация работы банкомата");
        System.out.println("Данные юзера, карт, банкоматов\n");
    }

    private void makeATB() {
        atb = greateATBUserCard.getATB();
        System.out.println("Банкомат создан. Параметы банкомата");
        System.out.println(atb.toString());
    }

    private void makeUser() {
        user = greateATBUserCard.getUserCard();;
        System.out.println("\nЮзер создан. Параметры Юзера");
        System.out.println(user.toString());
    }

    private void showMenuATB() {

    }

    public void show() {
        showTitle();
        makeATB();
        makeUser();
        showMenuATB();

    }
}
