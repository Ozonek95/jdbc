package com.shop;

import java.sql.*;
import java.util.Scanner;

public class DBProductsOperations {
    private Connection connection;

    public DBProductsOperations(Connection connection) {
        this.connection = connection;
    }

    void updateProduct(Connection connection, Scanner scanner) {
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

    void insertProduct(Connection connection, Scanner scanner) {

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
            preparedStatement = connection.prepareStatement("INSERT INTO PRODUCTS VALUES(?,?,?,?)");
            preparedStatement.setInt(1, productId);
            preparedStatement.setString(2, catalogNumber);
            preparedStatement.setString(3, productName);
            preparedStatement.setString(4, description);
            int inserted = preparedStatement.executeUpdate();
            System.out.println(inserted + " new products added.");
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

    void showProduct(Scanner scanner, Connection connection) {
        System.out.println("Give product ID");
        int productId = Integer.parseInt(scanner.nextLine());
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM PRODUCTS WHERE PRODUCT_ID = ?");
            preparedStatement.setInt(1, productId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet resultSet = null;
        try {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String catalogNumber = resultSet.getString("catalog_number");
                String description = resultSet.getString("description");

                System.out.println(name + " " + catalogNumber + " " + description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    void deleteProcuct(Scanner scanner, Connection connection) {
        System.out.println("Give ID of product You want to delete");
        int productId = Integer.parseInt(scanner.nextLine());
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM PRODUCTS WHERE PRODUCT_ID = ?");
            preparedStatement.setInt(1, productId);
            int deleted = preparedStatement.executeUpdate();
            System.out.println("You have deleted "+deleted+" items.");
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

    //RESULT SET

    void findAll(Statement statement) {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery("SELECT * FROM PRODUCTS");
            while (resultSet.next()) {

                int productId = resultSet.getInt("product_id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");

                System.out.println("Product with id: " + productId + " and name: " + name + " description :" + description);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
