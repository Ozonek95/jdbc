package com.shop.repository.mysql;

import com.shop.domain.Warehouse;
import org.hibernate.Session;

public class MySqlRepositoryWarehouse {
    private Session session;

    public MySqlRepositoryWarehouse(Session session) {
        this.session = session;
    }

    public Integer create(Warehouse warehouse) {
       return (Integer) session.save(warehouse);
    }
}
