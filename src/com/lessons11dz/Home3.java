package com.lessons11dz;

/*
3) Проверка на цензуру:
Создаете 2 файла.
1 - й. Содержит исходный текст.
2 - й. Содержит слова недопустимые в тексте(black list). Структура файла определите сами, хотите каждое слово
на новой строке, хотите через запятую разделяйте, ваша программа делайте как считаете нужным.
Задача: необходимо проверить проходит ли текст цензуру. Если в тексте не встретилось ни одного недопустимого слова,
то выводите сообщение о том что текст прошёл проверку на цензуру. Если нет, то выводите соответствуюущее сообщение,
кол-во предложений не прошедших проверку и сами предложения подлежащие исправлению.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Home3 {
    public static void main(String[] args) {
        boolean isBlack = false;

        try (BufferedReader reader1 = new BufferedReader(new FileReader("home3text.txt"));
             BufferedReader reader2 = new BufferedReader(new FileReader("home3blacklist.txt"))) {
            String allWorld = "";
            String allWorldBlack = "";

            while (reader1.ready()) {
                allWorld += reader1.readLine();
            }

            while (reader2.ready()) {
                allWorldBlack += reader2.readLine();
            }


            String[] arrayWorld = allWorld.split(".");


        } catch (IOException e) {

        }
    }

    public static boolean isBlackWorld (String str, String[] strBlack) {

    }
}
