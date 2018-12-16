package com.shop;

import com.shop.controller.ControllerProduct;
import com.shop.hibernate.HibernateSessionRegistery;
import com.shop.domain.Product;
import com.shop.repository.mysql.MySqlRepositoryProduct;
import org.hibernate.Session;

public class ShopApp {
    public static void main(String[] args) {
        Session session =
                HibernateSessionRegistery
                        .getSessionFactory()
                        .openSession();

        MySqlRepositoryProduct mySqlRepositoryProduct = new MySqlRepositoryProduct(session);
        ControllerProduct controllerProduct = new ControllerProduct(session, mySqlRepositoryProduct);
        Integer productId = controllerProduct.create("ALE JESTEM","EKSTRA");
        Product product = controllerProduct.find(1);
        System.out.println(product);
        System.out.println(productId);

            session.close();
            HibernateSessionRegistery.shutdown();
    }
}
