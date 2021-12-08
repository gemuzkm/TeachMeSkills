package com.lesson15dz;

/*
1) Написать регулярное выражение для проверки правильности ввода номера телефона.
Проводить проверку по следующему шаблону
+375(29)123-12-12
 */

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Home1 {
    public static void main(String[] args) {
        List<String> listTel = new ArrayList<>();
        listTel.add("+375(29)123-12-12");
        listTel.add("375(29)123-12-12");
        listTel.add("+375(29)123-1212");
        listTel.add("+375(29)12312-12");
        listTel.add("+375(29)1231212");
        listTel.add("+375(29123-12-12");
        listTel.add("+37529)123-12-12");
        listTel.add("+37529123-12-12");
        listTel.add("+375(25)123-80-11");
        listTel.add("+375(44)123-80-11");
        listTel.add("+375(33)123-80-11");

        Pattern patternTel = Pattern.compile("^\\+375\\((25|29|33|44)\\)\\d{3}-\\d{2}-\\d{2}");

        for (String itemTel: listTel) {
            Matcher matcher = patternTel.matcher(itemTel);
            if (matcher.find()) {
                System.out.println(itemTel);
            }
        }
    }
}
