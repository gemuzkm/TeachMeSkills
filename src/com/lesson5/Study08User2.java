package com.lesson5;

//область видимости

public class Study08User2 {
    public static void main(String[] args) {
        User2 user = new User2();
        System.out.println(user.isBootbal);
        System.out.println(user.foot);
        System.out.println(user.name);
 //       System.out.println(user.age);
        System.out.println(user.getAge());
    }
}
