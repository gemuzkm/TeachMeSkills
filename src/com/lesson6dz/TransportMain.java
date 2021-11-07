package com.lesson6dz;

public class TransportMain {
    public static void main(String[] args) {
        Passenger passengerBmw = new Passenger(100, 160, 2000,"BMW", 4, 5.6,"Sedan",4);
        passengerBmw.Description();
        passengerBmw.FuelTimeMaxSpeed(2.5);

        Truck truckVolvo = new Truck(600, 100, 12000, "Volvo", 12, 25, 15);
        truckVolvo.Description();
        truckVolvo.LoadGood(3);
        truckVolvo.LoadGood(20);

        Civil civilAirBus = new Civil(1500, 950, 40000, "AirBus", 40, 1500, 320, true);
        civilAirBus.Description();
        civilAirBus.PassengerGood(160);
        civilAirBus.PassengerGood(400);

        Military militarySy27 = new Military(400, 1200, 5000, "СУ-27", 10, 250, true, 18);
        militarySy27.Description();
        militarySy27.Shot();
        militarySy27.Ejection();

        Military militarySy271 = new Military(400, 1200, 5000, "СУ-271", 10, 250, false, 0);
        militarySy271.Description();
        militarySy271.Shot();
        militarySy271.Ejection();
    }
}
