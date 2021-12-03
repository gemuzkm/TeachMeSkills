package com.lesson14;

import java.util.Optional;

public class Study1 {
    public static void main(String[] args) {
        Optional<Integer> optional = Optional.empty();
        //Optional<Integer> optional = Optional.ofNullable(5);
        if (optional.isPresent()) {
             Integer velue = optional.get();
            System.out.println(velue);
        } else {
            System.out.println("Пусто");
        }

        System.out.println(optional.orElse(6));
        System.out.println(optional.isPresent());
        System.out.println(optional.orElseGet(() -> 7));
     //   System.out.println(optional.orElseThrow(Exception::new));



    }
}
