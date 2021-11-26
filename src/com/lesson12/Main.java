package com.lesson12;

//Generic

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        Account<Integer> account1 = new Account<>(5, "123");
//        Account<String> account2 = new Account<>("345", "asd0");
        Account<String, Integer> account = new Account<>("asd", 214);


        ArrayList<UserCamp> userCamps = new ArrayList<>();
        userCamps.sort(new UserCompoeator());
    }
}
