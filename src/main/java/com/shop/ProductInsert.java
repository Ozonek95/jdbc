package com.shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductInsert implements ProductOperation {
   private Connection connection;
   private Scanner scanner;

    public ProductInsert(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner=scanner;
    }

    public ProductInsert(){

    }
    public void process() {

        System.out.println("Give catalog number");
        String catalogNumber = scanner.nextLine();
        System.out.println("Give product name");
        String productName = scanner.nextLine();
        System.out.println("Give description");
        String description = scanner.nextLine();
        PreparedStatement preparedStatement = null;
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("INSERT INTO PRODUCTS(catalog_number,name,description) VALUES(?,?,?)");
            preparedStatement.setString(1, catalogNumber);
            preparedStatement.setString(2, productName);
            preparedStatement.setString(3, description);
            int inserted = preparedStatement.executeUpdate();
            connection.commit();
            System.out.println(inserted + " new products added.");
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void setScanner(Scanner scanner) {
        this.scanner=scanner;
    }

    @Override
    public void setConnection(Connection connection) {

        this.connection = connection;
    }
}
