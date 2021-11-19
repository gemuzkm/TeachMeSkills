package com.lesson10;

public class User {
    private String name;
    private double requiredMaxSpeed;
    private double requiredMaxPrice;
    private String mark;

    public User(String name, double requiredMaxSpeed, double requiredMaxPrice, String mark) {
        this.name = name;
        this.requiredMaxSpeed = requiredMaxSpeed;
        this.requiredMaxPrice = requiredMaxPrice;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRequiredMaxSpeed() {
        return requiredMaxSpeed;
    }

    public void setRequiredMaxSpeed(double requiredMaxSpeed) {
        this.requiredMaxSpeed = requiredMaxSpeed;
    }

    public double getRequiredMaxPrice() {
        return requiredMaxPrice;
    }

    public void setRequiredMaxPrice(double requiredMaxPrice) {
        this.requiredMaxPrice = requiredMaxPrice;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void buyCar (Car car) {
        boolean lowMoneyUser = false;
        boolean lowSpeedUser = false;
        boolean notFoundMark = false;

        if (car.getPrice() > requiredMaxPrice) {
            try {
                throw new PriceExcetion();
            } catch (PriceExcetion e) {
                System.out.println(getName() + " мало денег");
            }
        }


    }
}
