package com.lesson12dz;

import java.util.HashMap;
import java.util.Map;

public class Store {
    private HashMap<Integer, Product> allProduct;
    private int idAllProduct;

    public void addProduct(Product product) {
        if (getIdProductFromList(product) == -1) {
            allProduct.put(idAllProduct, product);
            idAllProduct++;
        }
    }

    public HashMap<Integer, Product> getAllProduct() {
        return allProduct;
    }

    public void removeProduct (int IdProduct) {
        int idProductCatalog;
    }

    // вернет -1, если нет продукта в списке или ID продукта в списке
    private int getIdProductFromList(Product product) {
        for (Map.Entry<Integer, Product> item : allProduct.entrySet()) {
            if (item.getValue().getId() == product.getId()) {
                return item.getKey();
            }
        }
        return -1;
    }






}
