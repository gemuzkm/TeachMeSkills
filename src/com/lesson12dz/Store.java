package com.lesson12dz;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Store {
    //!!!!!!!!!!УДАЛИТЬ MAP ПОСЛЕ ПЕРЕПИСЫВАНИЯ НА LIST!!!!!!!!!!!!!!!!!!!!!!
    private HashMap<Integer, Product> mapCatalogProducts = new HashMap<>();
    private List<Product> listCatalogProducts = new ArrayList<>();
    private ReaderDataFromConsole readerDataFromConsole = new ReaderDataFromConsole();
    private int idMapProduct = 0;
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
 //           int idRemoveCatalogProduct = getIdProduct(idProduct);
            // удаление с применением lambda
            listCatalogProducts.removeIf(item -> item.getId() == idProduct);
//            listCatalogProducts.remove(idRemoveCatalogProduct);
            System.out.println("\nПродукт с ID = " + idProduct + " успешно удален из каталога");
        }
    }

    public void editProduct(Product newProduct) {
        int idCatalogProduct = getIdProduct(newProduct);
        if (idCatalogProduct == -1) {
            System.out.println("\nПродукта с таким ID не существует");
        } else {
            // заменяется новый объетом, но дата добвления установливается старого объекта
            newProduct.setAddDate(mapCatalogProducts.get(idCatalogProduct).getAddDate());
            // замена объекта на новый, где дата добавления сохранена
            mapCatalogProducts.put(idCatalogProduct, newProduct);
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
//        ArrayList<Product> list = getMapCatalogProducts();
        List<Product> list = getCatalogProducts();

        if (list.size() == 0) {
            System.out.println("Каталог продуктов пуст");
        } else {
            list.stream()
                    .sorted((Comparator.comparingInt(Product::getPrice)))
                    .forEach(itemProduct -> System.out.println("ID продукта - " + itemProduct.getId() +
                            "; Название продукта - " + itemProduct.getName() +
                            "; Цена продукта - " + itemProduct.getPrice() +
                            "; Дата добавление продкта - " + itemProduct.getAddDate() +
                            "; Дата обновления товара - " + itemProduct.getUpdDate()));

//            list.sort((o1, o2) -> Integer.compare(o1.getPrice(), o2.getPrice()));
//            for (Product itemProduct : list) {
//                System.out.println("ID продукта - " + itemProduct.getId() +
//                        "; Название продукта - " + itemProduct.getName() +
//                        "; Цена продукта - " + itemProduct.getPrice() +
//                        "; Дата добавление продкта - " + itemProduct.getAddDate() +
//                        "; Дата обновления товара - " + itemProduct.getUpdDate());
//            }
        }
    }

    public void sortedProductByPriceDesc() {
//        ArrayList<Product> list = getMapCatalogProducts();
        List<Product> list = getCatalogProducts();

        if (list.size() == 0) {
            System.out.println("Каталог продуктов пуст");
        } else {
            list.stream()
                    .sorted((o1, o2) -> Integer.compare((o2.getPrice()), o1.getPrice()))
                    .forEach(itemProduct -> System.out.println("ID продукта - " + itemProduct.getId() +
                            "; Название продукта - " + itemProduct.getName() +
                            "; Цена продукта - " + itemProduct.getPrice() +
                            "; Дата добавление продукта - " + itemProduct.getAddDate() +
                            "; Дата обновление продукта - " + itemProduct.getUpdDate()));

//            list.sort((o1, o2) -> Integer.compare((o2.getPrice()), o1.getPrice()));
//
//            for (Product itemProduct : list) {
//                System.out.println("ID продукта - " + itemProduct.getId() +
//                        "; Название продукта - " + itemProduct.getName() +
//                        "; Цена продукта - " + itemProduct.getPrice() +
//                        "; Дата добавление продукта - " + itemProduct.getAddDate() +
//                        "; Дата обновление продукта - " + itemProduct.getUpdDate()
//                );
//            }
        }
    }

    public void SortedProductByDateAddAsc() {
//        ArrayList<Product> list = getMapCatalogProducts();
        List<Product> list = getCatalogProducts();

        if (list.size() == 0) {
            System.out.println("Каталог продуктов пуст");
        } else {
            list.stream()
                    .sorted(((o1, o2) -> o2.getAddDate().compareTo(o1.getAddDate())))
                    .forEach(itemProduct -> System.out.println("ID продукта - " + itemProduct.getId() +
                            "; Название продукта - " + itemProduct.getName() +
                            "; Цена продукта - " + itemProduct.getPrice() +
                            "; Дата добавление продкта - " + itemProduct.getAddDate() +
                            "; Дата обновления товара - " + itemProduct.getUpdDate()));

//            list.sort(((o1, o2) -> o2.getAddDate().compareTo(o1.getAddDate())));
//
//            for (Product itemProduct : list) {
//                System.out.println("ID продукта - " + itemProduct.getId() +
//                        "; Название продукта - " + itemProduct.getName() +
//                        "; Цена продукта - " + itemProduct.getPrice() +
//                        "; Дата добавление продкта - " + itemProduct.getAddDate() +
//                        "; Дата обновления товара - " + itemProduct.getUpdDate());
//            }
        }
    }

    public void SortedProductByDateAddDesc() {
//        ArrayList<Product> list = getMapCatalogProducts();
        List<Product> list = getCatalogProducts();

        if (list.size() == 0) {
            System.out.println("Каталог продуктов пуст");
        } else {

            list.stream()
                    .sorted(Comparator.comparing(Product::getAddDate))
                    .forEach(itemProduct -> System.out.println("ID продукта - " + itemProduct.getId() +
                            "; Название продукта - " + itemProduct.getName() +
                            "; Цена продукта - " + itemProduct.getPrice() +
                            "; Дата добавление продкта - " + itemProduct.getAddDate() +
                            "; Дата обновления товара - " + itemProduct.getUpdDate()));

//            list.sort((o1, o2) -> o1.getAddDate().compareTo(o2.getAddDate()));
//
//            for (Product itemProduct : list) {
//                System.out.println("ID продукта - " + itemProduct.getId() +
//                        "; Название продукта - " + itemProduct.getName() +
//                        "; Цена продукта - " + itemProduct.getPrice() +
//                        "; Дата добавление продкта - " + itemProduct.getAddDate() +
//                        "; Дата обновления товара - " + itemProduct.getUpdDate());
//            }
        }
    }

    public void outputOrderPriority() {
//        ArrayList<Product> list = getMapCatalogProducts();
        List<Product> list = getCatalogProducts();

        if (list.size() == 0) {
            System.out.println("Каталог продуктов пуст");
        } else {

            //нагугленный метод, окаывается проще вывести в обратном порядке список
            ListIterator<Product> listIterator = list.listIterator(list.size());
            Stream.iterate(listIterator.previous(), i -> listIterator.previous()).limit(list.size())
                    .forEach(item -> System.out.println("ID продукта - " + item.getId() +
                            "; Название продукта - " + item.getName() +
                            "; Цена продукта - " + item.getPrice() +
                            "; Дата доваления продукта - " + item.getAddDate() +
                            "; Дата обновления продукта - " + item.getUpdDate()));

//            for (int i = list.size() - 1; i >= 0; i--) {
//                System.out.println("ID продукта - " + list.get(i).getId() +
//                        "; Название продукта - " + list.get(i).getName() +
//                        "; Цена продукта - " + list.get(i).getPrice() +
//                        "; Дата доваления продукта - " + list.get(i).getAddDate() +
//                        "; Дата обновления продукта - " + list.get(i).getUpdDate());
//            }
        }
    }
}