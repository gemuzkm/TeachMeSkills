package com.lesson2;

public class Study00 {
    public static void main(String[] args) {
        int a = 5;
//        // if else block
//        if (a > 10) {
//            System.out.println("A > 10");
//        }
//        else  if (a > 0) {
//            System.out.println("A > 0");
//        }

//        switch block

//        switch (a) {
//            case 5 :
//                System.out.println("a = 5");
//                break;
//            case 2 :
//                System.out.println("a = 2");
//                break;
//            default:
//                System.out.println("Ни одно значение не совпало");
//                break;
//        }
        //ternarnie
//        int b = a == 5 ? 10 : 100;
//        System.out.println(b);

//        int x = 56;
//
//        if (x % 2 == 0) {
//            System.out.println("x четное");
//        } else
//        {
//            System.out.println("х нечетное");
//        }

        int y = 10;

        if (y >= 0 && y < 10)
        {
            System.out.println("1 razr");
        } else if (y >= 10 && y < 100) {
            System.out.println("2 tazr");
        } else if (y >= 100 && y < 1000) {
            System.out.println("3 razr");
        } else {
            System.out.println("no razr");
        }



    }
}
