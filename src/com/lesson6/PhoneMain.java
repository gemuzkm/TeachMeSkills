package com.lesson6;

public class PhoneMain {
    public static void main(String[] args) {
        WirelessPhone wirelessPhone = new WirelessPhone();
        wirelessPhone.call();

        WirePhone wirePhone = new WirePhone();
        wirePhone.call();
    }
}
