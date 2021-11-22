package com.lesson10dz;

public class Menu {
    public static ATB atb;
    private static User user;
    private String inputDate;

    private CreateUserCardATB createUserCardATB = new CreateUserCardATB();
    private ReaderDataFromConsole readerDataFromConsole = new ReaderDataFromConsole();

    private String readerDataFromConsole() {
        inputDate = readerDataFromConsole.readString();
        return inputDate;
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
        atb = createUserCardATB.getATB();
        System.out.println("Банкомат создан. Параметы банкомата");
        System.out.println(atb.toString());
    }

    private void makeUser() {
        user = createUserCardATB.getUserCard();
        ;
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
                atb.insertCard(user);
            } else if (inputSelectedUserMenu.equals("2")) {
                atb.getBalanceCard(user);
            } else if (inputSelectedUserMenu.equals("3")) {
                atb.getMoney(user);
            } else if (inputSelectedUserMenu.equals("4")) {
                System.out.println("\nРабота с банкоматом завершена. Заберите свою карту.");
                readerDataFromConsole.readerClose();
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
