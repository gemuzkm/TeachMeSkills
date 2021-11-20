package com.lesson10dz;

public class Card {
    private String typeCard;
    private String numberCard;
    private User user;
    private int totalMoney;

    public Card(String typeCard, String numberCard, User user, int totalMoney) {
        this.typeCard = typeCard;
        this.numberCard = numberCard;
        this.user = user;
        this.totalMoney = totalMoney;
    }

    public Card(String typeCard, String numberCard, int totalMoney) {
        this.typeCard = typeCard;
        this.numberCard = numberCard;
        this.totalMoney = totalMoney;
    }

    public Card(User user) {
        this.user = user;
    }

    public String getTypeCard() {
        return typeCard;
    }

    public String getNumberCard() {
        return numberCard;
    }

    public User getUser() {
        return user;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
