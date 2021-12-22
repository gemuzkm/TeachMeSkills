package com.lesson18;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/userdb?useUnicode=true&serverTimezone=UTC";
        String username = "root";
        String password = "admin";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                Statement statement = connection.createStatement();

//                statement.execute("create table users(" +
//                        "id int auto_increment primary key," +
//                        "name varchar(30) not null," +
//                        "age int not null" +
//                        ")");



//                statement.execute("insert into users(name, age) " +
//                        "values ('vasya', 50)");
//                statement.execute("insert into users(name, age) " +
//                        "values ('petya', 30)");
//                ResultSet resultSet =  statement.executeQuery("select * from  users where age > 20 and id = 1");
//                while (resultSet.next()) {
//                    System.out.println("id - " + resultSet.getInt(1) +
//                            ", name - " + resultSet.getString(2) +
//                            ", age - " + resultSet.getInt(3));
//                }
//                PreparedStatement preparedStatement = connection.prepareStatement("insert into users (name, age) values (?,?)");
//                preparedStatement.setString(1,"misha");
//                preparedStatement.setInt(2,15);
//                preparedStatement.execute();
//
//                Statement statement = connection.createStatement();
//                ResultSet resultSet = statement.executeQuery("select * from users");

//                Statement deleteStatement = connection.createStatement();
//                deleteStatement.execute("delete from  users where id = 2");
//
//                Statement statement = connection.createStatement();
//                ResultSet resultSet = statement.executeQuery("select * from users");
//                while (resultSet.next()) {
//                    System.out.println("id - " + resultSet.getInt(1) +
//                            ", name - " + resultSet.getString(2) +
//                            ", age - " + resultSet.getInt(3));
//                }
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
