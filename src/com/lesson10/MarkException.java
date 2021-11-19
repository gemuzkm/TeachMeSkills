package com.lesson10;

public class MarkException extends Exception {
    public MarkException() {
        System.out.println("Марки нет");
    }

    public MarkException(String message) {
        super(message);
    }

    public MarkException(String message, Throwable cause) {
        super(message, cause);
    }

    public MarkException(Throwable cause) {
        super(cause);
    }

    protected MarkException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
