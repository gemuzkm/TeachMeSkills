package com.lesson12dz;

import java.util.HashMap;
import java.util.Map;

public class Store {
    private HashMap<Integer, Product> allProduct = new HashMap<>();
    private int idAllProduct = 0;

    public void addProduct(Product product) {
        if (allProduct.size() == 0) {
            allProduct.put(idAllProduct, product);
            idAllProduct++;
            System.out.println("Продукт добавлен успешно!");
        } else if (getIdProduct(product) == -1) {
            allProduct.put(idAllProduct, product);
            idAllProduct++;
            System.out.println("Продукт добавлен успешно!");
        } else {
            System.out.println("Продукт не добавлен! Товар с таким \"ID\" уже существует");
        }
    }

    public HashMap<Integer, Product> getAllProduct() {
        return allProduct;
    }

    public void removeProduct(int IdProduct) {
        if (allProduct.size() == 0) {
            System.out.println("\nУдаление невозможно, каталог пуст");
        } else if (getIdProduct(new Product(IdProduct, "0", 0)) == -1) {
            System.out.println("\nУдаление невозможно, продукта с ID = " + IdProduct + " нет в каталоге");
        }
    }

    // вернет -1, если нет продукта в списке или ID продукта в списке
    private int getIdProduct(Product product) {
        for (Map.Entry<Integer, Product> item : allProduct.entrySet()) {
            if (item.getValue().getId() == product.getId()) {
                return item.getKey();
            }
        }
        return -1;
    }


}
