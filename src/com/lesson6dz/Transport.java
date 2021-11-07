package com.lesson6dz;

public class Transport {
    private int power;
    private int maxSpeed;
    private double weight;
    private String brand;

    public Transport(int power, int maxSpeed, double weight, String brand) {
        this.power = power;
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return  "Мощность = " + power + " л.с." +
                ", Максимальная скорость = " + maxSpeed + " км/ч" +
                ", Масса = " + weight + " кг" +
                ", Марка = " + brand;
    }
}
