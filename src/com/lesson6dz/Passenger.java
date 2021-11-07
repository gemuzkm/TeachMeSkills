package com.lesson6dz;

public class Passenger extends Land {
    private String typeBody;
    private int passengerNumber;
    private int power;

    public Passenger(int power, int maxSpeed, double weight, String brand, int numberOfWheels, double fuelСonsumption, String typeBody, int passengerNumber) {
        super(power, maxSpeed, weight, brand, numberOfWheels, fuelСonsumption);
        this.typeBody = typeBody;
        this.passengerNumber = passengerNumber;
        this.power = power;
    }

    private double PowerKw(int power) {
        return (double) power * 0.74;
    }

    public void Description() {
        String outDescriptionKw = "Мощность - " + PowerKw(power) + " кВт, ";
        System.out.println( outDescriptionKw + super.toString());
    }
}
