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

    @Override
    public String toString() {
        return "ATB{" +
                "isWork=" + isWork +
                ", totalMoney=" + totalMoney +
                '}';
    }

    public void getMoney(Card card, int countMoney) {
        synchronized (card) {
            if (!isWork) {
                System.out.println("\nБанкомат не работает\n");
            } else if (card.getTotalMoney() < countMoney) {
                System.out.println("\nНедостаточно средств на счету");
                System.out.println(card.toString() + " " + toString());
                System.out.println("Попытка снять - " + countMoney + "\n");
            } else if (getTotalMoney() < countMoney) {
                System.out.println("\nНедостаточно средства в банкомате");
                System.out.println(card.toString() + " " + toString());
                System.out.println("Попытка снять - " + countMoney + "\n");
            } else {
                System.out.println("\n" + card.toString() + " " + toString());

                card.setTotalMoney(card.getTotalMoney() - countMoney);
                setTotalMoney(getTotalMoney() - countMoney);

                System.out.println("Вы сняли - " + countMoney + "");
                System.out.println(card.toString() + " " + toString() + "\n");
            }
        }
    }

    public void addMoney(Card card, int countMoney) {
        synchronized (card) {
            if (!isWork) {
                System.out.println("\nБанкомат не работает");
            } else {
                System.out.println("\n" + card.toString() + " " + toString());
                System.out.println("Пополнение на - " + countMoney);

                card.setTotalMoney(card.getTotalMoney() + countMoney);
                setTotalMoney(getTotalMoney() + countMoney);

                System.out.println(card.toString() + " " + toString() + "\n");
            }
        }
    }
}
