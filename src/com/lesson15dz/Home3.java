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

        listLine.add("aaaaaaaaaaaaa asd as dasdasdasd1. asdasdasd  asd a sd a sd a sd a s d as d as dasdasdasd2. bbbbbbbbbb asd as dasdasdasd3.");


        Pattern patternFirst = Pattern.compile("^\\S+\\s");
        Pattern patternFirst2 = Pattern.compile("\\.");
        Pattern patternLast = Pattern.compile("\\s\\S+\\.");

        for (String itemLine: listLine) {
            Matcher matcherLine1 = patternFirst.matcher(itemLine.trim());
            while (matcherLine1.find()) {
                System.out.println(matcherLine1.group());
            }

            Matcher matcherLine2 = patternFirst2.matcher(itemLine.trim());
            while (matcherLine2.find()) {
                System.out.println(matcherLine2.group());
            }

            Matcher matcherLast = patternLast.matcher(itemLine.trim());
            while (matcherLast.find()) {
                System.out.println(matcherLast.group().trim().replace(".",""));
            }
        }
    }
}
