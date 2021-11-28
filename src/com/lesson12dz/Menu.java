package com.lesson12dz;

public class Menu {
    private ReaderDataFromConsole readerDataFromConsole = new ReaderDataFromConsole();
    private Store store = new Store();
    private String inputUserItemMenu = "";

    public void start() {
        showTitle();
        showMainMenu();
    }

    private void showMainMenu() {
        while (true) {
            System.out.println("\n1 - Вывод всех товаров");
            System.out.println("2 - Добавление товар");
            System.out.println("3 - Удаление товара");
            System.out.println("4 - Редактирование товара");
            System.out.println("5 - Выход\n");

            inputUserItemMenu = readerDataFromConsole.readString();

            if (inputUserItemMenu.equals("1")) {
                showTitleSortProductMenu();
                showSortProductMenu();
            } else if (inputUserItemMenu.equals("2")) {
                showTitleAddUserProduct();
                addUserProduct();
            } else if (inputUserItemMenu.equals("3")) {
                showTitleDellUserProduct();
                dellUserProduct();
            } else if (inputUserItemMenu.equals("4")) {

            } else if (inputUserItemMenu.equals("5")) {
                System.out.println("Завершение работы приложения");
                readerDataFromConsole.readerClose();
                System.exit(0);
            } else {
                System.out.println("\nДанного меню не существует. Попробуйте еще раз.\n");
            }

        }
    }

    private void showSortProductMenu() {
        System.out.println("1 - Сортировка по цене (возрастание)");
        System.out.println("2 - Сортировка по цене (убывание)");
        System.out.println("3 - Сортировка по добавлению (сначала новые, потом более старые)\n");

        inputUserItemMenu = readerDataFromConsole.readString();

        if (inputUserItemMenu.equals("1")) {
            System.out.println("1");
        } else if (inputUserItemMenu.equals("2")) {
            System.out.println("2");
        } else if (inputUserItemMenu.equals("3")) {
            System.out.println("3");
        }

    }

    private void addUserProduct() {
        int id;
        String name = "";
        int price;

        System.out.println("Введите \"ID\" продукта");
        inputUserItemMenu = readerDataFromConsole.readString();
        while (!readerDataFromConsole.isNumeric(inputUserItemMenu)) {
            System.out.println("\n\"ID\" может быть только числом, введите число\n");
            inputUserItemMenu = readerDataFromConsole.readString();
        }
        id = Integer.parseInt(inputUserItemMenu);

        System.out.println("\nВведите \"Название\" продукта");
        inputUserItemMenu = readerDataFromConsole.readString();
        while (inputUserItemMenu.length() < 2) {
            System.out.println("\nНазвание продукта не может быть короче 2-х символов\n");
            inputUserItemMenu = readerDataFromConsole.readString();
        }
        name = inputUserItemMenu;

        System.out.println("\nВведите \"Цену\" продукта");
        inputUserItemMenu = readerDataFromConsole.readString();
        while (!readerDataFromConsole.isNumeric(inputUserItemMenu)) {
            System.out.println("\n\"Цена\" может быть только числом, введите число\n");
            inputUserItemMenu = readerDataFromConsole.readString();
        }
        price = Integer.parseInt(inputUserItemMenu);

        store.addProduct(new Product(id, name, price));
    }

    private void dellUserProduct() {
        int id;

        System.out.println("Введите \"ID\" продукта");
        inputUserItemMenu = readerDataFromConsole.readString();
        while (!readerDataFromConsole.isNumeric(inputUserItemMenu)) {
            System.out.println("\n\"ID\" может быть только числом, введите число\n");
            inputUserItemMenu = readerDataFromConsole.readString();
        }
        id = Integer.parseInt(inputUserItemMenu);

        store.removeProduct(id);
    }

    private void showTitle() {
        System.out.println("Приложение магазин. Только базовые возможности. Тестируем :-)");
        System.out.println("Для работы нужно ввести соотвествующее значение меню\n");
    }

    private void showTitleSortProductMenu() {
        System.out.println("\nДля сортировки товара, выберите соотвествующий пункт меню:\n");
    }

    private void showTitleAddUserProduct() {
        System.out.println("\nМеню добавления продукта\n");
    }

    private void showTitleDellUserProduct () {
        System.out.println("\nУдаления продукта\n");
    }
}
