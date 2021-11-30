package com.lesson13;

import java.util.ArrayList;
import java.util.List;

public class LambdaCalculator {
    public static void main(String[] args) {
        MyInterface2 mSum = (q, w) -> q + w;
        MyInterface2 mDiff = (q, w) -> q - w;
        MyInterface2 mMul = (q, w) -> q * w;
        MyInterface2 mDiv = (q, w) -> q / w;

        System.out.println(mSum.action(5, 10));
        System.out.println(mDiff.action(5, 10));
        System.out.println(mMul.action(5, 10));
        System.out.println(mDiv.action(10, 5));

        MyInterface2 myInterface2 = (q, w) -> {
          List<Integer> list = new ArrayList<>();
         list.add(q);
         list.add(w);
         for (Integer item: list) {
             System.out.println(item);
         }
        return 0; //на основе старого, и лишний ноль
        };

        System.out.println(myInterface2.action(10, 50));

        // типихированный интерфейс MyInterface4
        MyInterface4<Integer>  myInterface4 = (value) -> System.out.println(value);

        MyIntarface3 myIntarface3 = () -> {
            List<Integer> list2 = new ArrayList<>();
            list2.add(5);
            list2.add(6);
            for (Integer item : list2) {
                myInterface4.action(item);
            }
        };

        myIntarface3.action();
    }
}
