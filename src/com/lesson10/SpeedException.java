package com.lesson10;

public class SpeedException extends Exception {
    public SpeedException() {
        System.out.println("Скорость");
    }

    public SpeedException(String message) {
        super(message);
    }

    public SpeedException(String message, Throwable cause) {
        super(message, cause);
    }

    public SpeedException(Throwable cause) {
        super(cause);
    }

    protected SpeedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
