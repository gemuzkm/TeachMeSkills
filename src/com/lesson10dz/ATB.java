package com.lesson10dz;

import java.util.Arrays;

public class ATB {
    private double totalMoneyATB;
    private boolean isWorkATK;
    private boolean isInsertCard;
    private boolean isCardSupport;
    private String[] supportCartType;

    ReaderDataFromConsole readerDataFromConsole = new ReaderDataFromConsole();

    public ATB(int totalMoneyATB, boolean isWorkATK, String[] supportCartType) {
        this.totalMoneyATB = totalMoneyATB;
        this.isWorkATK = isWorkATK;
        this.supportCartType = supportCartType;
    }

    @Override
    public String toString() {
        return "ATB{" +
                "totalMoneyATB=" + totalMoneyATB +
                ", isWork=" + isWorkATK +
                ", listSupportCartType=" + Arrays.toString(supportCartType) +
                '}';
    }

    public void getBalanceCard(User user) {
        if (isWorkATK) {
            if (isInsertCard && isCardSupport) {
                System.out.println("\nБаланс карты равен: " + user.getCard().getTotalMoneyCard() + "\n");
            } else {
                System.out.println("\nНеобходимо вставить карту в банкомат для просмотра баланса\n");
            }
        } else {
            System.out.println("\nБанкомат не работае!\n");
        }

    }

    public void insertCard(User user) {
        if (isWorkATK) {
            if (checkSupportCard(user)) {
                isInsertCard = true;
                System.out.println("\nБанкомат принял карту и котов к работе\n");
            }
        } else {
            System.out.println("\nБанкомат не работае!\n");
        }
    }

    private boolean checkSupportCard(User user) {
        for (String item : supportCartType) {
            if (item.equals(user.getCard().getTypeCard())) {
                isCardSupport = true;
            }
        }

        if (!isCardSupport) {
            try {
                throw new WrongCardTypeException();
            } catch (WrongCardTypeException e) {
                System.out.println("\n" + user.getName() + " не сможет воспользоваться картой. Она не поддерживается банкоматом.\n");
            } finally {
                return isCardSupport;
            }
        }
        return isCardSupport;
    }

    public void getMoney(User user) {
        if (isWorkATK) {
            if (isInsertCard && isCardSupport) {
                System.out.println("\nВведите сумму, которую необходимо снять");
                String howMuchGetMoneyString = readerDataFromConsole.readString();

                while (!readerDataFromConsole.isNumeric(howMuchGetMoneyString)) {
                    System.out.println("\nВведдено не число");
                    System.out.println("Введите сумму, которую необходимо снять");
                    howMuchGetMoneyString = readerDataFromConsole.readString();
                }

                double howMuchGetMoney = Double.parseDouble(howMuchGetMoneyString);

                if (howMuchGetMoney > user.getCard().getTotalMoneyCard()) {
                    System.out.println("Введенна сумма больше суммы на балансе карты\n");
                } else if (totalMoneyATB < howMuchGetMoney) {
                    try {
                        throw new LackMoneyException();
                    } catch (LackMoneyException e) {
                        System.out.println("Недостаточно средст в банкомате\n");
                    }
                } else {
                    System.out.println("Вы сняли: " + howMuchGetMoney + "\n");
                    totalMoneyATB -= howMuchGetMoney;
                    user.getCard().setTotalMoneyCard(user.getCard().getTotalMoneyCard() - howMuchGetMoney);
                }
            } else {
                System.out.println("\nНеобходимо вставить карту в банкомат для снятия\n");
            }
        } else {
            System.out.println("\nБанкомат не работает!\n");
        }
    }
}
