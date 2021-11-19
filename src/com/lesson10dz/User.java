package com.lesson10dz;

public class User {
    private String name;
    private Card card;

    public User(String name, Card card) {
        this.name = name;
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public Card getCard() {
        return card;
    }
}
