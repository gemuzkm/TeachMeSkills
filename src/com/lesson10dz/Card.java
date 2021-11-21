package com.lesson10dz;

public class Card {
    private String typeCard;
    private String numberCard;
    private User user;
    private double totalMoneyCard;

    public Card(String typeCard, String numberCard, int totalMoneyCard) {
        this.typeCard = typeCard;
        this.numberCard = numberCard;
        this.totalMoneyCard = totalMoneyCard;
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

    public double getTotalMoneyCard() {
        return totalMoneyCard;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTotalMoneyCard(double totalMoneyCard) {
        this.totalMoneyCard = totalMoneyCard;
    }

    @Override
    public String toString() {
        return "Card{" +
                "typeCard='" + typeCard + '\'' +
                ", numberCard='" + numberCard + '\'' +
                ", user=" + user +
                ", totalMoney=" + totalMoneyCard +
                '}';
    }
}
