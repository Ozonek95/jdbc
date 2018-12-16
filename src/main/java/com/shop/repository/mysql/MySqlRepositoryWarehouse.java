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

    public Warehouse findById(Integer warehouseId) {
        return session.get(Warehouse.class,warehouseId);
    }

    public void update(Warehouse warehouse) {
        session.update(warehouse);
    }

    public void delete(Warehouse warehouse) {
        session.delete(warehouse);
    }
}
