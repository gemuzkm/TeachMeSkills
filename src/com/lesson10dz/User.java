package com.lesson10dz;

public class User {
    private String name;
    private Card card;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "User{" +
                "name=', " + name + '\'' +
                "}, Card{" + "typeCard='" + card.getTypeCard()  + '\'' +
                ", numberCard='" + card.getNumberCard() + '\'' +
                ", totalMoney=" + card.getTotalMoney() +
                '}';
    }
}
