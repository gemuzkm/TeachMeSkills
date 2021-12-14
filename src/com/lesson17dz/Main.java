package com.lesson17dz;

public class Main {
    public static void main(String[] args) {
        ATB atb1 = new ATB(true, 1000);
        ATB atb2 = new ATB(false, 5000);
        ATB atb3 = new ATB(true, 10000);

        Human human1 = new Human("human1");
        Human human2 = new Human("human2");
        Human human3 = new Human("human3");

        Card card1 = new Card("1111-1111-1111-1111", 1500);
        Card card2 = new Card("2222-2222-2222-2222", 4500);
        Card card3 = new Card("3333-3333-3333-3333", 10000);

        human1.setCard(card1);
        card1.setHuman(human1);

        human2.setCard(card2);
        card2.setHuman(human2);

        human3.setCard(card3);
        card3.setHuman(human3);

        MyThread myThread1 = new MyThread(atb3, card1);
        Thread thread1 = new Thread(myThread1);
        thread1.start();

        MyThread myThread2 = new MyThread(atb3, card2);
        Thread thread2 = new Thread(myThread2);
        thread2.start();

        MyThread myThread3 = new MyThread(atb3, card3);
        Thread thread3 = new Thread(myThread3);
        thread3.start();
    }
}
