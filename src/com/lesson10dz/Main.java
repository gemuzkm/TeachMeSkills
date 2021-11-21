package com.lesson10dz;

import com.lesson10.Car;

/*
Создать класс ATM. У него будут поля
- общее количество денег
- работает ли банкомат
- принимаемые типы карт (список или массив)

Создать класс Card. Поля
- тип карты
- номер карты
- владелец (User.name)
- количество средств

Создать класс User. Поля
- имя
- Card

Описать следующую логику:
Когда пользователь вставляет карту в банкомат, должна быть проверка на принимаемый тип карты.
Эта проверка реализовывается в классе ATM. Если нет совпадений по типу, бросить свою собственную ошибку WrongCardTypeException.

В банкомате должно быть функции выбора операции, это, например, снять деньги, посмотреть оставшиеся средства, закончить работу.
При снятии денег должна быть проверка, что деньги в банкомате есть. Если не хватает, бросить свою собственную ошибку LackMoneyException

 */
public class Main {
    public static void main(String[] args) {

        ATB atbVisaMastercardWork = new ATB(500, true, new String[]{"Visa", "Mastercard"});
        ATB atbVisaMastercardNoWork = new ATB(500, false, new String[]{"Visa", "Mastercard"});
        ATB atbBelcardNoWork = new ATB(500, false, new String[]{"Belcard"});
        ATB atbBelcardWork = new ATB(500, false, new String[]{"Belcard"});

        MakeUserForTest makeUserForTest = new MakeUserForTest();

//        User userAlex = new User("Alex");
//        Card cardAlex = new Card("Visa", "8888-7777-6666-5555", 5_000);




    }
}
