package com.shop;

import com.mysql.jdbc.Connection;

public class Controller {
    Connection connection;

    public Controller(Connection connection) {
        this.connection = (Connection) ConnectionProvider.giveConnection();
    }


}
