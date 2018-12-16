package com.shop;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductOperationFactory {
    private Scanner scanner;
    private Connection connection;
    private int choice;
    private Map<Integer,ProductOperation> operationsMap;

    public ProductOperationFactory(Connection connection, Scanner scanner) {
        this.connection = connection;
        operationsMap = new HashMap<Integer, ProductOperation>();
        operationsMap.put(1,new ProductUpdate(scanner,connection));
        operationsMap.put(2,new ProductShowAll(connection));
        operationsMap.put(3,new ProductInsertProduct(connection,scanner));
        operationsMap.put(4,new ProductShowOne(connection,scanner));
        operationsMap.put(5,new ProductDelete(scanner,connection));
        this.scanner=scanner;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    ProductOperation giveOperationBasedOnChoice(int choice){
        return operationsMap.get(choice);
    }
}
