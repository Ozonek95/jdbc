package com.shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductDelete implements ProductOperation {
    private Connection connection;
    private Scanner scanner;

    public ProductDelete(Scanner scanner,Connection connection) {
        this.connection = connection;
        this.scanner = scanner;
    }

    public void process() {
        System.out.println("Give ID of product You want to delete");
        int productId = Integer.parseInt(scanner.nextLine());
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM PRODUCTS WHERE PRODUCT_ID = ?");
            preparedStatement.setInt(1, productId);
            int deleted = preparedStatement.executeUpdate();
            System.out.println("You have deleted " + deleted + " items.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

