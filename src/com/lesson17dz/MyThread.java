package com.lesson17dz;

import java.util.Random;

public class MyThread implements Runnable {
    private ATB atb;
    private Card card;

    public MyThread(ATB atb, Card card) {
        this.atb = atb;
        this.card = card;
    }

    @Override
    public void run() {
        Random random = new Random();
        int count = 0;
        for (int i = 0; i < 3; i++) {

            count = random.nextInt(4000);
            atb.getMoney(card, count);

            count = random.nextInt(2000);
            atb.addMoney(card, count);

        }
    }
}
