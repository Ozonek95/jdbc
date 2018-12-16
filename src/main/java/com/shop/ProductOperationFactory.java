package com.shop;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductOperationFactory {
    private Scanner scanner;
    private Connection connection;
    private int choice;
    private Map<Integer,ProductOperation> operations;

    public ProductOperationFactory(Connection connection,Scanner scanner) {
        this.scanner = scanner;
        this.connection = connection;
        this.operations = new HashMap<>();
        operations.put(1,new ProductUpdate(scanner,connection));
        operations.put(2,new ProductShowAll(connection));
        operations.put(3,new ProductInsert(connection,scanner));
        operations.put(4,new ProductShowOne(connection,scanner));
        operations.put(5,new ProductDelete(scanner,connection));
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    ProductOperation operate(){
        return operations.get(choice);
    }
}
