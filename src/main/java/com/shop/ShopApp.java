package com.shop;

import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.Scanner;

public class ShopApp {


    private static String PASS = "student1";
    private static String USER = "student1";
    private static String DB_URL = "jdbc:mysql://localhost/shop";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //DRIVER
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //CONNECTION
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //STATEMENT

        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        updateProduct(connection,scanner);


        //CLOSE CONNECTION
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateProduct(Connection connection, Scanner scanner) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("UPDATE PRODUCTS SET CATALOG_NUMBER = ?, NAME = ?, DESCRIPTION = ? WHERE PRODUCT_ID = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Give product ID");
        int productId = Integer.parseInt(scanner.nextLine());
        System.out.println("Give new catalog number");
        String catalogNumber = scanner.nextLine();
        System.out.println("Give new product name");
        String name = scanner.nextLine();
        System.out.println("Give new description");
        String description = scanner.nextLine();

        try {
            preparedStatement.setString(1,catalogNumber);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,description);
            preparedStatement.setInt(4,productId);
            int updated = preparedStatement.executeUpdate();

            System.out.println("We updated :"+updated+" products");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void insertProduct(Statement statement) {

        PreparedStatement preparedStatement = null;
        try {
            int inserted = statement.executeUpdate("INSERT INTO PRODUCTS VALUES " + "(1,123456,'first product',null)");
            System.out.println(inserted +" new products added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //RESULT SET

    private static void findAll(Statement statement, Scanner scanner) {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery("SELECT product_id,name FROM PRODUCTS");
            while (resultSet.next()){

                int productId = resultSet.getInt("product_id");
                String name = resultSet.getString("name");

                System.out.println("Product with id: "+productId+" and name: "+name+".");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void workOnDataBase(Scanner scanner){
        System.out.println("Do You want to update?(press: 1), or show all in products?(press: 2)");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:


        }
    }

}
