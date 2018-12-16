package com.shop.repository.mysql;

import com.shop.domain.Product;
import org.hibernate.Session;

public class MySqlRepositoryProduct {

    private Session session;

    public MySqlRepositoryProduct(Session session) {

        this.session = session;
    }

    public Integer save(Product product) {
        return (Integer) session.save(product);
    }

    public Product findById(int productId) {
        return session.get(Product.class,productId);
    }

    public void update(Product product) {
        session.update(product);
    }

    public void delete(Product product) {
        session.delete(product);
    }
}
