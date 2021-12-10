package com.lesson16;

import java.util.Date;

public class Person {
    private Date birtday;
    private String firstName;
    private String lastName;

    public Person() {
    }

    public Person(Date birtday, String firstName, String lastName) {
        this.birtday = birtday;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Date getBirtday() {
        return birtday;
    }

    public void setBirtday(Date birtday) {
        this.birtday = birtday;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "birtday=" + birtday +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
