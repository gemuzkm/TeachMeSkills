package com.lesson07dz;

import java.util.Random;

public class SpaceX implements IStart {
    @Override
    public boolean systemСheck() {
        Random random = new Random();
        int inputRandom = random.nextInt(11);

        if (inputRandom > 5) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void engineRun() {
        System.out.println("Двигатели SpaceX запущены. Все системы в норме.");
    }

    @Override
    public void start() {
        System.out.println("Старт SpaceX");
    }
}
