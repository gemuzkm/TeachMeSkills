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

    public void passengerGood(int passengerNumber) {
        if (this.passengerNumber >= passengerNumber && passengerNumber >= 0) {
            System.out.println("Самолет загружен");
        } else {
            System.out.println("Вам нужен самолет побольше");
        }
    }

    private double powerKw(int power) {
        return (double) power * 0.74;
    }

    public void description() {
        String outDescriptionKw = "Мощность (в кВт) = " + powerKw(power) +
                " кВт, " + super.toString() +
                ", Количество пассажиров = " + passengerNumber +
                ", Наличие безнес класса = " + businessClass;

        System.out.println(outDescriptionKw);
    }
}
