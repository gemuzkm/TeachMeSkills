package com.lesson07.study01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Jacket extends Clothes {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Random random = new Random();

    private static boolean isNumeric(String str)
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


    @Override
    public void takeOff() throws IOException {
        int inputRandom = random.nextInt(2);
        String inputUser;

        System.out.println("Попытка снять куртку");

        do {
            System.out.println("Введи число 0 или 1");
            inputUser = reader.readLine();

        } while (!isNumeric(inputUser));

        if (inputRandom == Integer.parseInt(inputUser)) {
            System.out.println("Снял куртку");
        } else {
            System.out.println("Не снял куртку");
        }
    }

    @Override
    public void putOn() throws IOException {
        int inputRandom = random.nextInt(2);
        String inputUser;

        System.out.println("Попытка одеть куртку");

        do {
            System.out.println("Введи число 0 или 1");
            inputUser = reader.readLine();

        } while (!isNumeric(inputUser));

        if (inputRandom == Integer.parseInt(inputUser)) {
            System.out.println("Одел куртку");
        } else {
            System.out.println("Не одел куртку");
        }
    }

}
