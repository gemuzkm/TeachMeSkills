package com.project.ToDoList.entity;

public class User {
    private int id;
    private String login;
    private String password;
    private int Role;

    public User(String login, String password, int role) {
        this.login = login;
        this.password = password;
        Role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return Role;
    }

    public void setRole(int role) {
        Role = role;
    }
}
