package com.shop;

import com.shop.controller.ControllerProduct;
import com.shop.controller.ControllerWarehouse;
import com.shop.domain.Owner;
import com.shop.domain.Product;
import com.shop.domain.Warehouse;
import com.shop.hibernate.HibernateSessionRegistery;
import com.shop.repository.mysql.MySqlRepositoryProduct;
import com.shop.repository.mysql.MySqlRepositoryWarehouse;
import org.hibernate.Session;

import java.util.List;

public class ShopApp {
    public static void main(String[] args) {
        Session session =
                HibernateSessionRegistery
                        .getSessionFactory()
                        .openSession();

        MySqlRepositoryWarehouse mySqlRepositoryWarehouse = new MySqlRepositoryWarehouse(session);
        ControllerWarehouse controllerWarehouse = new ControllerWarehouse(mySqlRepositoryWarehouse,session);
        MySqlRepositoryProduct mySqlRepositoryProduct = new MySqlRepositoryProduct(session);
        ControllerProduct controllerProduct = new ControllerProduct(session,mySqlRepositoryProduct);
        controllerWarehouse.create("Magazyn","dawfaw","fawfa","dd","dawgawg","dw",new Owner("Kacpi","male"));
       // List<Product> productsList = controllerProduct.findAll();
        List<Warehouse> warehouses = controllerWarehouse.findAll();
        warehouses.forEach(System.out::println);

            session.close();
            HibernateSessionRegistery.shutdown();
    }
}
