package com.lesson12;

import java.util.Comparator;

public class UserCompoeator implements Comparator<UserCamp> {
    @Override
    public int compare(UserCamp o1, UserCamp o2) {
        if (o1.getSalary() > o2.salary) {
            return 1;
        } else if (o1.getSalary() < o2.salary) {
            return -1;
        } else {
            return 0;
        }
    }
}
