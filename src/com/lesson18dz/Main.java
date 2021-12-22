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

                statement.execute("create table Customers(" +
                        "CustomerID int auto_increment primary key," +
                        "CustomerName varchar(50) not null," +
                        "ContactName varchar(50) not null," +
                        "Address varchar(50) not null, " +
                        "City varchar(30) not null, " +
                        "PostalCode varchar(30) not null," +
                        "Country varchar(30) not null" +
                        ")");

//                statement.execute("insert into Customers(CustomerName, ContactName, Address, City, PostalCode, Country) " +
//                        "values('Alfreds Futterkiste', 'Maria Anders', 'Obere Str. 57', 'Berlin', '12209', 'Germany')");
//
//                statement.execute("insert into Customers(CustomerName, ContactName, Address, City, PostalCode, Country) " +
//                        "values('Ana Trujillo Emparedados y helados', 'Ana Trujillo', 'Avda. de la Constitución 2222', 'México D.F.', '05021', 'Mexico')");
//
//                statement.execute("insert into Customers(CustomerName, ContactName, Address, City, PostalCode, Country) " +
//                        "values('Antonio Moreno Taquería', 'Antonio Moreno', 'Mataderos 2312', 'México D.F.', '05023', 'Mexico')");
//
//                statement.execute("insert into Customers(CustomerName, ContactName, Address, City, PostalCode, Country) " +
//                        "values('Around the Horn', 'Thomas Hardy', '120 Hanover Sq.', 'London', 'WA1 1DP', 'UK')");
//
//                statement.execute("insert into Customers(CustomerName, ContactName, Address, City, PostalCode, Country) " +
//                        "values('Berglunds snabbköp', 'Christina Berglund', 'Berguvsvägen 8', 'Luleå', 'S-958 22', 'Sweden')");



            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
