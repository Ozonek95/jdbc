package com.shop;

import com.shop.hibernate.HibernateSessionRegistery;
import com.shop.domain.Product;
import com.shop.domain.Warehouse;
import com.shop.repository.mysql.MySqlRepositoryProduct;
import org.hibernate.Session;

public class ShopApp {
    public static void main(String[] args) {
        Session session =
                HibernateSessionRegistery
                        .getSessionFactory()
                        .openSession();

        Product codBlackOpsIv = new Product("COD Black Ops IV", "COD-d1023");
        codBlackOpsIv.setDescription("Super giera");

        String name = "Magazyn Stokrotka";
        String street = "Gromadzka";
        String city = "Kraków";
        String postal = "43-502";
        String buildingNumber = "46A";
        String country = "Poland";
        Warehouse warehouse = new Warehouse(name,street,city,postal,buildingNumber,country);



        try {
            session.getTransaction().begin();

            Integer product = new MySqlRepositoryProduct(session).save(new Product("Bulbazayr","d1245-22"));
            System.out.println(product);


            session.getTransaction().commit();
        } catch (Exception exception){
            exception.printStackTrace();
            session.getTransaction().rollback();
        }

            session.close();
            HibernateSessionRegistery.shutdown();
    }
}
