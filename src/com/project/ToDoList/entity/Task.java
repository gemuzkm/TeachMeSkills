package com.project.ToDoList.entity;

public class Task {
    private int id;
    private String name;
    private int idUser;
    private int status;
    private int idCategory;

    public Task(String name, int idUser, int status, int idCategory) {
        this.name = name;
        this.idUser = idUser;
        this.status = status;
        this.idCategory = idCategory;
    }

    public Task(int id, String name, int idUser, int status, int idCategory) {
        this.id = id;
        this.name = name;
        this.idUser = idUser;
        this.status = status;
        this.idCategory = idCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }
}
