package com.lesson10;

public class Car {
    private double price;
    private double maxSpeed;
    private String mark;

    public Car(double price, double maxSpeed, String mark) {
        this.price = price;
        this.maxSpeed = maxSpeed;
        this.mark = mark;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
