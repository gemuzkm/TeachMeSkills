package com.lesson07.study01;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Hat hat = new Hat();
        hat.putOn();
        hat.takeOff();

        Jacket jacket = new Jacket();
        jacket.putOn();
        jacket.takeOff();

        Pants pants = new Pants();
        pants.putOn();
        pants.takeOff();
    }
}
