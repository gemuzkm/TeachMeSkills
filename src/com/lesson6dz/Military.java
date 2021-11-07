package com.lesson6dz;

public class Military extends Air {
    private boolean ejectionSystem;
    private int numberMissiles;
    private int power;

    public Military(int power, int maxSpeed, double weight, String brand, double wingspan, int minimumRunwayLength, boolean ejectionSystem, int numberMissiles) {
        super(power, maxSpeed, weight, brand, wingspan, minimumRunwayLength);
        this.ejectionSystem = ejectionSystem;
        this.numberMissiles = numberMissiles;
        this.power = power;
    }

    private double PowerKw(int power) {
        return (double) power * 0.74;
    }

    public void Description() {
        System.out.println("Мощность ");
    }
}
