package com.shop;

import java.sql.Connection;
import java.util.Scanner;

public interface ProductOperation {
    void process();
    void setScanner(Scanner scanner);
    void setConnection(Connection connection);

}
