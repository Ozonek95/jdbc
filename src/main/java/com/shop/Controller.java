package com.shop;


import java.sql.Connection;
import java.util.Scanner;

class Controller {

    private Connection connection;
    private ProductOperationProvider productOperationProvider;
    private Scanner scanner;
    private PrintOptions printOptionsOnConsole;

    Controller(Connection connection, ProductOperationProvider productOperationProvider, Scanner scanner, PrintOptions printOptionsOnConsole) {
        this.connection = connection;
        this.productOperationProvider = productOperationProvider;
        this.scanner = scanner;
        this.printOptionsOnConsole = printOptionsOnConsole;

    }


    void workOnDataBase() {
        while (true) {
            printOptionsOnConsole.printOption("To update choose 1");
            printOptionsOnConsole.printOption("To show all choose 2");
            printOptionsOnConsole.printOption("To insert choose 3");
            printOptionsOnConsole.printOption("To show specific product choose 4");
            printOptionsOnConsole.printOption("To delete choose 5");
            printOptionsOnConsole.printOption("Choose something else to exit.");
            int choice = Integer.parseInt(scanner.nextLine());
            productOperationProvider.setChoice(choice);
            productOperationProvider.setScanner(scanner);
            productOperationProvider.operate().process();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

