package com.lesson12dz;

import java.util.ArrayList;
import java.util.Comparator;

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
                showTitleEditUserProduct();
                editUserProduct();
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
        System.out.println("1 - Выыод продуктов с сортировкой по цене (возрастание)");
        System.out.println("2 - Вывод продуктов с сортировкой по цене (убывание)");
        System.out.println("3 - Вывод продуктов с сортировкой по добавлению (сначала новые, потом более старые)\n");

        inputUserItemMenu = readerDataFromConsole.readString();

        if (inputUserItemMenu.equals("1")) {
            showTitleSortedProductByPriceAsc();
            sortedProductByPriceAsc();
        } else if (inputUserItemMenu.equals("2")) {
            showTitleSortedProductByPriceDesc();
            sortedProductByPriceDesc();
        } else if (inputUserItemMenu.equals("3")) {
            showTitleOutputOrderPriority();
            outputOrderPriority();
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
        int idDellProduct;

        System.out.println("Введите \"ID\" продукта");
        inputUserItemMenu = readerDataFromConsole.readString();
        while (!readerDataFromConsole.isNumeric(inputUserItemMenu)) {
            System.out.println("\n\"ID\" может быть только числом, введите число\n");
            inputUserItemMenu = readerDataFromConsole.readString();
        }
        idDellProduct = Integer.parseInt(inputUserItemMenu);

        store.removeProduct(idDellProduct);
    }

    private void editUserProduct() {
        int id;
        String newName = "";
        int newPrice;

        System.out.println("Введите \"ID\" продукта");
        inputUserItemMenu = readerDataFromConsole.readString();
        while (!readerDataFromConsole.isNumeric(inputUserItemMenu)) {
            System.out.println("\n\"ID\" может быть только числом, введите число\n");
            inputUserItemMenu = readerDataFromConsole.readString();
        }
        id = Integer.parseInt(inputUserItemMenu);

        System.out.println("\nВведите \"Новое название\" продукта с ID = " + id);
        inputUserItemMenu = readerDataFromConsole.readString();
        while (inputUserItemMenu.length() < 2) {
            System.out.println("\nНазвание продукта не может быть короче 2-х символов\n");
            inputUserItemMenu = readerDataFromConsole.readString();
        }
        newName = inputUserItemMenu;

        System.out.println("\nВведите \"Новую цену\" продукта с ID = " + id);
        inputUserItemMenu = readerDataFromConsole.readString();
        while (!readerDataFromConsole.isNumeric(inputUserItemMenu)) {
            System.out.println("\n\"Новая цена\" может быть только числом, введите число\n");
            inputUserItemMenu = readerDataFromConsole.readString();
        }
        newPrice = Integer.parseInt(inputUserItemMenu);

        store.editProduct(new Product(id, newName, newPrice));
    }

    private void sortedProductByPriceAsc() {
        ArrayList<Product> list = store.getMapCatalogProducts();

        if (list.size() == 0) {
            System.out.println("Каталог продуктов пуст");
        } else {
            Comparator<Product> sortedProductByPriceAsc = new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if (o1.getPrice() > o2.getPrice()) {
                        return 1;
                    } else if (o1.getPrice() < o2.getPrice()) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            };

            list.sort(sortedProductByPriceAsc);

            for (Product itemProduct : list) {
                System.out.println("ID продукта - " + itemProduct.getId() + "; название продукта - " + itemProduct.getName() + "; Цена продукта - " + itemProduct.getPrice());
            }
        }
    }

    private void sortedProductByPriceDesc() {
        ArrayList<Product> list = store.getMapCatalogProducts();

        if (list.size() == 0) {
            System.out.println("Каталог продуктов пуст");
        } else {
            Comparator<Product> sortedProductByPriceDesc = new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if (o1.getPrice() < o2.getPrice()) {
                        return 1;
                    } else if (o1.getPrice() > o2.getPrice()) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            };

            list.sort(sortedProductByPriceDesc);

            for (Product itemProduct : list) {
                System.out.println("ID продукта - " + itemProduct.getId() + "; название продукта - " + itemProduct.getName() + "; Цена продукта - " + itemProduct.getPrice());
            }
        }
    }

    private void outputOrderPriority() {
        ArrayList<Product> list = store.getMapCatalogProducts();
        if (list.size() == 0) {
            System.out.println("Каталог продуктов пуст");
        } else {
            for (int i = list.size() - 1; i >= 0; i--) {
                System.out.println( "ID продукта - " + list.get(i).getId() + "; название продукта - " + list.get(i).getName() + "; Цена продукта - " + list.get(i).getPrice());
            }
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