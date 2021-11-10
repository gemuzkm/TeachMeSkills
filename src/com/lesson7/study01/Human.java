package com.lesson7.study01;

import java.io.IOException;

public class Human {
    Hat hat = new Hat();
    Pants pants = new Pants();
    Jacket jacket = new Jacket();

    public void hatOn() throws IOException {
        hat.putOn();
    }

    public void hatOff() throws IOException {
        hat.takeOff();
    }

    public void pantsOn() throws IOException {
        pants.putOn();
    }

    public void pantsOff() throws IOException {
        pants.takeOff();
    }

    public void jacketOn() throws IOException {
        jacket.putOn();
    }

    public void jacketOff() throws IOException {
        jacket.takeOff();
    }

}
