package com.shop;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductShowAll implements ProductOperation {
    Connection connection;

    public ProductShowAll(Connection connection) {
        this.connection = connection;
    }

    public void process() {
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
