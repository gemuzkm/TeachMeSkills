package com.lesson7dz;

public class Spaceport  {
    public void start(IStart iStart) throws InterruptedException {
        if (iStart.systemСheck()) {
            iStart.engineRun();
            iStart.countDown();
            iStart.start();
        } else {
            System.out.println("Предстартовая проверка провалена");
        }
    }
}
