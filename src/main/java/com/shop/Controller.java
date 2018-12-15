package com.shop;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Controller {

   private Connection connection;
    private Statement statement;
    private DBProductsOperations dbProductsOperations;
    private Scanner scanner;
    private PrintOptionsOnConsole printOptionsOnConsole;

    public Controller(Connection connection, DBProductsOperations dbProductsOperations, Scanner scanner, PrintOptionsOnConsole printOptionsOnConsole) {
        this.connection = connection;
        try {
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.dbProductsOperations = dbProductsOperations;
        this.scanner = scanner;
        this.printOptionsOnConsole = printOptionsOnConsole;

    }


    public void workOnDataBase() {
        while (true) {
            printOptionsOnConsole.printOption("To update choose 1");
            printOptionsOnConsole.printOption("To show all choose 2");
            printOptionsOnConsole.printOption("To insert choose 3");
            printOptionsOnConsole.printOption("To show specific product choose 4");
            printOptionsOnConsole.printOption("To delete choose 5");
            printOptionsOnConsole.printOption("Choose something else to exit.");
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

