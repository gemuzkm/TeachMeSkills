package com.lesson5dz;

import java.io.IOException;

public class lifePC {
    public static void main(String[] args) throws IOException {
        Computer pc1 = new Computer("Intel i9", 16, 1024, 3);
        pc1.Description();

        for (int i = 0; i < 5; i++) {
            pc1.powerOn();
            pc1.powerOff();
        }
    }
}
