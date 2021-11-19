package com.lesson10;

public class CarMain {
    public static void main(String[] args) {

        User userAlex = new User("Alex", 160, 1000, "Audi");
        User userAli = new User("Ali", 160, 20000, "BMW");
        User userMiha = new User("Miha", 160, 30000, "Mazda");
        User userMax = new User("Max", 160, 30000, "Vaz");

        Car audi = new Car(15000, 160, "Audi");
        Car bmw = new Car(15000, 200, "BMW");
        Car volvo = new Car(15000, 160, "Volvo");
        Car vaz = new Car(15000, 60, "Vaz");

        userAlex.buyCar(audi);
        userAli.buyCar(bmw);
        userMiha.buyCar(volvo);
        userMax.buyCar(vaz);

    }
}
