package com.shop;
import java.sql.Connection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Connection connection = ConnectionProvider.giveConnection();
        Controller controller = new Controller((com.mysql.jdbc.Connection) connection);
        controller.workOnDataBase();
    }
}
