package com.lesson7.study01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Jacket extends Clothes {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Random random = new Random();
    private boolean is;
    private int inputRandom;

    private boolean isNumeric(String str)
    {
        try
        {
            int d = Integer.parseInt(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    private void doOnOff (String item, boolean onOrOff) throws IOException {
        inputRandom = random.nextInt(2);
        String inputUser;

        if (onOrOff) {
            System.out.println("Попытка одеть " + item);
        } else {
            System.out.println("Попытка снять " + item);
        }

        do {
            System.out.println("Введи число 0 или 1");
            inputUser = reader.readLine();

        } while (!isNumeric(inputUser) || Integer.parseInt(inputUser) != 1 && Integer.parseInt(inputUser) != 0);

        if (inputRandom == Integer.parseInt(inputUser)) {
            if (onOrOff) {
                System.out.println("Одел " + item);
            } else {
                System.out.println("Снял " + item);
            }
        } else {
            if (onOrOff) {
                System.out.println("Не одел " + item);
            } else {
                System.out.println("Не снял " + item);
            }
        }
    }


    @Override
    public void takeOff() throws IOException {
        doOnOff("Куртку", false);
    }

    @Override
    public void putOn() throws IOException {
        doOnOff("Куртку", true);
    }
}
