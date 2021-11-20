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

    public void buyCar(Car car) {
        boolean lowMoneyUser = true;
        boolean lowSpeedUser = true;
        boolean notFoundMark = true;

        if (getMark().equals(car.getMark())) {
            notFoundMark = false;
        }

        if (getRequiredMaxSpeed() <= car.getMaxSpeed()) {
            lowSpeedUser = false;
        }

        if (getRequiredMaxPrice() > car.getPrice()) {
            lowMoneyUser = false;
        }

        if (!lowMoneyUser && !lowSpeedUser && !notFoundMark) {
            System.out.println(getName() + " может купить " + getMark() + " за " + car.getPrice());
        }

        if (car.getPrice() > requiredMaxPrice) {
            try {
                throw new PriceExcetion();
            } catch (PriceExcetion e) {
                System.out.println(getName() + " мало денег");
            }
        }

        if (notFoundMark) {
            try {
                throw new MarkException();
            } catch (MarkException e) {
                System.out.println(getName() + " не может купить " + getMark() + " машины, ее нет в продаже");
            }
        }

        if (lowSpeedUser) {
            try {
                throw new SpeedException();
            } catch (SpeedException e) {
                System.out.println(getName() + " не может купить " + car.getMark() + " низкая максимальная скорость");
            }
        }


    }
}
