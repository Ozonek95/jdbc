package com.shop;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductOperationFactory {
    private Scanner scanner;
    private Connection connection;
    private int choice;
    private Map<Integer,ProductOperations> operations;

    public ProductOperationFactory(Connection connection,Scanner scanner) {
        this.scanner = scanner;
        this.connection = connection;
        this.operations = new HashMap<>();
        operations.put(1,ProductOperations.UPDATE);
        operations.put(2,ProductOperations.SHOW_ALL);
        operations.put(3,ProductOperations.INSERT);
        operations.put(4,ProductOperations.SHOW_ONE);
        operations.put(5,ProductOperations.DELETE);
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    ProductOperation operate(){
        ProductOperation operation = operations.get(choice).getOperation();
        operation.setScanner(scanner);
        operation.setConnection(connection);
        return operation;
    }
}
