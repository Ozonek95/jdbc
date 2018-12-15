package com.shop;

import com.mysql.jdbc.Connection;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Controller {

   private java.sql.Connection connection;
    private Statement statement;
    private DBProductsOperations dbProductsOperations = new DBProductsOperations(connection);
    private Scanner scanner = new Scanner(System.in);

    public Controller(Connection connection) {
        this.connection = connection;
        try {
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void workOnDataBase() {
        while (true) {
            System.out.println("To update choose 1");
            System.out.println("To show all choose 2");
            System.out.println("To insert choose 3");
            System.out.println("To show specific product choose 4");
            System.out.println("To delete choose 5");
            System.out.println("Choose something else to exit.");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    dbProductsOperations.updateProduct(connection, scanner);
                    break;
                case 2:
                    dbProductsOperations.findAll(statement);
                    break;
                case 3:
                    dbProductsOperations.insertProduct(connection, scanner);
                    break;
                case 4:
                    dbProductsOperations.showProduct(scanner, connection);
                    break;
                case 5:
                    dbProductsOperations.deleteProcuct(scanner, connection);
                    break;
                default:
                    return;

            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

