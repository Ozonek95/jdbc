package com.shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductInsertProduct implements ProductOperation {
   private Connection connection;
   private Scanner scanner;

    public ProductInsertProduct(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner=scanner;
    }

    public void process() {
        System.out.println("Give product ID");
        int productId = Integer.parseInt(scanner.nextLine());
        System.out.println("Give catalog number");
        String catalogNumber = scanner.nextLine();
        System.out.println("Give product name");
        String productName = scanner.nextLine();
        System.out.println("Give description");
        String description = scanner.nextLine();
        PreparedStatement preparedStatement = null;
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("INSERT INTO PRODUCTS VALUES(?,?,?,?)");
            preparedStatement.setInt(1, productId);
            preparedStatement.setString(2, catalogNumber);
            preparedStatement.setString(3, productName);
            preparedStatement.setString(4, description);
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
}
