package com.lesson12;

public class Account<T, R> {
    private T id;
    private R login;

    public Account(T id, R login) {
        this.id = id;
        this.login = login;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public R getLogin() {
        return login;
    }

    public void setLogin(R login) {
        this.login = login;
    }

    public <Z> void print(Z info) {

    }
}
