package com.lesson17dz;

public class Card {
    private String cardNumber;
    private int totalMoney;
    private Human human;

    public Card(String cardNumber, int totalMoney) {
        this.cardNumber = cardNumber;
        this.totalMoney = totalMoney;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human human) {
        this.human = human;
    }
}
