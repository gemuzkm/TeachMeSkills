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
                store.addUserProduct();
            } else if (inputUserItemMenu.equals("3")) {
                showTitleDellUserProduct();
                store.dellUserProduct();
            } else if (inputUserItemMenu.equals("4")) {
                showTitleEditUserProduct();
                store.editUserProduct();
            } else if (inputUserItemMenu.equals("5")) {
                System.out.println("Завершение работы приложения");
                readerDataFromConsole.readerClose();
                System.exit(0);
            } else {
                System.out.println("\nДанного меню не существует. Попробуйте еще раз.\n");
            }
        }
    }

    public void showSortProductMenu() {
        System.out.println("1 - Выыод продуктов с сортировкой по цене (возрастание)");
        System.out.println("2 - Вывод продуктов с сортировкой по цене (убывание)");
        System.out.println("3 - Вывод продуктов с сортировкой по добавлению (сначала новые, потом более старые)\n");

        inputUserItemMenu = readerDataFromConsole.readString();

        if (inputUserItemMenu.equals("1")) {
            showTitleSortedProductByPriceAsc();
            store.sortedProductByPriceAsc();
        } else if (inputUserItemMenu.equals("2")) {
            showTitleSortedProductByPriceDesc();
            store.sortedProductByPriceDesc();
        } else if (inputUserItemMenu.equals("3")) {
            showTitleOutputOrderPriority();
            store.outputOrderPriority();
        }
    }

    private void showTitle() {
        System.out.println("Приложение магазин. Только базовые возможности. Тестируем :-)");
        System.out.println("Для работы нужно ввести соотвествующее значение меню");
    }

    private void showTitleSortProductMenu() {
        System.out.println("\nДля сортировки товара, выберите соотвествующий пункт меню:\n");
    }

    private void showTitleAddUserProduct() {
        System.out.println("\nМеню добавления продукта\n");
    }

    private void showTitleDellUserProduct() {
        System.out.println("\nУдаления продукта\n");
    }

    private void showTitleEditUserProduct() {
        System.out.println("\nРедактирование продукта\n");
    }

    private void showTitleSortedProductByPriceAsc() {
        System.out.println("Выыод продуктов с сортировкой по цене (возрастание):");
    }

    private void showTitleSortedProductByPriceDesc() {
        System.out.println("Вывод продуктов с сортировкой по цене (убывание):");
    }

    private void showTitleOutputOrderPriority() {
        System.out.println("Вывод продуктов с сортировкой по добавлению (сначала новые, потом более старые)");
    }
}