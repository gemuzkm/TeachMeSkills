package com.project.Calculator;

import java.io.IOException;

public abstract class Menu {
    public abstract void showTitle();
    public abstract void showMenu();
    public abstract void selectMenu() throws IOException;
}
