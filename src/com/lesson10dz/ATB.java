package com.lesson10dz;

public class ATB {
    private int totalMonay;
    private boolean isWork;
    private String[] list;

    public ATB(int totalMonay, boolean isWork, String[] list) {
        this.totalMonay = totalMonay;
        this.isWork = isWork;
        this.list = list;
    }

    private boolean checkCard (User user) {
        boolean isCardSupport = false;

        for (String item: list) {
            if (item.equals(user.getCard())) {
                isCardSupport = true;
            }
        }
        return isCardSupport;
    }



}
