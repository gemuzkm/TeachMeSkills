package com.lesson10dz;

import java.sql.SQLOutput;
import java.util.Arrays;

public class ATB {
    private double totalMoneyATB;
    private boolean isWork;
    private boolean isInsertCard;
    private boolean isCardSupport;
    private String[] listSupportCartType;

    ReaderDataFromConsole readerDataFromConsole = new ReaderDataFromConsole();

    public ATB(int totalMoneyATB, boolean isWork, String[] listSupportCartType) {
        this.totalMoneyATB = totalMoneyATB;
        this.isWork = isWork;
        this.listSupportCartType = listSupportCartType;
    }

    @Override
    public String toString() {
        return "ATB{" +
                "totalMoneyATB=" + totalMoneyATB +
                ", isWork=" + isWork +
                ", listSupportCartType=" + Arrays.toString(listSupportCartType) +
                '}';
    }

    public void getBalanceCard(User user) {
        if (isWork) {
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
            } finally {
                return isCardSupport;
            }
        }
        return isCardSupport;
    }

    public void getMoney(User user) {
        if (isWork) {
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
