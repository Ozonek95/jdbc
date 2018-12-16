package com.shop;

import com.shop.controller.ControllerProduct;
import com.shop.controller.ControllerWarehouse;
import com.shop.domain.Warehouse;
import com.shop.hibernate.HibernateSessionRegistery;
import com.shop.repository.mysql.MySqlRepositoryProduct;
import com.shop.repository.mysql.MySqlRepositoryWarehouse;
import org.hibernate.Session;

public class ShopApp {
    public static void main(String[] args) {
        Session session =
                HibernateSessionRegistery
                        .getSessionFactory()
                        .openSession();

        MySqlRepositoryProduct mySqlRepositoryProduct = new MySqlRepositoryProduct(session);
        MySqlRepositoryWarehouse mySqlRepositoryWarehouse = new MySqlRepositoryWarehouse(session);
        ControllerProduct controllerProduct = new ControllerProduct(session, mySqlRepositoryProduct);
        ControllerWarehouse controllerWarehouse = new ControllerWarehouse(mySqlRepositoryWarehouse,session);
        String name ="new name";
        Integer warehouseId = 1;
       // controllerWarehouse.changeName(warehouseId,name);
        Warehouse warehouse = controllerWarehouse.find(warehouseId);
        System.out.println(warehouse);
            session.close();
            HibernateSessionRegistery.shutdown();
    }
}
