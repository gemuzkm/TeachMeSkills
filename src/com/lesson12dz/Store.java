package com.lesson12dz;

import java.util.*;

public class Store {
    private HashMap<Integer, Product> mapCatalogProducts = new HashMap<>();
    private int idMapProduct = 0;

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
}