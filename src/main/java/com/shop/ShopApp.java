package com.shop;

import com.shop.SessionRegister.HibernateSessionRegistery;
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


            session.getTransaction().commit();
        } catch (Exception exception){
            session.getTransaction().rollback();
        }

            session.close();
            HibernateSessionRegistery.shutdown();
    }
}
