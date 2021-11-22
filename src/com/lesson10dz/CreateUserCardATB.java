package com.lesson10dz;

import java.util.ArrayList;
import java.util.Random;

public class CreateUserCardATB {
    private ArrayList<ATB> listATB = new ArrayList<>();
    private ArrayList<User> listUser = new ArrayList<>();

    private int selectedNumber;
    private Random random = new Random();

    private void greateUserCard() {
        User user0 = new User("User0");
        Card card0 = new Card("Visa", "0000-0000-0000-0000", 1000);
        user0.setCard(card0);
        card0.setUser(user0);

        User user1 = new User("User1");
        Card card1 = new Card("Mastercard", "1111-1111-1111-1111", 1000);
        user1.setCard(card1);
        card1.setUser(user1);

        User user2 = new User("User2");
        Card card2 = new Card("Visa", "2222-2222-2222-2222", 5000);
        user2.setCard(card2);
        card2.setUser(user2);

        User user3 = new User("User3");
        Card card3 = new Card("Belcard", "3333-3333-3333-3333", 1000);
        user3.setCard(card3);
        card3.setUser(user3);

        listUser.add(user0);
        listUser.add(user1);
        listUser.add(user2);
        listUser.add(user3);
    }

    private void greateATB() {
        ATB atbVisaMastercardWork = new ATB(500, true, new String[]{"Visa", "Mastercard"});
        ATB atbVisaMastercardNoWork = new ATB(500, false, new String[]{"Visa", "Mastercard"});
        ATB atbBelcardNoWork = new ATB(500, false, new String[]{"Belcard"});
        ATB atbBelcardWork = new ATB(500, false, new String[]{"Belcard"});

        listATB.add(atbVisaMastercardWork);
        listATB.add(atbVisaMastercardNoWork);
        listATB.add(atbBelcardNoWork);
        listATB.add(atbBelcardWork);
    }

    public ATB getATB() {
        greateATB();
        selectedNumber = random.nextInt(4);
        return listATB.get(selectedNumber);
    }

    public User getUserCard() {
        greateUserCard();
        selectedNumber = random.nextInt(4);
        return listUser.get(selectedNumber);
    }
}
