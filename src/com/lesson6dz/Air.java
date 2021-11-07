package com.lesson6dz;

public class Air extends Transport {
    private double wingspan;
    private int minimumRunwayLength;

    public Air(int power, int maxSpeed, double weight, String brand, double wingspan, int minimumRunwayLength) {
        super(power, maxSpeed, weight, brand);
        this.wingspan = wingspan;
        this.minimumRunwayLength = minimumRunwayLength;
    }
}
