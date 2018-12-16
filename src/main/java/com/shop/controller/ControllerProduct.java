package com.shop.controller;

import com.shop.domain.Price;
import com.shop.domain.Product;
import com.shop.repository.mysql.MySqlRepositoryProduct;
import org.hibernate.Session;

import java.util.List;

public class ControllerProduct {

    private final Session session;
    private final MySqlRepositoryProduct mySqlRepositoryProduct;

    public ControllerProduct(Session session, MySqlRepositoryProduct mySqlRepositoryProduct) {

        this.session = session;
        this.mySqlRepositoryProduct = mySqlRepositoryProduct;
    }

    public Integer create(String name, String catalogNumber) {
        Integer id = null;
        try {
            session.getTransaction().begin();

            id = mySqlRepositoryProduct
                            .save(new Product(new Price(13, "PLN"), name, catalogNumber));

            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
            session.getTransaction().rollback();
        }
        return id;
    }

    public Product find(int productId){
        return mySqlRepositoryProduct.findById(productId);
    }


    public void changeDescription(Integer productId, String description) {
        Product product = find(productId);
        product.changeDescription(description);
        try {
            session.getTransaction().begin();

            mySqlRepositoryProduct.update(product);

            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
            session.getTransaction().rollback();
        }

    }

    public void delete(Integer productId) {
        Product product = find(productId);
        try {
            session.getTransaction().begin();

            mySqlRepositoryProduct.delete(product);

            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
            session.getTransaction().rollback();
        }

    }

    public List<Product> findAll() {
        return mySqlRepositoryProduct.findAll();
    }
}
