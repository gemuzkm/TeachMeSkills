package com.lesson17dz;

public class ATB {
    private boolean isWork;
    private int totalMoney;

    public ATB(boolean isWork, int totalMoney) {
        this.isWork = isWork;
        this.totalMoney = totalMoney;
    }

    public boolean isWork() {
        return isWork;
    }

    public void setWork(boolean work) {
        isWork = work;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public void getBalanceCard(Card card) {
        System.out.println(card.getTotalMoney());
    }

    public void getMoney(Card card) {

    }
}
