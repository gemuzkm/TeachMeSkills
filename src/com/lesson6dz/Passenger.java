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

    private double FuelTime(double inputHourse) {
        return this.fuelСonsumption * inputHourse;
    }

    public void FuelTimeMaxSpeed(double inputHour) {
        double distance = inputHour * maxSpeed;
        double fuel = FuelTime(inputHour);
        System.out.println("За время " + inputHour + " ч, автомобиль " + this.brand + " двигаясь с максимальной скоростью " + this.maxSpeed + " км/ч проедет " + distance +
                " км и израсходует " + fuel + " литров топлива");

    }

    private double PowerKw(int power) {
        return (double) power * 0.74;
    }

    public void Description() {
        String outDescriptionKw = "Мощность (в кВт) = " + PowerKw(power) +
                " кВт, " + super.toString() +
                ", Расход топлива (л/100км) = " + fuelСonsumption +
                ", Тип кузова = " + typeBody +
                ", Количество пассажиров = " + passengerNumber;
        System.out.println(outDescriptionKw);
    }
}
