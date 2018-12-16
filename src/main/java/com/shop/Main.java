package com.shop;
import java.sql.Connection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection connection = ConnectionProvider.giveConnection();
        Controller controller = new Controller(connection, new ProductOperationFactory(connection,scanner),scanner, new PrintOptionsOnConsole());
        controller.workOnDataBase();
    }
}
