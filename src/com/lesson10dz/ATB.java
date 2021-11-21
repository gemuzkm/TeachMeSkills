package com.lesson10dz;

import java.util.Arrays;

public class ATB {
    private int totalMoney;
    private boolean isWork;
    private boolean isInsertCard;
    private boolean isCardSupport;
    private String[] listSupportCartType;

    public ATB(int totalMoney, boolean isWork, String[] listSupportCartType) {
        this.totalMoney = totalMoney;
        this.isWork = isWork;
        this.listSupportCartType = listSupportCartType;
    }

    @Override
    public String toString() {
        return "ATB{" +
                "totalMoney=" + totalMoney +
                ", isWork=" + isWork +
                ", listSupportCartType=" + Arrays.toString(listSupportCartType) +
                '}';
    }

    public void getBalanceCard(User user) {
        if (isWork) {
            if (isInsertCard && isCardSupport) {
                System.out.println("\nБаланс карты равен: " + user.getCard().getTotalMoney() + "\n");
            } else {
                System.out.println("\nНеобходимо вставить карту в банкомат для просмотра баланса\n");
            }
        } else {
            System.out.println("\nБанкомат не работае!\n");
        }

    }

    public void insertCard(User user) {
        if (isWork) {
            if (checkSupportCard(user)) {
                isInsertCard = true;
                System.out.println("\nБанкомат принял карту и котов к работе\n");
            }
        } else {
            System.out.println("\nБанкомат не работае!\n");
        }
    }

    private boolean checkSupportCard(User user) {
      for (String item : listSupportCartType) {
            if (item.equals(user.getCard().getTypeCard())) {
                isCardSupport = true;
            }
        }

        if (!isCardSupport) {
            try {
                throw new WrongCardTypeException();
            } catch (WrongCardTypeException e) {
                System.out.println("\n" + user.getName() + " не сможет воспользоваться картой. Она не поддерживается банкоматом.\n");
            }
            finally {
                return isCardSupport;
            }
        }
        return isCardSupport;
    }

    public void getMoney (User user, int howMuchMoney) {
       if (isWork) {
           if (isInsertCard && isCardSupport) {

           }
       } else {
           System.out.println("\nБанкомат не работае!\n");
       }
    }
}
