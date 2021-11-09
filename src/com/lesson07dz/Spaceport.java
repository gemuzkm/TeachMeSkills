package com.lesson07dz;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

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
