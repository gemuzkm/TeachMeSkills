package com.lesson6dz;

public class Civil extends Air {
    private int passengerNumber;
    private boolean businessClass;
    private int power;

    public Civil(int power, int maxSpeed, double weight, String brand, double wingspan, int minimumRunwayLength, int passengerNumber, boolean businessClass) {
        super(power, maxSpeed, weight, brand, wingspan, minimumRunwayLength);
        this.passengerNumber = passengerNumber;
        this.businessClass = businessClass;
        this.power = power;
    }

    private double PowerKw(int power) {
        return (double) power * 0.74;
    }

    public void Description() {

    }
}
