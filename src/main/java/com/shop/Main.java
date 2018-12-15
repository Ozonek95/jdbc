package com.shop;
import java.sql.Connection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Connection connection = ConnectionProvider.giveConnection();
        Controller controller = new Controller(connection, new DBProductsOperations(connection), new Scanner(System.in));
        controller.workOnDataBase();
    }
}