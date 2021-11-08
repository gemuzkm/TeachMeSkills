package com.lesson6dz;

public class Truck extends Land {
    private int loadCapacity;
    private int power;
    private double fuelСonsumption;

    public Truck(int power, int maxSpeed, double weight, String brand, int numberOfWheels, double fuelСonsumption, int loadCapacity) {
        super(power, maxSpeed, weight, brand, numberOfWheels, fuelСonsumption);
        this.loadCapacity = loadCapacity;
        this.power = power;
        this.fuelСonsumption = fuelСonsumption;
    }

    public void loadGood(int loadCapacity) {
        if (this.loadCapacity >= loadCapacity && loadCapacity >= 0) {
            System.out.println("Грузовик загружен");
        } else {
            System.out.println("Вам нужен грузовик побольше");
        }
    }

    private double powerKw(int power) {
        return (double) power * 0.74;
    }

    public void description() {
        String outDescriptionKw = "Мощность (в кВт) = " + powerKw(this.power) +
                " кВт, " + super.toString() +
                ", Расход топлива (л/100км) = " + this.fuelСonsumption +
                ", Грезуподъемность = " + this.loadCapacity + " т";

        System.out.println(outDescriptionKw);
    }
}
