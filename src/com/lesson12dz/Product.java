package com.lesson12dz;

import java.time.LocalDateTime;

public class Product {
    private int id;
    private String name;
    private int price;
    private LocalDateTime addData;
    private LocalDateTime updData;

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
        addData = LocalDateTime.now();
        updData = LocalDateTime.now();
    }

    public Product(int id, String name, int price, LocalDateTime addData, LocalDateTime updData) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.addData = addData;
        this.updData = updData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDateTime getAddData() {
        return addData;
    }

    public void setAddData(LocalDateTime addData) {
        this.addData = addData;
    }

    public LocalDateTime getUpdData() {
        return updData;
    }

    public void setUpdData(LocalDateTime updData) {
        this.updData = updData;
    }
}
