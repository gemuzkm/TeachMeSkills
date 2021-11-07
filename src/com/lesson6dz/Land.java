package com.lesson6dz;

public class Land extends Transport {
    private int numberOfWheels;
    private double fuelСonsumption;

    public Land(int power, int maxSpeed, double weight, String brand, int numberOfWheels, double fuelСonsumption) {
        super(power, maxSpeed, weight, brand);
        this.numberOfWheels = numberOfWheels;
        this.fuelСonsumption = fuelСonsumption;
    }
}
