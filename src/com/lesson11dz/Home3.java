package com.lesson11dz;

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
import java.util.ArrayList;

public class Home3 {
    public static void main(String[] args) {
        int countBlack = 0;
        String[] arrayWorld;
        ArrayList<String> listBlackWord = new ArrayList<>();

        try (BufferedReader reader1 = new BufferedReader(new FileReader("src/com/lessons11dz/home3Text.txt"));
             BufferedReader reader2 = new BufferedReader(new FileReader("src/com/lessons11dz/home3BlackList.txt"))) {
            String allText = "";

            while (reader1.ready()) {
                allText += reader1.readLine();
            }

            while (reader2.ready()) {
                listBlackWord.add(reader2.readLine());
            }

            arrayWorld = allText.split("\\.");

            for (String itemStr : arrayWorld) {
                if (blackWordСontainedInText(itemStr, listBlackWord)) {
                    countBlack++;
                    System.out.println(itemStr.trim() + "."); // с новой строки, для наглядности
                }
            }

            if (countBlack == 0) {
                System.out.println("Текст прошел проверку");
            } else {
                System.out.println("Количество предложений не прошедших проверку: " + countBlack);
            }
        } catch (IOException e) {

        }
    }

    public static boolean blackWordСontainedInText(String str, ArrayList<String> listStrBlack) {
        String[] arraySrt = str.trim().split(" ");
        for (int i = 0; i < arraySrt.length; i++) {
            for (String blackWord : listStrBlack) {
                if (arraySrt[i].equals(blackWord)) {
                    return true;
                }
            }
        }
        return false;
    }
}
