package com.lesson10dz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeUserForTest {
    private String name;
    private String typeCard;
    private String numberCard;
    private int quantityMoney;

     BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public User getUser() {
        try {
            System.out.println("Введи имя владельца карты:");
            name = reader.readLine().trim();

            System.out.println("Введи тип карты (Visa, Mastercard, Belcard)");
            typeCard = reader.readLine().trim().toUpperCase();

            System.out.println("Введите номер карты: (пример: 1111-1111-1111-1111)");
            numberCard = reader.readLine().trim();

            System.out.println("Введите количество вредство на карте: (только тип INT)");
            quantityMoney = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        User user = new User(name);
        Card card = new Card(typeCard, numberCard, quantityMoney);

        return user;

    }

}
