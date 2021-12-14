package com.lesson17;

public class MyThirdThread  implements Runnable{
    private Manager manager;
    private A a;
    private int someValue;

    public MyThirdThread(Manager manager, A a, int someValue) {
        this.manager = manager;
        this.a = a;
        this.someValue = someValue;
    }

    @Override
    public void run() {
        manager.updateAndPrintInfo(a.getArray(), someValue);
    }
}
