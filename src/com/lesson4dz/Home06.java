package com.lesson4dz;

//Разработать консольную игру крестики-нолики. В игре участвуют 2 игрока.
// Они по очереди вводят координаты клетки в которую хотят сделать ход.
// После каждого хода, в консоли отрисовывается игровое поле с текущим
// состоянием. Игра продолжается до победы одного из игроков или ничьи.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Home06 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[][] area = new int[3][3];
        int x =0;
        int y = 0;
        int count = 0;

        while (true)
        {

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(area[i][j]);
                }
                System.out.println();
            }

            x = Integer.parseInt(reader.readLine());
            y = Integer.parseInt(reader.readLine());

        }

    }
}
