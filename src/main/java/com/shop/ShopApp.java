package com.shop;

import com.shop.SessionRegister.HibernateSessionRegistery;
import com.shop.domain.Product;
import com.shop.domain.Warehouse;
import org.hibernate.Session;

public class ShopApp {
    public static void main(String[] args) {
        Session session =
                HibernateSessionRegistery
                        .getSessionFactory()
                        .openSession();
        try {
            session.getTransaction().begin();

            //operation
            //name
            //catalog number
            //description null

            Product codBlackOpsIv = new Product("COD Black Ops IV", "COD-d1023");
            codBlackOpsIv.setDescription("Super giera");

            String name = "Magazyn Stokrotka";
            String street = "Gromadzka";
            String city = "Kraków";
            String postal = "43-502";
            String buildingNumber = "46A";
            String country = "Poland";
            Warehouse warehouse = new Warehouse(name,street,city,postal,buildingNumber,country);

            Integer productId = (Integer) session.save(codBlackOpsIv);
            System.out.println(productId);

            session.getTransaction().commit();
        } catch (Exception exception){
            exception.printStackTrace();
            session.getTransaction().rollback();
        }

            session.close();
            HibernateSessionRegistery.shutdown();
    }
}
