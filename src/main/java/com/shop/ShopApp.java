package com.shop;

import com.shop.controller.ControllerProduct;
import com.shop.controller.ControllerWarehouse;
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
        String name = "Random";
        String street="Warehouse";
        String city="From";
        String postal="3124";
        String buildingNumber="Xity";
        String country="Nibylandia";

        Integer warehouseId = controllerWarehouse.create(name,street,city,postal,buildingNumber,country);
        System.out.println(warehouseId);

            session.close();
            HibernateSessionRegistery.shutdown();
    }
}
