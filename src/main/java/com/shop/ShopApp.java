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
        controllerProduct.changeDescription(1,"nice description");
        controllerProduct.delete(productId);

            session.close();
            HibernateSessionRegistery.shutdown();
    }
}
