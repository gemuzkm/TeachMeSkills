package com.lesson6dz;

public class Passenger extends Land {
    private String typeBody;
    private int passengerNumber;
    private int power;
    private double fuelСonsumption;
    private int maxSpeed;
    private String brand;

    public Passenger(int power, int maxSpeed, double weight, String brand, int numberOfWheels, double fuelСonsumption, String typeBody, int passengerNumber) {
        super(power, maxSpeed, weight, brand, numberOfWheels, fuelСonsumption);
        this.typeBody = typeBody;
        this.passengerNumber = passengerNumber;
        this.power = power;
        this.fuelСonsumption = fuelСonsumption;
        this.maxSpeed = maxSpeed;
        this.brand = brand;
    }

    private double fuelTime(double inputHour) {
        return inputHour * maxSpeed / 100 * this.fuelСonsumption;
    }

    public void fuelTimeMaxSpeed(double inputHour) {
        double distance = inputHour * maxSpeed;
        double fuel = fuelTime(inputHour);
        System.out.println("За время " + inputHour + " ч, автомобиль " + this.brand + " двигаясь с максимальной скоростью " + this.maxSpeed + " км/ч проедет " + distance +
                " км и израсходует " + fuel + " литров топлива");

    }

    private double powerKw(int power) {
        return (double) power * 0.74;
    }

    public void description() {
        String outDescriptionKw = "Мощность (в кВт) = " + powerKw(power) +
                " кВт, " + super.toString() +
                ", Расход топлива (л/100км) = " + fuelСonsumption +
                ", Тип кузова = " + typeBody +
                ", Количество пассажиров = " + passengerNumber;
        System.out.println(outDescriptionKw);
    }
}
