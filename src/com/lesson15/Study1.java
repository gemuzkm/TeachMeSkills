package com.lesson15;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Study1 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\d{3}");
        String text = "abc123def";
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group()  );
        }
    }
}
