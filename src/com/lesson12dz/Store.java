package com.lesson12dz;

import java.util.*;

public class Store {
    private List<Product> listCatalogProducts = new ArrayList<>();
    private ReaderDataFromConsole readerDataFromConsole = new ReaderDataFromConsole();
    private String inputUserItemMenu = "";

    public void addProduct(Product product) {
        if (listCatalogProducts.size() == 0) {
            listCatalogProducts.add(product);
            System.out.println("Продукт добавлен успешно!");
        } else if (getIdProduct(product) == -1) {
            listCatalogProducts.add(product);
            System.out.println("\nПродукт добавлен успешно!");
        } else {
            System.out.println("\nПродукт не добавлен! Товар с таким \"ID\" уже существует");
        }
    }

    public List<Product> getCatalogProducts() {
        return listCatalogProducts;
    }

    public void removeProduct(int idProduct) {
        if (listCatalogProducts.size() == 0) {
            System.out.println("\nУдаление невозможно, каталог пуст");
        } else if (getIdProduct(idProduct) == -1) {
            System.out.println("\nУдаление невозможно, продукта с ID = " + idProduct + " нет в каталоге");
        } else if (true) {
            listCatalogProducts.removeIf(item -> item.getId() == idProduct);

            System.out.println("\nПродукт с ID = " + idProduct + " успешно удален из каталога");
        }
    }

    public void editProduct(Product newProduct) {
        int idCatalogProduct = getIdProduct(newProduct);
        if (idCatalogProduct == -1) {
            System.out.println("\nПродукта с таким ID не существует");
        } else {
            newProduct.setAddDate(listCatalogProducts.get(idCatalogProduct).getAddDate());
            listCatalogProducts.set(idCatalogProduct, newProduct);
            System.out.println("\nДанные продукта с ID = " + newProduct.getId() + " успешно обновлены");
        }
    }

    // вернет -1, если нет продукта в списке или нет ID продукта в списке
    private int getIdProduct(Product product) {
        for (int i = 0; i < listCatalogProducts.size(); i++) {
            if (listCatalogProducts.get(i).getId() == product.getId()) {
                return i;
            }
        }
        return -1;
    }

    // вернет -1, если нет продукта в списке или нет ID продукта в списке
    private int getIdProduct(int idProduct) {
        for (int i = 0; i < listCatalogProducts.size(); i++) {
            if (listCatalogProducts.get(i).getId() == idProduct) {
                return i;
            }
        }
        return -1;
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
        if (listCatalogProducts.size() == 0) {
            System.out.println("Каталог продуктов пуст");
        } else {
            listCatalogProducts.stream()
                    .sorted((Comparator.comparingInt(Product::getPrice)))
                    .forEach(itemProduct -> System.out.println("ID продукта - " + itemProduct.getId() +
                            "; Название продукта - " + itemProduct.getName() +
                            "; Цена продукта - " + itemProduct.getPrice() +
                            "; Дата добавление продкта - " + itemProduct.getAddDate() +
                            "; Дата обновления товара - " + itemProduct.getUpdDate()));
        }
    }

    public void sortedProductByPriceDesc() {
        if (listCatalogProducts.size() == 0) {
            System.out.println("Каталог продуктов пуст");
        } else {
            listCatalogProducts.stream()
                    .sorted((o1, o2) -> Integer.compare((o2.getPrice()), o1.getPrice()))
                    .forEach(itemProduct -> System.out.println("ID продукта - " + itemProduct.getId() +
                            "; Название продукта - " + itemProduct.getName() +
                            "; Цена продукта - " + itemProduct.getPrice() +
                            "; Дата добавление продукта - " + itemProduct.getAddDate() +
                            "; Дата обновление продукта - " + itemProduct.getUpdDate()));
        }
    }

    public void SortedProductByDateAddAsc() {
        if (listCatalogProducts.size() == 0) {
            System.out.println("Каталог продуктов пуст");
        } else {
            listCatalogProducts.stream()
                    .sorted(((o1, o2) -> o2.getAddDate().compareTo(o1.getAddDate())))
                    .forEach(itemProduct -> System.out.println("ID продукта - " + itemProduct.getId() +
                            "; Название продукта - " + itemProduct.getName() +
                            "; Цена продукта - " + itemProduct.getPrice() +
                            "; Дата добавление продкта - " + itemProduct.getAddDate() +
                            "; Дата обновления товара - " + itemProduct.getUpdDate()));
        }
    }

    public void SortedProductByDateAddDesc() {
        if (listCatalogProducts.size() == 0) {
            System.out.println("Каталог продуктов пуст");
        } else {
            listCatalogProducts.stream()
                    .sorted(Comparator.comparing(Product::getAddDate))
                    .forEach(itemProduct -> System.out.println("ID продукта - " + itemProduct.getId() +
                            "; Название продукта - " + itemProduct.getName() +
                            "; Цена продукта - " + itemProduct.getPrice() +
                            "; Дата добавление продкта - " + itemProduct.getAddDate() +
                            "; Дата обновления товара - " + itemProduct.getUpdDate()));
        }
    }

    public void outputOrderPriority() {
        if (listCatalogProducts.size() == 0) {
            System.out.println("Каталог продуктов пуст");
        } else {
            SortedProductByDateAddAsc();
//            for (int i = listCatalogProducts.size() - 1; i >= 0; i--) {
//                System.out.println("ID продукта - " + listCatalogProducts.get(i).getId() +
//                        "; Название продукта - " + listCatalogProducts.get(i).getName() +
//                        "; Цена продукта - " + listCatalogProducts.get(i).getPrice() +
//                        "; Дата доваления продукта - " + listCatalogProducts.get(i).getAddDate() +
//                        "; Дата обновления продукта - " + listCatalogProducts.get(i).getUpdDate());
//            }

        }
    }
}