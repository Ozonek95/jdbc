package com.shop;

import java.sql.Connection;
import java.util.Scanner;

public class ProductOperationProvider {
    private Scanner scanner;
    private Connection connection;
    private int choice;

    public ProductOperationProvider(Connection connection) {
        this.scanner = scanner;
        this.connection = connection;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    ProductOperation operate(){
        if(choice==1){
            return new ProductUpdate(scanner,connection);
        }
        else if(choice==2){
            return new ProductShowAll(connection);
        }
        else if(choice==3){
            return new ProductInsertProduct(connection,scanner);
        }
        else if(choice==4){
            return new ProductShowOne(connection,scanner);
        }
        else if(choice==5){
            return new ProductDelete(scanner,connection);
        }
        return null;
    }
}
