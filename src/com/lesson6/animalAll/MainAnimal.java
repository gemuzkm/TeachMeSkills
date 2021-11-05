package com.lesson6.animalAll;

public class MainAnimal {
    public static void main(String[] args) {
//        Animal animal = new Animal(true, true, 2);
//        System.out.println(animal);
//
//        Fish fish = new Fish(true,true,4);
//        System.out.println(fish);
//        fish.moving();
//        fish.nutrition();

        System.out.println();
        Dolphin dolphin = new Dolphin(true, true, 2, 12);
        System.out.println(dolphin);
        dolphin.moving();
        dolphin.nutrition();

        System.out.println();
        Whale whale = new Whale(true, true, 2);
        System.out.println(whale);
        whale.moving();
        whale.nutrition();

        System.out.println();
        Kangaroo kangaroo = new Kangaroo(true, true, 2, 2);
        System.out.println(kangaroo);
        kangaroo.moving();
        kangaroo.nutrition();

        System.out.println();
        Elephant elephant = new Elephant(true,true, 2);
        System.out.println(elephant);
        elephant.moving();
        elephant.nutrition();
    }
}
