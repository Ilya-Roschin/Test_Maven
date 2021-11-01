package com.java.training.app.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DevelopersJdbc {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/javashema";
    static final String USER = "root";
    static final String PASSWORD = "Password_123386_";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Connection connection = null;
        Statement statement = null;

        System.out.println("Registering JDBC driver...");

        Class.forName("com.mysql.cj.jdbc.Driver");

        System.out.println("Creating database connection...");
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

        System.out.println("Executing statement...");

        statement = connection.createStatement();
        sqlDeleteById(statement, 1);
        sqlInsert(statement, "Kirill", 21);
        sqlSet(statement);
        statement.close();
    }

    public static void sqlSet(Statement statement) throws SQLException {
        final String sql = "SELECT * FROM user";

        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println("Retrieving data from database...");
        System.out.println("\nuser:");
        while (resultSet.next()) {
            long id = resultSet.getLong("iduser");
            String userName = resultSet.getString("username");
            int age = resultSet.getInt("age");

            System.out.println("\n================\n");
            System.out.println("id: " + id);
            System.out.println("Name: " + userName);
            System.out.println("Age: " + age);
        }

        System.out.println("Closing connection and releasing resources...");
        resultSet.close();

    }

    public static void sqlDeleteById(Statement statement, int id) throws SQLException {
        final String sql = "DELETE FROM user WHERE iduser = " + id;
        statement.executeUpdate(sql);
        System.out.println("User " + "'" + id + "' deleted");
    }

    public static void sqlInsert(Statement statement, String name, int age) throws SQLException {
        String sql = "INSERT user (userName, age) VALUES " + "('" + name + "', '" + age + "')";
        statement.executeUpdate(sql);
    }

}
