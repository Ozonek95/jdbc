package com.shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductUpdate implements ProductOperation {
    private Connection connection;
    private Scanner scanner;

    public ProductUpdate(Scanner scanner,Connection connection) {
        this.connection = connection;
        this.scanner = scanner;
    }

    public ProductUpdate(){}

    public void process() {
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
                preparedStatement.setString(1, catalogNumber);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, description);
                preparedStatement.setInt(4, productId);
                int updated = preparedStatement.executeUpdate();

                System.out.println("We updated :" + updated + " products");
            } catch (SQLException e) {
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

        this.connection=connection;
    }

}
