package com.lesson07dz;

public class Spaceport  {
    public void start(IStart iStart) throws InterruptedException {
        if (iStart.systemСheck()) {
            iStart.engineRun();
            for (int i = 10; i >=0 ; i--) {
                System.out.println(i);
                Thread.sleep(1000);
            }
            iStart.start();
        } else {
            System.out.println("Предстартовая проверка провалена");
        }
    }
}
