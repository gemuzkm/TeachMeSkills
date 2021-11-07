package com.lesson6dz;

public class Truck extends Land {
    private int loadCapacity;
    private int power;

    public Truck(int power, int maxSpeed, double weight, String brand, int numberOfWheels, double fuelСonsumption, int loadCapacity) {
        super(power, maxSpeed, weight, brand, numberOfWheels, fuelСonsumption);
        this.loadCapacity = loadCapacity;
        this.power = power;
    }

    private double PowerKw(int power) {
        return (double) power * 0.74;
    }

    public void Description() {

    }
}
