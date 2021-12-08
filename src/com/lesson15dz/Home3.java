package com.lesson15dz;

/*
3) В переменную присвоить какой либо текст на несколько предложений. Написать регулярки,
которые будут находить первые и последние слова предложений
 */

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Home3 {
    public static void main(String[] args) {
        List<String> listLine = new ArrayList<>();

        listLine.add("NachaloTesta1 asd as conecPred1. NachaloPredoj2  asd a sd a sd a sd a s d as d as conecPred2. NachaloPredoj3 asd as conecPred3.");

        Pattern patternFirst = Pattern.compile("((^\\S+\\s)|(\\.\\s\\S+\\s))");
        Pattern patternLast = Pattern.compile("\\S+\\.");

        for (String itemLine: listLine) {
            System.out.println("Первый слова предложений:");
            Matcher matcherLine = patternFirst.matcher(itemLine.trim());
            while (matcherLine.find()) {
                System.out.println(matcherLine.group().replace(".", "").trim());
            }

            System.out.println("\nПосделние слова предложений:");
            Matcher matcherLast = patternLast.matcher(itemLine);
            while (matcherLast.find()) {
                System.out.println(matcherLast.group().replace(".",""));
            }
        }
    }
}
