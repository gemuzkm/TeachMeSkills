package com.lesson12dz;

import java.util.*;

public class Store {
    private HashMap<Integer, Product> mapCatalogProducts = new HashMap<>();
    private ReaderDataFromConsole readerDataFromConsole = new ReaderDataFromConsole();
    private int idMapProduct = 0;
    private String inputUserItemMenu = "";


    public void addProduct(Product product) {
        if (mapCatalogProducts.size() == 0) {
            mapCatalogProducts.put(idMapProduct, product);
            idMapProduct++;
            System.out.println("Продукт добавлен успешно!");
        } else if (getIdProduct(product) == -1) {
            mapCatalogProducts.put(idMapProduct, product);
            idMapProduct++;
            System.out.println("Продукт добавлен успешно!");
        } else {
            System.out.println("Продукт не добавлен! Товар с таким \"ID\" уже существует");
        }
    }

    public ArrayList<Product> getMapCatalogProducts() {
        ArrayList<Product> listCatalogProduct = new ArrayList<>();

        for (Map.Entry<Integer, Product> item : mapCatalogProducts.entrySet()) {
            listCatalogProduct.add(item.getValue());
        }
        return listCatalogProduct;
    }

    public void removeProduct(int idProduct) {
        if (mapCatalogProducts.size() == 0) {
            System.out.println("\nУдаление невозможно, каталог пуст");
        } else if (getIdProduct(idProduct) == -1) {
            System.out.println("\nУдаление невозможно, продукта с ID = " + idProduct + " нет в каталоге");
        } else if (true) {
            int idRemoveCatalogProduct = getIdProduct(idProduct);
            mapCatalogProducts.remove(idRemoveCatalogProduct);
            System.out.println("\nПродукт с ID = " + idProduct + " успешно удален из каталога");
        }
    }

    public void editProduct(Product newProduct) {
        int idCatalogProduct = getIdProduct(newProduct);
        if (idCatalogProduct == -1) {
            System.out.println("\nПродукта с таким ID не существует");
        } else {
            mapCatalogProducts.put(idCatalogProduct, newProduct);
            System.out.println("\nДанные продукта с ID = " + newProduct.getId() + " успешно обновлены");
        }
    }

    // вернет -1, если нет продукта в списке или нет ID продукта в списке
    private int getIdProduct(Product product) {
        for (Map.Entry<Integer, Product> itemCatalogProduct : mapCatalogProducts.entrySet()) {
            if (itemCatalogProduct.getValue().getId() == product.getId()) {
                return itemCatalogProduct.getKey();
            }
        }
        return -1;
    }

    // вернет -1, если нет продукта в списке или нет ID продукта в списке
    private int getIdProduct(int idProduct) {
        for (Map.Entry<Integer, Product> itemCatalogProduct : mapCatalogProducts.entrySet()) {
            if (itemCatalogProduct.getValue().getId() == idProduct) {
                return itemCatalogProduct.getKey();
            }
        }
        return -1;
    }

    public void showSortProductMenu() {
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

    public void addUserProduct() {
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

        addProduct(new Product(id, name, price));
    }

    public void dellUserProduct() {
        int idDellProduct;

        System.out.println("Введите \"ID\" продукта");
        inputUserItemMenu = readerDataFromConsole.readString();
        while (!readerDataFromConsole.isNumeric(inputUserItemMenu)) {
            System.out.println("\n\"ID\" может быть только числом, введите число\n");
            inputUserItemMenu = readerDataFromConsole.readString();
        }
        idDellProduct = Integer.parseInt(inputUserItemMenu);

        removeProduct(idDellProduct);
    }

    public void editUserProduct() {
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

        editProduct(new Product(id, newName, newPrice));
    }

    public void sortedProductByPriceAsc() {
        ArrayList<Product> list = getMapCatalogProducts();

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
                System.out.println("ID продукта - " + itemProduct.getId() + "; Название продукта - " + itemProduct.getName() + "; Цена продукта - " + itemProduct.getPrice());
            }
        }
    }

    public void sortedProductByPriceDesc() {
        ArrayList<Product> list = getMapCatalogProducts();

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
                System.out.println("ID продукта - " + itemProduct.getId() + "; Название продукта - " + itemProduct.getName() + "; Цена продукта - " + itemProduct.getPrice());
            }
        }
    }

    public void outputOrderPriority() {
        ArrayList<Product> list = getMapCatalogProducts();
        if (list.size() == 0) {
            System.out.println("Каталог продуктов пуст");
        } else {
            for (int i = list.size() - 1; i >= 0; i--) {
                System.out.println( "ID продукта - " + list.get(i).getId() + "; Название продукта - " + list.get(i).getName() + "; Цена продукта - " + list.get(i).getPrice());
            }
        }
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