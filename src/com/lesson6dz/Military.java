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

    public void Shot() {
        if (this.numberMissiles > 0) {
            System.out.println("Ракета пошла...");
        } else {
            System.out.println("Боеприпасы отсутствуют");
        }
    }

    public void Ejection() {
        if (this.ejectionSystem) {
            System.out.println("Катапультирование прошло успешно");
        } else {
            System.out.println("У вас нет такой системы");
        }
    }

    private double PowerKw(int power) {
        return (double) power * 0.74;
    }

    public void Description() {
        String outDescriptionKw = "Мощность (в кВт) = " + PowerKw(power) +
                " кВт, " + super.toString() +
                ", Наличие системы катапульты = " + ejectionSystem +
                ", Количество ракет на борту = " + numberMissiles;

        System.out.println(outDescriptionKw);
    }
}
