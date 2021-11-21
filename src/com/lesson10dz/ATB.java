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

    private boolean checkSupportCard(User user) {
        boolean isCardSupport = false;

        for (String item: list) {
            if (item.equals(user.getCard())) {
                isCardSupport = true;
            }
        }

        if (!isCardSupport) {
            try {
                throw new WrongCardTypeException();
            } catch (WrongCardTypeException e) {
                System.out.println(user.getName() + " не сможет воспользоваться картой. Она не поддерживается банкоматом.");
            }
            finally {
                return isCardSupport;
            }
        }

        return isCardSupport;
    }

    private boolean checkIsWorkATB() {
        if (isWork) {
            System.out.println("Банкомат работает.");
            return true;
        } else {
            System.out.println("Банкомат не работает.");
            return false;
        }
    }

    public void getMoney (User user, int howMuchMoney) {
       if (!checkIsWorkATB()) {
           if (!checkSupportCard(user)) {

           }
       }

    }



}
