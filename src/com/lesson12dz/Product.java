package com.lesson12dz;

import java.time.LocalDateTime;

public class Product {
    private int id;
    private String name;
    private int price;
    private LocalDateTime addDate;
    private LocalDateTime updDate;

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
        addDate = LocalDateTime.now();
        updDate = LocalDateTime.now();
    }

    public Product(int id, String name, int price, LocalDateTime addDate, LocalDateTime updDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.addDate = addDate;
        this.updDate = updDate;
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

    public LocalDateTime getAddDate() {
        return addDate;
    }

    public void setAddDate(LocalDateTime addDate) {
        this.addDate = addDate;
    }

    public LocalDateTime getUpdDate() {
        return updDate;
    }

    public void setUpdDate(LocalDateTime updDate) {
        this.updDate = updDate;
    }
}
