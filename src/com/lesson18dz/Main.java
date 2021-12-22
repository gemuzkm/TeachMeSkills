package com.lesson18dz;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/northwind?useUnicode=true&serverTimezone=UTC";
        String name = "root";
        String password =  "admin";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, name, password)) {
                Statement statement = connection.createStatement();

//                statement.execute("create table Customers(" +
//                        "CustomerID int auto_increment primary key," +
//                        "CustomerName varchar(50) not null," +
//                        "ContactName varchar(50) not null," +
//                        "Address varchar(50) not null, " +
//                        "City varchar(30) not null, " +
//                        "PostalCode varchar(30) not null," +
//                        "Country varchar(30) not null" +
//                        ")");


            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
