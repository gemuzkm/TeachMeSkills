package com.lesson10;

public class CarMain {
    public static void main(String[] args) {

        User userAlex = new User("Alex", 160, 1000, "Audi");
        User userAli = new User("Ali", 160, 10000, "BMW");
        User userMiha = new User("Miha", 160, 10000, "Mazda");

        Car audi = new Car(15000, 140, "Audi");
        Car bmw = new Car(15000, 140, "BMW");
        Car volvo = new Car(15000, 140, "Volvo");

        userAlex.buyCar(audi);


    }
}
