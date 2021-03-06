package com.lesson4dz;

//Разработать консольную игру крестики-нолики. В игре участвуют 2 игрока.
// Они по очереди вводят координаты клетки в которую хотят сделать ход.
// После каждого хода, в консоли отрисовывается игровое поле с текущим
// состоянием. Игра продолжается до победы одного из игроков или ничьи.
//
// Проверку вводимых дынные не реализовывал (для размера поля, для координат)
// Координа вводить как матрице: Х - это строка, У - это столбел
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class Home06 {

    private static String nameUserOne;
    private static String nameUserTwo;
    private static int size;
    private static int[][] area;

    private static void CreateArea (int size) {
        area = new int[size][size];
    }

    private static void SetPoint(int xPoint, int yPoint, int Point) {
        area[yPoint][xPoint] = Point;
    }

    private static boolean CheckLine (int Point) {
        int cout;

        //line
        for (int i = 0; i < size; i++) {
            cout = 0;
            for (int j = 0; j < size; j++) {
                if (area[i][j] == Point) {
                    cout++;
                }
            }
            if (cout == size) {
                return true;
            }
        }

        //vertical
        for (int i = 0; i < size; i++) {
            cout = 0;
            for (int j = 0; j < size; j++) {
                if (area[j][i] == Point) {
                    cout++;
                }
            }
            if (cout == size) {
                return true;
            }
        }
        return false;
    }

    private static boolean CheckDioganal (int Point) {
        int count = 0;

        //main
        for (int i = 0; i < size; i++) {
            if (area[i][i] == Point) {
                count++;
            }
        }

        if (count == size ) {
            return true;
        }

        count = 0;

        //side
        for (int i = 0; i < size; i++) {
            for (int j = size - i - 1; j >= 0; j--) {
                if (area[i][j] == Point) {
                    count++;
                }
                break;
            }
        }

        if (count == size) {
            return true;
        }
        return false;
    }

    private static boolean CheckPoint (int xPoint, int yPoint) {
        int cout = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (area[i][j] == 0) {
                    cout++;
                }
            }
        }

        if (cout == 0) {
            System.out.println("Конец игры! Нет больше ходов! Нет победителя!");
            System.exit(0);
        }

        int point = area[yPoint][xPoint];

        if (point != 0) {
            System.out.println("Точкак с данными координатами занята, введите новые координаты");
        }
        return point == 0 ? true : false;
    }

    private static String ReaderString () throws IOException {
//        Random random = new Random();
//        return String.valueOf(random.nextInt(3));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();

    }

    private static void UserOne () throws IOException {
        int x;
        int y;

        do {
            System.out.println(nameUserOne + " - введите координату X (от 0 до " + (size - 1) + ")");
            x = Integer.parseInt(ReaderString());
            System.out.println(nameUserOne +  " - введите координату Y (от 0 до " + (size - 1) + ")");
            y = Integer.parseInt(ReaderString());
        } while (!CheckPoint(x,y));

        SetPoint(x, y,1);

        if (CheckLine(1) || CheckDioganal(1)) {
            System.out.println("Победил - " + nameUserOne);
            DrawingFields(size);
            System.exit(0);
        }

    }

    private static void UserTwo () throws IOException {
        int x;
        int y;

        do {
            System.out.println(nameUserTwo + " - введите координату X (от 0 до " + (size - 1) + ")");
            x = Integer.parseInt(ReaderString());
            System.out.println(nameUserTwo +  " - введите координату Y (от 0 до " + (size - 1) + ")");
            y = Integer.parseInt(ReaderString());
        } while (!CheckPoint(x,y));

        SetPoint(x, y, 2);

        if (CheckLine(2) || CheckDioganal(2)) {
            System.out.println("Победил - " + nameUserTwo);
            DrawingFields(size);
            System.exit(0);
        }
    }

    private static void DrawingFields (int input) {
        for (int i = 0; i < input; i++) {
            System.out.println(Arrays.toString(area[i]));
        }
    }

    public static void main(String[] args) throws IOException {

        System.out.println("Ввдите имя первого игрока");
        nameUserOne = ReaderString();
//        nameUserOne = "Игрок 1";

        System.out.println("Введите имя второго игрока");
        nameUserTwo = ReaderString();
//        nameUserTwo = "Игрок 2";

        System.out.println("Введите размер игрового поля 2 или более");
        size = Integer.parseInt(ReaderString());
//        size = 3;

        CreateArea(size);

        while (true)
        {
            DrawingFields(size);
            UserOne();
            DrawingFields(size);
            UserTwo();
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }

    }
}