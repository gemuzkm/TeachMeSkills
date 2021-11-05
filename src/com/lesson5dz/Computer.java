package com.lesson5dz;

//ДЗ практика.
//Создать класс Компьютер.
//Класс должен иметь следующие поля
//- процессор
//- оперативка
//- жесткий диск
//- ресурс полных циклов работы (включение/выключение)
//Методы:
//- метод описание(вывод всех полей)
//- метод включить, при включении может произойти сбой, при вывзове метода рандом загадывает число (0 либо 1), вы вводите число с клавиатуры,
// если угадали комп включается, если нет сгорает.Если комп сгорел, при попытке включить нужно выдать сообщение что ему конец
//- выключить (аналогично включению)
//- при превышении лимита ресурса комп сгорает

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Computer {
    private String cpu;
    private int ram;
    private int hdd;
    private int resource;
    private boolean state = true; //true - работает, false - сбой

    Random random = new Random();

    public Computer(String cpu, int ram, int hdd, int resource) {
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
        this.resource = resource;
    }

    private String readerStringConsole() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputData = reader.readLine();
//        reader.close();
        return inputData;
    }

    public boolean getState() {
        return state;
    }

    private void KillPc() {
        System.out.println("Комп сгорел. Ему конец.");

    }

    public void Description() {
        System.out.println("PC: \nCPU - " + cpu + ", \nRAM: " + ram + " Гб, \nHDD: " + hdd + " Гб, \nРесурс полных циклов работы: " + resource);
    }

    public void powerOn() throws IOException {

        int powerOnCode = random.nextInt(2);
        int powerOnCodeUser;

//        System.out.println("random powerOnCode = " + powerOnCode); // для тестрование
        System.out.println("\nВведите состоние PC(включение):");

        powerOnCodeUser = Integer.parseInt(readerStringConsole());

        if (resource == 0)
        {
            System.out.println("Ресурс исчепан. Комп сломан.");
            state = false;
        }

        if (powerOnCode == powerOnCodeUser && state == true) {

            state = true;

            System.out.println("Комп включился");
        } else {
            state = false;
        }

        if (state == false) {
            KillPc();
        }
    }

    public void powerOff() throws IOException {

        int powerOffCode = random.nextInt(2);
        int powerOffCodeUser;

//      System.out.println("random powerOffCode = " + powerOffCode); // для тестрование
        System.out.println("\nВведите состояние PC(выключение):");

        powerOffCodeUser = Integer.parseInt(readerStringConsole());

        if(powerOffCode == powerOffCodeUser && state == true) {
            resource--;
        } else {
            state = false;
        }

        if (state == false) {
            KillPc();
        }
    }
}