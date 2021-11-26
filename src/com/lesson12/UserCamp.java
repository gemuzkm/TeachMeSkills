package com.lesson12;

//компоратор

public class UserCamp implements Comparable<UserCamp> {
    private int id;
    protected int salary;
    private String name;

    public UserCamp(int id, int salary, String name) {
        this.id = id;
        this.salary = salary;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
// 0 - равны; -1 - первый меньше второго, 1 - первый больше второго
    @Override
    public int compareTo(UserCamp o) {
        return salary;
    }
}
