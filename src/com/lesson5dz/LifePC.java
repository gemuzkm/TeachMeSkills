package com.lesson5dz;

//Логика: Создаем РС. Проделывем циклы жизни, если ошибка с вводом состояния - сгорел,
//если ресурс закончен - сгорел. Все по условиюю далее

import java.io.IOException;

public class LifePC {
    public static void main(String[] args) throws IOException {
        Computer pc = new Computer("Intel i9", 16, 1024, 3);
        pc.Description();

        for (int i = 0; i < 5; i++) {
            pc.powerOn();
            pc.powerOff();
        }
    }
}
