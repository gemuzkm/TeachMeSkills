package com.lesson12dz;

import java.util.*;

public class Store {
    private HashMap<Integer, Product> listOfProducts = new HashMap<>();
    private int idListOfProducts = 0;

    public void addProduct(Product product) {
        if (listOfProducts.size() == 0) {
            listOfProducts.put(idListOfProducts, product);
            idListOfProducts++;
            System.out.println("Продукт добавлен успешно!");
        } else if (getIdProduct(product) == -1) {
            listOfProducts.put(idListOfProducts, product);
            idListOfProducts++;
            System.out.println("Продукт добавлен успешно!");
        } else {
            System.out.println("Продукт не добавлен! Товар с таким \"ID\" уже существует");
        }
    }

    public List<Product> getListOfProducts() {
        ArrayList<Product> catalogProduct = new ArrayList<>();

        for (Map.Entry<Integer, Product> item : listOfProducts.entrySet()) {
            catalogProduct.add(item.getValue());
        }
        return catalogProduct;
    }

    public void removeProduct(int idProduct) {
        if (listOfProducts.size() == 0) {
            System.out.println("\nУдаление невозможно, каталог пуст");
        } else if (getIdProduct(idProduct) == -1) {
            System.out.println("\nУдаление невозможно, продукта с ID = " + idProduct + " нет в каталоге");
        } else if (true) {
            int idRemoveCatalog = getIdProduct(idProduct);
            listOfProducts.remove(idRemoveCatalog);
            System.out.println("\nПродукт с ID = " + idProduct + " успешно удален из каталога");
        }
    }

    public void editProduct(Product newProduct) {
        int idCatalog = getIdProduct(newProduct);
        if (idCatalog == -1) {
            System.out.println("\nПродукта с таким ID не существует");
        } else {
            listOfProducts.put(idCatalog, newProduct);
            System.out.println("\nДанные продукта с ID = " + newProduct.getId() + " успешно обновлены");
        }
    }

    // вернет -1, если нет продукта в списке или ID продукта в списке
    private int getIdProduct(Product product) {
        for (Map.Entry<Integer, Product> itemCatalog : listOfProducts.entrySet()) {
            if (itemCatalog.getValue().getId() == product.getId()) {
                return itemCatalog.getKey();
            }
        }
        return -1;
    }

    // вернет -1, если нет продукта в списке или ID продукта в списке
    private int getIdProduct(int idProduct) {
        for (Map.Entry<Integer, Product> itemCatalog : listOfProducts.entrySet()) {
            if (itemCatalog.getValue().getId() == idProduct) {
                return itemCatalog.getKey();
            }
        }
        return -1;
    }
}
