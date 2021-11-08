package com.lesson6dz;

public class TransportMain {
    public static void main(String[] args) {
        Passenger passengerBmw = new Passenger(100, 160, 2000,"BMW", 4, 5.6,"Sedan",4);
        passengerBmw.description();
        passengerBmw.fuelTimeMaxSpeed(2.5);

        System.out.println();
        Truck truckVolvo = new Truck(600, 100, 12000, "Volvo", 12, 25, 15);
        truckVolvo.description();
        truckVolvo.loadGood(3);
        truckVolvo.loadGood(20);

        System.out.println();
        Civil civilAirBus = new Civil(1500, 950, 40000, "AirBus", 40, 1500, 320, true);
        civilAirBus.description();
        civilAirBus.passengerGood(160);
        civilAirBus.passengerGood(400);

        System.out.println();
        Military militarySy27 = new Military(400, 1200, 5000, "СУ-27", 10, 250, true, 18);
        militarySy27.description();
        militarySy27.shot();
        militarySy27.ejection();

        System.out.println();
        Military militarySy271 = new Military(400, 1200, 5000, "СУ-271", 10, 250, false, 0);
        militarySy271.description();
        militarySy271.shot();
        militarySy271.ejection();
    }
}
